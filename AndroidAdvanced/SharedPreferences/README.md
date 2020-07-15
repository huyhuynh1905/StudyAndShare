<h1 align="center">Shared Preferences Trong Android</h1>

### Nội dung
1. [***Shared Preferences là gì?***](#muc1) 
2. [***Lưu dữ liệu Shared Preferences.***](#muc2)
3. [***Lấy dữ liệu Shared Preferences.***](#muc3)

<a name="muc1"></a>
## 1. Shared Preferences là gì?
- Đây là một class **Interface** cho phép bạn lưu trữ và đọc dữ liệu với bằng các cặp key và value và nó được lưu dưới dạng một file xml, dữ liệu nó có thể lưu là ở dạng nguyên thuỷ như: int, float, string, boolean, long. Dữ liệu của Shared Preferences sẽ được lưu ở trong ứng dụng android luôn chính vì thế nếu các bạn xoá ứng dụng đi hoặc là xoá dữ liệu app thì dữ liệu này sẽ hoàn toàn bị biến mất.
- Dữ liệu lưu trong Shared Preferences sẽ được xoá bỏ khi ứng dụng bị xoá bỏ hoàn toàn hoặc khi người dùng clear data của ứng dụng đi.
- Shared Preferences không lưu được object nhưng ta có thể convert object về String hay json để đọc và lưu.
- Dùng để lưu các dữ liệu có kích thước nhỏ.

<a name="muc2"></a>
## 2. Lưu dữ liệu Shared Preferences.
- B1: Khai báo một biến SharedPreferences:
	```java
	SharedPreferences sharedPreferences = getSharedPreferences("TenDataLuu", Context.MODE_PRIVATE);
	```

	> Vị trí lưu sẽ là: `data/data/[application package name]/shared_prefs/TenDataLuu.xml`
	>>Context.MODE_PRIVATE:  tham số cơ chế bảo mật trong Android.

- B2: Tạo đối tượng Editer từ biến sharedPreferences chúng ta đã tạo ở trên, mục đích của thằng này là để chúng ta có thể mở file **shared_preferences_name.xml** ra và đưa dữ liệu vào:
	```java
	SharedPreferences.Editor editor = sharedPreferences.edit();
	```
- B3: Đưa dữ liệu vào bằng các lệnh `editor.putInt("data")`, `editor.putString("data")`, `editor.putBoolean("data")`,... Và cuối cùng để lưu xuống thì ta dùng lệnh **`editor.apply()`** hoặc là **`editor.commit()`** (apply không có cơ chế  Synchronous và không có kết quả trả về, commit thì ngược lại).


<a name="muc3"></a>
## 3. Lấy dữ liệu Shared Preferences.
- Để lấy dữ liệu thì ta chỉ cần dùng SharedPreferences để get dữ liệu ra thôi:
```java
SharedPreferences sharedPreferences = getSharedPreferences("TenDataLuu", Context.MODE_PRIVATE);
String name = sharedPreferences.getString("TenKey","Gia tri mac dinh neu khong tim thay");
```
- Ta dùng `getString`,`getInt`,`getBoolean`,... để lấy dữ liệu ra như trên.

- Để xoá một trường dữ liệu trong Shared thì ra dùng:
```java
SharedPreferences sharedPreferences = getSharedPreferences("TenDataLuu", Context.MODE_PRIVATE);  
SharedPreferences.Editor editor = sharedPreferences.edit();  
editor.remove("TenKey");  
editor.apply(); //commit
```

- Để xoá toàn bộ thì:
```java
SharedPreferences sharedPreferences = getSharedPreferences("TenDataLuu", Context.MODE_PRIVATE);  
SharedPreferences.Editor editor = sharedPreferences.edit();  
editor.clear();  
editor.apply(); //commit
```