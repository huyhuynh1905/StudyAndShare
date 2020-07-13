<h1 align="center">Lập trình bất đồng bộ Asynchronous trong Dart</h1>

### Nội dung
1. [***Hàm bất đồng bộ - async.***](#muc1) 
2. [***Sử dụng Future.***](#muc2) 
3. [***Bắt lỗi.***](#muc3)

Cơ chế bất đồng bộ là chương trình cho phép phân nhánh quá trình code hoạt động, làm cho có cảm giác như đa luồng (thực chất vẫn là 1 thread) - có lúc thì chạy code ở nhánh này, có lúc thì chạy code ở nhánh khác - cảm giác thi hành 2 ba việc đồng thời.

<a name="muc1"></a>
## 1. Hàm bất đồng bộ - async.
- Hàm bất đồng bộ được khai báo có từ khóa `async` phía sau, và đối tượng trả về của hàm là `Future<T>`, với `T` là kiểu biểu thức `return` trả về.
```dart
hamBatDongBo() async {
 return  1;
}
```
- Nếu hàm đó đã khai báo là bất đồng bộ `async` thì trong hàm có thể sử dụng thêm từ khóa `await biểu_thức;` cho biết, chờ cho biểu thức thi hành xong mới thi hành các code tiếp theo của hàm. Ví dụ:
 <div align="center"><img  src="https://i.imgur.com/vnMcEMO.png"/></div>

- Để dễ hiểu thì ta có ví dụ sau, giả sử ta có 3 phương thức:
 <div align="center"><img  src="https://i.imgur.com/EfzsG0b.png"/></div>
 
 - Phương thức inSo() được `async` và gán dữ liệu data từ hàm inThongTin(), tiến hành chạy thì ta thu được kết quả là hàm inThongBao() sẽ chạy trước khi hàm inSo() chờ hoàn thành:
  <div align="center"><img  src="https://i.imgur.com/RUy7mZU.png"/></div>

<a name="muc2"></a>
## 2. Sử dụng Future.
- Trả về từ hàm `async` là một đối tượng Future, từ đối tượng này cho phép sử lý kết quả trả về khi hàm `async` hoàn thành. Giờ ta sửa code inSo() trả về dữ liệu Future<string> khi hàm đó hoàn thành nhiệm vụ.
```dart
Future<String> inSo() async{
 var data = await  inThongTin();
 print('Hàm in số!');
 print(data);
 return  'Dữ liệu được trả về'; //Dữ liệu trả về Future
}
 ```
 - Ta viết lại ví dụ trên: 
   <div align="center"><img  src="https://i.imgur.com/3FQS8pj.png"/></div>

- Future có trả về giúp ta có thể gọi các hàm callBack ví dụ như chạy call back hàm inThongTin(), ta thu được kết quả:
  <div align="center"><img  src="https://i.imgur.com/3tPamzV.png"/></div>

<a name="muc3"></a>
## 3. Bắt lỗi.
- Nếu muốn bắt lỗi trong hàm asyn cũng dùng biểu thức `try ... catch`,
	```dart
	Future<String> inSo() async{
	 try{
	  var data = await  ganThongTin();
	 }
	 catch(e){
	  //Xử lí lỗi
	 }
	 print('Hàm in số!');
	 print(data);
	 return  'Dữ liệu được trả về';
	}
	```

- Hoặc có thể throw ra Exception trong các hàm:
	```dart
	double number = 3.14;
	ganThongTin(){
	 var  num = number;
	 throw  new  Exception('Không gán được thông tin');
	 return  num;
	}
	```