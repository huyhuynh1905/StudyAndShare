<h1 align="center">Internal Storage Và External Storage</h1>

### Nội dung
1. [***Internal Storage là gì?***](#muc1) 
2. [***External Storage là gì?***](#muc2)

<a name="muc1"></a>
## 1. Internal Storage là gì?
- Là các lưu trữ dữ liệu vào trong bộ nhớ trong của thiết bị và dữ liệu này sẽ được bảo mật đảm bảo chỉ có ứng dụng mới có thể truy xuất được mà không có bất kì ứng dụng khác có quyền truy cập kể cả là người dùng.
- Dữ liệu lưu trong Internal Storage sẽ được xoá bỏ khi ứng dụng bị xoá bỏ hoàn toàn hoặc khi người dùng clear data của ứng dụng đi.
- Internal Storage đảm bảo tính bảo mật hơn SharedPreferences.

- Đoạn code ghi giá trị vào data:
	```java
	private void saveData() {  
	    FileOutputStream fileOutputStream = null;  
	  String noidung = "Xin chào, đây là nội dung đã lưu!";  
	 try {  
	        fileOutputStream = openFileOutput("TenDataLuu", Context.MODE_PRIVATE);  
	  fileOutputStream.write(noidung.getBytes());  
	  fileOutputStream.close();  
	  txtHienThi.setText("Lưu file thành công!");  
	  } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	  } catch (IOException e) {  
	        e.printStackTrace();  
	  }  
	}
	``` 
- Đoạn code đọc giá trị :
	```java
	private void readDate() {  
	    FileInputStream fileInputStream = null;  
	 try {  
	        fileInputStream = openFileInput("TenDataLuu");  
	  BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));  
	  StringBuilder stringBuilder = new StringBuilder();  
	  String line = null;  
	 while ((line=br.readLine())!=null){  
	            stringBuilder.append(line);  
	  }  
	  br.close();  
	  fileInputStream.close();  
	  } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	  } catch (IOException e) {  
	        e.printStackTrace();  
	  }  
	}
	```

<a name="muc2"></a>
## 2. External Storage là gì?

- External Storage trong android là phần bộ nhớ mà có thể dùng để chia sẽ dữ liệu . nó có thể là bộ nhớ di động (SDCard), có thể là bộ nhớ trong.Những dữ liệu lưu trong bộ nhớ trong có thể được và chỉnh sửa được bưởi người dùng thông quá kết nối USB với máy tính.
- External Storage có thể chia sẽ dữ liệu cho ứng dụng khác vì lưu ở bộ nhớ ngoài ứng dụng và có thể lưu trữ một lượng dữ liệu rất lớn không ảnh hưởng nhiều đến dung lượng của ứng dụng.

- Để sử dụng thì bạn phải xin quyền trong `AndroidMainifest.xml`:
	```xml
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
	```
- Với android 6.0 trở lên như đã nói thì bạn phải xin quyền bằng code nữa:
	```java
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
- Để kiểm tra bộ nhớ ngoài có còn dung lượng ghi hay không thì có đoạn code check (trả về boolean):
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
- Đoạn code ghi dữ liệu vào bộ nhớ:
```java
public void saveData(){
        String content = "Noi Dung Luu";
        File file;
        FileOutputStream outputStream;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "TenFileLuu");
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

- Đọc dữ liệu:
	```java
	 public void readData(){
	        BufferedReader input = null;
	        File file = null;
	        try {
	            file = new File(Environment.getExternalStorageDirectory(), "TenFileLuu");

	            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	            String line;
	            StringBuffer buffer = new StringBuffer();
	            while ((line = input.readLine()) != null) {
	                buffer.append(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	```

