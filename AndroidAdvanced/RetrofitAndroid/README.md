<h1 align="center">Retrofit Trong Android</h1>

### Nội dung
1. [***Thư viện sử dụng trong Retrofit.***](#muc1) 
2. [***Cấu hình chung cơ bản và cách sử dụng.***](#muc2)


<a name="muc1"></a>
## 1. Thư viện sử dụng trong ví dụ Retrofit2.
Chúng ta sẽ sử dụng 2 thư viện là [Retrofit 2]() (Để làm việc với API) và thư viện [Gson Converter]() (Để thực hiện việc đọc và conver json):
```
implementation 'com.squareup.retrofit2:retrofit:_(insert latest version)_'
implementation 'com.squareup.retrofit2:converter-gson:latest.version'
```
>Trong ví dụ này mình sẽ dùng version 2.4.0
>Chú ý là nên dùng các phiên bản mới nhất để tránh lỗi về API

Ngoài ra còn dùng thư viện [Glide](https://github.com/bumptech/glide) để load ảnh từ url và thư viện RecyvlevView để hiển thị danh sách:
```
implementation "androidx.recyclerview:recyclerview:1.1.0"  
implementation "androidx.cardview:cardview:1.0.0"  
implementation 'de.hdodenhof:circleimageview:3.1.0'  
implementation 'com.github.bumptech.glide:glide:4.11.0'
```

Chú ý vì có load ảnh từ URL nên cần các quyền về INTERNET, xem lại trang chủ của tutorial để xin quyền truy cập đầy đủ.

Trong code này sử dụng server spring boot và database mysql [tải tại đây](https://github.com/huyhuynh1905/VegetableShop)


<a name="muc2"></a>
## 2. Cấu hình chung cơ bản và cách sử dụng.

Sử dụng ta sẽ tạo ra một hoặc nhiều `interface`, trong đó sẽ chứa cấu hình cơ bản và thiết kế các api chức năng:

```java
public interface LoginAPI {  
  String baseUrl = "http://192.168.1.101:8081/"; //domain url  
  Gson gsonn = new GsonBuilder()  
            .setDateFormat("yyyy-MM-dd HH:mm:ss")  
            .create();  
  LoginAPI retrofitAPI = new Retrofit.Builder()  
            .baseUrl(baseUrl)  
            .addConverterFactory(GsonConverterFactory.create(gsonn))  
            .build()  
            .create(LoginAPI.class);  
  
  //Các API sẽ call  
  @POST("login")  
  Call<TaiKhoan> loginToServer(@Body Map<String,String> map);  
}
```

Để sử dụng tới các API này ta gọi bằng cách:
```java

<Interface Name>.retrofitAPI.tenMethodCanDung(<Các tham số truyền vào đã khai báo>).enqueue(new Callback<TaiKhoan>() {  
    @Override  
	public void onResponse(Call<TaiKhoan> call, Response<TaiKhoan> response) {
		//Thành công và nhận về được response
		//Đọc bằng data = response.body()
    }  
  
    @Override  
	public void onFailure(Call<TaiKhoan> call, Throwable t) {  
        //Lỗi 
	}  
});
```

Các cách truyền của method @GET:
```java
@GET("group/{id}/users")  
Call<List<User>> groupList(@Path("id")  int groupId);
```
```java
@GET("group/{id}/users")  
Call<List<User>> groupList(@Path("id")  int groupId,  @Query("sort")  String sort);
```
```java
@GET("group/{id}/users")  
Call<List<User>> groupList(@Path("id")  int groupId,  @QueryMap  Map<String,  String> options);
```

Có thể sử dụng một map cơ bản để tạo ra một json request gửi đi hoặc nhận về:
```java  
Map<String,String> map = new HashMap<>();  
map.put("key 1","value 1");  
map.put("key 2","value 2");
```

Các medthod @POST đọc theo trang chủ của Retrofit.

> Warring: Trong retrofit không có phương thức `@DELETE` truyền vào các `@Body`,.. Vậy nên để sử dụng thì phải tự định nghĩa một `HTTP` riêng cho mình như sau:
```java
@HTTP(method = "DELETE", path = "xoagiohang", hasBody = true)  
Call<Map<String,Boolean>> xoaGioHang(@Body GioHang gioHang);
 ```


