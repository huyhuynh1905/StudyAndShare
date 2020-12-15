# Android Advanced
> Seri thực hiện bằng Android Studio 4.0.1

### Danh sách các bài:
1. [Shared Preferences trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/SharedPreferences)
2. [Internal Storage và External Storage trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/InternalStorageAndExternalStorage)
3. [SQLite trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/SQLiteTrongAndroid)
4. [Broadcast Receiver](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/Broadcast-Receiver)
5. [Service Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/Service-Android)
6. [ListView Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/ListView)
7. [Một Số Drawable và Animation Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/DrawableAndroid)
8. [Intent, AsynTask Và Volley Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/IntentAndAsynTaskAndVolley)
9. [Fragment Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/FragmentAndroid)
10. [RecycleView Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/RecycleviewAndroid)
11. [Retrofit2 Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced/RetrofitAndroid)





### Những điểm chú ý trong Android:
***1. Cách xin quyền đối với Android 6.0 trở lên:***
- Đối với android 6.0 trở lên thì ngoài xin trong file `AndroidMainifest.xml` thì còn phải xin bằng code.
- Để xin quyền từ android 6.0 ta có thể dùng đoạn code sau (trong code là xin quyền đọc ghi file, tuy nhiên ta có thể thêm các quyền vào mảng trong code để tiến hành xin các quyền khác) sau đó gọi hàm này trong `onCreate()` hay trước các lệnh cần dùng quyền:
```java
//Kiểm tra và xin quyền trên android 6.0 trở lên
private void checkAndRequestPermissions() {  
    String[] permissions = new String[]{  
            Manifest.permission.WRITE_EXTERNAL_STORAGE,  
  Manifest.permission.READ_EXTERNAL_STORAGE  
  };  
  List<String> listPermissionsNeeded = new ArrayList<>();  
 for (String permission : permissions) {  
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {  
            listPermissionsNeeded.add(permission);  
  }  
    }  
    if (!listPermissionsNeeded.isEmpty()) {  
        ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);  
  }  
}
```
***2. Xin cấp các quyền đọc và ghi bộ nhớ External Storage:***
- Đối với API 29 trở lên (android 9.0 trở lên) phải thêm dòng sau vào `AndroidMainifest.xml`: `android:requestLegacyExternalStorage="true"`

	```xml
	<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>  
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	```
- Kiểm tra xem có bộ nhớ ngoài và có thể ghi file được không (Có đủ dung lượng, có hay không):
	```java
	public boolean isExternalStorageReadable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state) ||
	        Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
	        return true;
	    }
	    return false;
	}
	```
***3. Quyền internet:***
- Thêm dòng này vào trong mục application của file `AndroidMainifest` để có thể chạy được internet trên các máy API 29 trở lên (android 9 trở lên): `android:usesCleartextTraffic="true"`
- Quyền internet: 
	```
	<uses-permission android:name="android.permission.INTERNET" />
	
