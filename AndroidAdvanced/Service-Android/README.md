
<h1 align="center">Service Trong Android</h1>

### Nội dung
1. [***Service là gì?***](#muc1) 
2. [***Start Service.***](#muc2)
3. [***Bound Service.***](#muc3)

<a name="muc1"></a>
## 1. Service là gì?
- Là một **component** chính trong android với nhiệm vụ là thực hiện các tác vụ ngầm bên dưới hệ điều hành mà không cần người dùng phải tương tác và thậm chí nó vẫn hoạt động khi mà thành phần tạo ra nó bị huỷ đi và cả khi ứng dụng bị tắt hoàn toàn.
- Một Service sẽ có một vòng đời riêng của nó từ lúc tạo ra cho đến khi bị huỷ đi, và thông thường Service sẽ có 2 loại chính tương ứng với 2 cách gọi service khác nhau mà hôm nay chúng ta sẽ đi tìm hiểu đó là **Started Service** (không ràng buộc) và **Bound Service** (ràng buộc)**.**
- Vòng đời của 2 loại service:
<div align="center"><img  src="https://www.tutorialspoint.com/android/images/services.jpg"/></div>

- **Started Service** - Không ràng buộc bởi vì từ khi gọi nó cho đến onDestroy thì không thể tương tác được với nó, không thể khiến nó trả về các giá trị để update lên UI.
- **Bound Service** - Cung cấp interface giúp tương tác qua service, có thể update lên UI.
<a name="muc2"></a>
## 2. Started Service. (Không ràng buộc)
- Service này sẽ start bằng cách gọi phương thức **startService(),** sau đó phương thức **onCreate()** sẽ được gọi, nó chỉ gọi 1 lần duy nhất khi khởi tạo service thôi , nếu như start lại lần nữa thì nó sẽ không được gọi nữa.
- Sau khi chạy vào hàm **onCreate()** được gọi thì nó sẽ chạy vào hàm **onStartCommand()** để thực hiện những hành động ở đây. Code xử lí của service này được đặt ở đây, phương thức này return về một giá trị int trong 3 giá trị sau:
	- **START_STICKY** bảo với hệ điều hành rằng cần tạo lại service khi có đủ bộ nhớ và call lại onStartCommand() với intent là null (thường áp dung cho các service không truyền dữ liệu gì qua intent).
	- **START_NOT_STICKY:** chỉ áp dụng khi Service bị huỷ khi chưa thực hiện xong do điện thoại hết bộ nhớ hay vì một lí do nào đó thì lại bảo với Hệ điều hành rằng không cần tạo lại service.
	- **START_REDELIVER_INTENT** để bảo với hệ điều hành rằng sẽ tạo lại service với intent như cũ đến *onStartCommand()*. (Giá trị trả về này có thời gian thực hiện khá lâu so với 2 giá trị trả về trên)
	>Chú ý: 2 trường hợp đầu chỉ thực hiện khi Service bị huỷ khi chưa thực hiện xong do điện thoại hết bộ nhớ hay vì một lí do nào đó.

- Để sử dụng **Start Service** thì phải khai báo service trong thẻ `<application>` của `AndroidMainifest.xml` trước: 
	```xml
	<service android:name=".service.MyStartService"/>
	```
	> Dòng trên chỉ ra mình khai báo một Service chỉ đến class có tên `MyStartService` trong package **service**.

<div align="center"><img  src="https://i.imgur.com/FtblG1l.png"/></div>

- Trong class `MyStartService` extends lại class `Service` với các thành phần @Override:
```java
public class MyStartService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Đây là phương thức bắt buộc viết lại khi extend, phương thức này dành cho Bound Service
        return null;
    }

    @Override
    public void onCreate() {
        //Phương thức này chỉ chạy một lần duy nhất khi khởi chạy Service
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Phương thức này chứa code xử lí cho service đang chạy
        //ở đây sẽ return về một trong các giá trị như:
        //return START_STICKY;
        //return START_NOT_STICKY;
        //return START_REDELIVER_INTENT;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //Phương thức này xử lí code khi service kết thúc
        super.onDestroy();
    }
}
```

- Giả sử ứng dụng này có 2 button *Start* và *Stop* Service thì code trong MainActivity là:
```java
		btnStart = findViewById(R.id.btnStart);
        btnDes = findViewById(R.id.btnDes);
        //Khai báo intent service
        final Intent intent = new Intent(this, MyStartService.class);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"btnStart!",Toast.LENGTH_LONG).show();
                //put một data
                intent.putExtra("data","Data from Intent");
                startService(intent);
            }
        });
        btnDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"btnStop!",Toast.LENGTH_LONG).show();
                stopService(intent);
            }
        });
```

<a name="muc3"></a>
## 3. Bound Service. (Có ràng buộc)

- Với loại service này thì khi gọi không dùng phương thức **startService()** mà thay vào đó sẽ gọi phương thức **bindService(),** lúc này nó sẽ vẫn chạy vào phương thức **onCreate()**
- Sau đó phương thức **onBind()** sẽ được gọi thay vì cách 1 là phương thức **onStartCommand(),** phương thức này sẽ trả về môt **IBinder** (Code phía dưới sẽ nói rõ).
- Để huỷ bound servive này chúng ta sẽ gọi phương thức **unbindService()**_**,**_ lúc này hàm **onUnbind()** sẽ được gọi và tiếp theo đó là phương thức **onDestroy()** cũng sẽ được gọi theo luôn.Lúc này bạn đã huỷ kết nối với service và service sẽ không còn chạy nữa khi đã vào tới **onDestroy()**.
- Để sử dụng được **BoundService** thì cũng như **StartService** ta cũng phải khai báo `<service>` trong `AndroidMainifest.xml`
```xml
<service android:name=".service.MyBoundService"/>
```
<div align="center"><img  src="https://i.imgur.com/cdYT2Bs.png"/></div>

- Nội dung của class `MyBoundService`:
```java
public class MyBoundService extends Service {

    private IBinder binder = new ExampleBinder();

    @Override
    public void onCreate() {
        Toast.makeText(this,"onCreate BoundService! ",Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Phương thức này trả về chính là Interface để thao tác với service
        Toast.makeText(this,"onBind BoundService! ",Toast.LENGTH_LONG).show();
        return binder; //nó sẽ truyền về onServiceConnected() bên MainActivity
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"onUnbind BoundService! ",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"onDestroy BoundService! ",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public class ExampleBinder extends Binder{
        //Phương thức và class này trả về các đối tượng thao tác trong BoundService
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }

    public void getDataAfterGetService(){
        //Phương thức này có thể được gọi ở onServiceConnected() bên kia sau khi
        //lấy được bider trả về ở onBind()
        Toast.makeText(this,"getDataAfterGetService! ",Toast.LENGTH_LONG).show();
    }
}
```

- Các phương thức khai báo trong `MainActivity` để sử dụng BoundService:
```java

    private MyBoundService myBoundService = null;
    private void myServiceBoundService() {
        final Intent intent = new Intent(this, MyBoundService.class);
        btnBoundStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            }
        });
        btnBoundStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });
    }

    //Phương thức service phải khai báo biến serviceConnection
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //Phương thức này được gọi khi service được kết nối (sau onBind)
            MyBoundService.ExampleBinder binder = (MyBoundService.ExampleBinder) service;
            myBoundService = binder.getService(); //Get được service
            myBoundService.getDataAfterGetService(); //Có thể gọi được phương thức service
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //Chỉ được gọi khi xảy ra lỗi, hoặc bị ngắt đột ngột
            //Không gọi khi chủ động ngắt kết nối
        }
    };
```

> Chú ý: Trong BoundService có một lỗi xảy ra khiến crash app đó là khi bạn không có một BoundService nào đang chạy nhưng lại nhấn hoặc gọi đến phương thức `unbindService(serviceConnection)`.  Lỗi này là lỗi `java.lang.IllegalArgumentException: Service not registered` (Chưa đăng kí service). Để khắc phục bạn nên tạo một biến boolean để check xem có Service được tạo chưa trước khi đóng một service!
> ![](https://i.imgur.com/xyHfw0d.png)
