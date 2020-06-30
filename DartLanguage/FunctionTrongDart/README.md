<h1 align="center">Function Trong Dart</h1>

### Nội dung
1. [***Hàm trong dart.***](#muc1) 
2. [***Hàm ẩn danh - lambda - closure.***](#muc2) 

<a name="muc1"></a>
## 1. Hàm trong dart.
- Hàm là một khối lệnh thực hiện một tác vụ gì đó, khối lệnh này được dùng nhiều lần nên gom chúng tại thành một hàm. Trong Dart mọi thứ đều là đối tượng nên hàm cũng là một đối tượng (kế thừa Function).
- Khai báo hàm không có kiểu trả về:
	```dart
	//Hàm không có kiểu trả về
	inManHinh(var name){
		print('Xin chào $name');
	}
	```
- Khai báo hàm có kiểu trả về: 
	```dart
	double tinhTong(var a, double b){
		return a+b;
	}
	```
- Nếu chỉ có câu lệnh trả về thì có thể rút gọn hàm:
	```dart
	//Nếu chỉ đơn giản trả về thì ta có thể viết
	double  tinhHieu(var a, double b) => a-b; //Chỉ sử dụng được khi có 1 tham số là var/dynamic
	```
- Khai báo hàm có giá trị mặc định không cần truyền thì dùng`{}`:
	```dart
	//hàm có giá trị mặc định
	double  tinhTich(var a, {double b:2, double c:3}){
		return a*b*c;
	}
	```
- Khai báo hàm có giá trị tuỳ chọn không bắt buộc thì dùng `[]`:
	```dart
	//Hàm có giá trị tuỳ chọn
	double  tinhThuong(var a, [double b]){
		if(b!=null){
		return a/b;
		}
		return a;
	}
	```
<a name="muc2"></a>
## 2. Hàm ẩn danh - lambda - closure.

- Hầu hết khai báo hàm là có tên hàm, tuy nhiên trong nhiều ngữ cảnh khai báo hàm và không dùng đến tên, hàm đó gọi là hàm ẩn danh còn gọi là `lambda` hoặc `closure`.
- Khai báo hàm ẩn danh:
	```dart
	//Khai báo hàm ẩn danh chạy luôn
	var c = (int a, int b){
		return a+b;
	}(5,6);
	```

- Hàm ẩn danh rất tiện dụng để làm tham số (callback) trong các hàm khác, thậm chí khai báo luôn một ẩn danh ở tham số hàm.
	```dart
	//Hàm không có kiểu trả về
	 inManHinh(var name){
	 print('Xin chào $name');
	}
	//Hàm ẩn danh dùng làm callbacl trong các hàm khác:
	hamAnDanh(int a, int b, var printKetQua){
	 int c = a+b;
	 printKetQua(c);
	}
	```
	> Sử dụng hàm trên trong main:

	```dart
	//Gọi hàm ẩn danh callback
	hamAnDanh(10, 6, inManHinh);
	//Hoặc
	hamAnDanh(10, 11, (c){print('Tổng là: $c');});
	```