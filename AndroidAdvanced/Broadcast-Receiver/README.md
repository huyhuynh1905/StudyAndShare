<h1 align="center">Broadcast Receiver Trong Android</h1>

### Nội dung
1. [***Broadcast Receiver là gì?***](#muc1) 
2. [***Broadcast Receiver khai báo trong AndroidMainifest.xml***](#muc2)
3. [***Broadcast Receiver khai báo bằng Code***](#muc3)
4. [***Custom Sending Broadcast Receiver***](#muc4)

> Document Broadcast Receiver xem [tại đây](https://developer.android.com/guide/components/broadcasts)

<a name="muc1"></a>
## 1. Broadcast Receiver là gì?
- Android Broadcast Receiver là một thành phần nơi bạn có thể đăng ký sự kiện của hệ thống hay ứng dụng. Bạn sẽ nhận được thông báo về các sự kiện đã đăng ký trước đó. Việc phát tin broadcast có thể bắt nguồn từ hệ thống hoặc từ các ứng dụng.
- Không giống như Activity, Broadcast receiver trong android không hề có giao diện người dùng. Mặc dù nó có thể tạo thông báo trên thanh status bar.
- Để đăng ký một sự kiện lắng nghe với Broadcast Receiver thì chúng ta sẽ có 2 cách phổ biến nhất hiện nay, đó là:
	-   Đăng ký trong AndroidManifest.xml (Tĩnh)
	-   Đăng ký bằng Java code (Động)
- Thông thường cách 1 được sử dụng nhiều hơn đó chính là cách đầu tiên, sử dụng trong AndroidMainifest, tại vì khi các bạn thiết lập trong đây thì ứng dụng không cần khởi chạy mà vẫn có thể lắng nghe được các sự kiện và khởi chạy.

<a name="muc2"></a>
## 2. Broadcast Receiver khai báo trong AndroidMainifest.xml

- Là cách chúng ta khai báo Broadcast Receiver trong Manifest và khi lần đầu khởi chạy ứng dụng thì nó sẽ đăng ký Broadcast và cứ thế nó start cho đến khi các bạn XOÁ ứng dụng đi.Nó vẫn lắng nghe khi các bạn đã tắt ứng dụng đi luôn nhé đây là ưu điểm của cách đăng ký này.
- Ví dụ (Ví dụ này để nhận thông báo về sự kiện tắt mở kết nối mạng): 
	>Đầu tiên khai báo một thẻ `<receiver>` trong thẻ `<application>` của file `AndroidMainifest.xml` như sau (Sau này muốn lắng nghe nhiều hơn các sự kiện khác có thể tạo nhiều receiver hoặc thêm các acction khác vào receiver này nếu có cùng xử lí thông báo trong class `MyReceiver`):

	```xml
	<receiver android:name=".MyReceiver">
		<intent-filter>
			<action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
		</intent-filter>
	</receiver>
	```
	>Tạo một class có tên `MyReceiver` trùng tên với tên trong `receiver` khai báo ở trên Mainifest, class này **extends** một Abstract class `BroadcastReceiver`:
 <div align="center"><img  src="https://i.imgur.com/LD9SjZU.png"/></div>

> Ví dụ ở đây trong code xử lí mình viết một Toast lên màn hình thông báo tắt mở mạng:



```java
	public class MyReceiver extends BroadcastReceiver {  
	    @Override  
	  public void onReceive(Context context, Intent intent) {  
	        //Code xử lí nếu có thay đổi mạng  
	  Toast.makeText(context,"Mạng On/Off",Toast.LENGTH_LONG).show();  
	  }  
	}
```

- Ứng dụng này sẽ không chạy trên các máy android 7.0 (API 24) trở lên vì đã bị loại bỏ để tối ưu hoá hiệu năng và pin của điện thoại, tham khảo thêm thông tin [tại đây](https://developer.android.com/about/versions/nougat/android-7.0-changes.html#bg-opt).


<a name="muc3"></a>
## 3. Broadcast Receiver khai báo bằng Code.

- Từ trên ta có thể thấy không thể dùng cách khai báo trên file Mainifest nữa, vậy ta có thể dùng code để `registerReceiver()` lắng nghe các thông báo từ máy. Tuy nhiên đối với cách này thì khi kill app sẽ không còn lắng nghe gì được nữa.
- Cùng với ví dụ ở trên, trong `AndroidMainifest.xml` ta xoá đi thẻ `<receiver>`, ta vẫn giữ lại class `MyReceiver` với đoạn code Toast lên thông báo như cũ:
```java
public class MyReceiver extends BroadcastReceiver {  
    @Override  
  public void onReceive(Context context, Intent intent) {  
        //Code xử lí nếu có thay đổi mạng  
  Toast.makeText(context,"Mạng On/Off",Toast.LENGTH_LONG).show();  
  }  
}
```

- Trong class `MainActivity` chính ta viết một phương thức `initBroadcastReceiverNetworkChange()` để viết code lắng nghe sự kiện tắt mở mạng.
```java
//Khởi tạo nhận thông báo lắng nghe thay đổi mạng  
public void initBroadcastReceiverNetworkChange(){  
    myReceiver = new MyReceiver();  //biến khai báo toàn cục ở đầu class
	IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");  
  //Có thể thêm các action có liên quan đến thay đổi mạng bằng add  
	filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED); //Chế độ máy bay  
	registerReceiver(myReceiver, filter);  
}
``` 

- Trong các phương thức `onStart()` và `onPause()` tiến hành chạy đăng kí lắng nghe sự kiện và ngừng đăng kí lắng nghe sự kiện:
```java
    @Override
    protected void onStart() {
        super.onStart();
        initBroadcastReceiverNetworkChange();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Phải huỷ đăng kí lắng nghe khi dừng activity để tránh crash app
        unregisterReceiver(myReceiver);
    }
```
- Khởi chạy ứng dụng thử tắt mở mạng xem kết quả.


<a name="muc4"></a>
## 4. Custom Sending Broadcast Receiver.

- Mình có thể thay đổi acction phù hợp cho ứng dụng của mình, cũng như send các thông tin, thông báo thông qua lắng nghe sự kiện.
- Ví dụ mình có một button khi nhấn vào sẽ được hiện thông báo lên data được truyền trong intent:
> Đầu tiên trong `MainActivity` ta code các phương thức custom lại lắng nghe theo action của mình và code khi nhấn vào button sẽ truyền các dữ liệu data theo intent:

```java
public static final String CUSTOM_BR = "customBR";  
//Lắng nghe sự kiện khi bấm button  
public void customBroadCastReceiver(){  
    myReceiver = new MyReceiver();  
  IntentFilter filter = new IntentFilter();  
  filter.addAction(CUSTOM_BR);  
  registerReceiver(myReceiver, filter);  
}  
//Code khi bấm vào button  
public void sendingBroadcastReceiver(View view) {  
    Intent intent = new Intent();  
  intent.setAction(CUSTOM_BR);  
  intent.putExtra("data","Notice me senpai!");  
  sendBroadcast(intent);  
}
```

> Ta vẫn phải gọi phương thức `customBroadCastReceiver()` trong `onStart()` và `unregisterReceiver(myReceiver);` trong `onPause()`. Code xử lí ở class `MyReceiver` ta viết lại:
```java
public class MyReceiver extends BroadcastReceiver {  
    @Override  
  public void onReceive(Context context, Intent intent) {  
        //Code xử lí custom Acction  
  if (intent.getAction().equals(MainActivity.CUSTOM_BR)){  
            String data = intent.getStringExtra("data");  
  Toast.makeText(context,data,Toast.LENGTH_LONG).show();  
  }  
    }  
}
```
> Kết quả sẽ hiện ra dòng thông báo đã truyền.