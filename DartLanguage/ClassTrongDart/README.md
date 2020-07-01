<h1 align="center">Class Trong Dart</h1>

### Nội dung
1. [***Class trong Dart.***](#muc1) 
2. [***Kế thừa trong Dart.***](#muc2) 
3. [***Nạp chồng trong Dart.***](#muc3) 
4. [***Trừu tượng trong Dart.***](#muc4) 
5. [***Interface trong Dart.***](#muc5) 
6. [***Mixin trong Dart.***](#muc6) 

<a name="muc1"></a>
## 1. Class trong Dart.
- Class để tạo ra các đối tượng, với Dart mọi thứ kể cả số đều là đối tượng, các đối tượng đề kế thừa từ class `Object`.
- Các thành phần có thể có trong một class:
	- Các phương thức khởi tạo - Hàm được gọi khi tạo ra một đối tượng mới từ class, có tên giống tên class.
	- Các biến lưu dữ liệu của đối tượng - gọi là các trường - các thuộc tính.
	- Các hàm - gọi là các thành viên hàm - các phương thức.
- Khai báo một lớp dùng từ khoá class:
	```dart
	class  NhanVien {
	//Khai báo thuộc tính
		String name;
		var age;
		var salary;
		//Khai báo hàm khởi tạo, nếu thêm const trước hàm tạo thì đối tượng sinh ra sẽ không thay đổi
		NhanVien(String name, var age, var salary){
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		//Khởi tạo một đối tượng cụ thể bằng hàm tạo:
		NhanVien.thuKi(String name, var age, {var salary:2000}){
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		//Tạo một phương thức hiển thị
		@override
		String  toString() {
			// TODO: implement toString
			return  this.name+" - "+this.age.toString()+ " - " +this.salary.toString();
		}
		thongBao(){
			print('Đây là phương thức của lớp cha!');
		}
		//Một phương thức có static(Sử dụng trực tiếp thông qua tên class):
		static  thongTin(){
			print('Đây là class Nhân Viên');
		}
	}
	```

- Từ lớp đã có khởi tạo đối tượng bằng cách gọi hàm khởi tạo của nó với toán tử `new`, sau khi có đối tượng thì truy cập vào các thành viên (phương thức, thuộc tính) bằng ký hiệu chấm `.` như `object.phuongthuc();`:
<div align="center"><img  src="https://i.imgur.com/Gy4JrYj.png"/></div>

- Hàm khởi tạo có tên: Ở trên kia ta thấy có một hàm toạ đặc biệt:
	```dart
	//Khởi tạo một đối tượng cụ thể bằng hàm tạo:
	NhanVien.thuKi(String name, var age, {var salary:2000}){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	```
	>Hàm này giúp ta khởi tạo một đối tượng cụ thể, lúc toạ đối tượng dùng:
	`NhanVien nv2 = NhanVien.thuKi('Thư Kí', 25);`

> Các phương thức tĩnh có từ khoá `static` thì sử dụng trực tiếp thông qua tên class. Như phương thức `static  thongTin()` ở trên!

<a name="muc2"></a>
## 2. Kế thừa trong Dart.
- Từ một lớp đã có, bạn có thể tạo ra một định nghĩa lớp mới, lớp mới đó gọi là lớp kế thừa - lớp con có luôn các thuộc tính, phương thức từ lớp mà nó kế thừa (gọi là lớp cha).
- Sử dụng từ khoá `extends` để kế thừa một lớp.
<div align="center"><img  src="https://i.imgur.com/8nfELcJ.png"/></div>

- Lớp con nói chung sẽ có những thuộc tính và phương thức kế thừa từ lớp cha, nên từ lớp con bằng từ khóa `this` có thể truy cập đến những thành phần này. Tuy nhiên có những phương thức mà lớp con sẽ định nghĩa lại mà vẫn giữ tên cũ (quá tải) lúc này `this` sẽ sử dụng phương thức định nghĩa lại, tuy nhiên phiên bản ở lớp cha vẫn còn đó, lúc này nếu muốn truy cập đến phiên bản định nghĩa bởi lớp cha sẽ dùng ký hiệu `super` thay cho `this`.

<a name="muc3"></a>
## 3. Nạp chồng trong Dart.
- Bạn có thể tạo ra phiên bản mới của một phương thức đã có trên lớp cha, và từ đây đối tượng sẽ sử dụng phương thức mới được định nghĩa, để làm điều đó ở lớp con tạo lại phương thức với chỉ thị `@override` - nạp chồng phương thức.
- Ví dụ trong `GiamDoc.dart` ta nạp chồng 2 phương thức của lớp cha `NhanVien`:
<div align="center"><img  src="https://i.imgur.com/SN3E9Hr.png"/></div>


<a name="muc4"></a>
## 4. Trừu tượng trong Dart.
- Lớp trừu tượng là lớp không dùng trực tiếp để tạo ra đối tượng được, nó chỉ được kế thừa từ lớp khác. Phương thức nào trong lớp trừu tượng chỉ khai báo tên hàm, thì phương thức đó gọi là phương thức trừu tượng, lớp kế thừa bắt buộc phải định nghĩa nội dung hàm này. Sau đây là tạo ra lớp tượng `A` với từ khóa `abstract`.
- Ví dụ ta có một abstract class:
	```dart
	abstract  class  Person{
		String name;
		int age;
		//Viết một phương thức không định nghĩa
		hienThi();
		//Có thể viết phương thức định nghĩa
		inThongTin(){
			print('Thông tin của lớp trựu tượng!');
		}
	}
	```
- Lớp này không thể dùng để tạo ra đối tượng, nhưng nó được kế thừa bởi lớp khác. Lớp con kế thừa bắt buộc phải định nghĩa nội dung cho phương thức trừu tượng bằng cách nạp chồng (`@override`):
	```dart
	//Sử dụng abstract class
	class  Student  extends  Person{
		var levelClass;
		//Tạo phương thức khởi tạo cho class này
		Student(String name, int age, var levelClass){
			this.name=name;
			this.age=age;
			this.levelClass = levelClass;
		}
		@override
		hienThi() {
			// TODO: implement hienThi
			//Bắt buộc định nghĩa ra
			print(this.name+ " - " +this.age.toString());
		}
	}
	```

<a name="muc5"></a>
## 5. Interface trong Dart.
- Interface - giao diện - là khái niệm quen thuộc trong các ngôn ngữ lập trình hướng tối tượng, với Dart **mặc định mọi lớp đều là interface lớp** lớp đó được triển khai bởi lớp khác bằng từ khóa `implements`.
- Khi một lớp được coi là giao diện thì lớp triển khai nó phải định nghĩa lại mọi phương thức, thuộc tính có trong giao diện.
- Ví dụ sau đây class `HoatDong` implement lại class `NhanVien` ở trên thì bắt buộc phải định nghĩa lại các thuộc tính và phương thức của class `NhanVien` (trừ các static method và các phương thức khởi tạo):
<div align="center"><img  src="https://i.imgur.com/2oVkl5X.png"/></div>


<a name="muc6"></a>
## 6. Mixin trong Dart.

- Với Dart thì Mixin là một lớp, nó không được sử dụng trực tiếp để tạo ra đối tượng, một Mixin chứa các phương thức, thuộc tính dùng để gộp vào một lớp khác.
- Ví dụ ta có một Mixin là `M`:
	```dart
	mixin  M {
		String namemixin;
		displayMixin(){
			print('Đây là mixin');
		}
	}
	```
- Có một class `Merge` muốn gộp tất cả thuộc tính và phương thức của mixin `M` vào:
	```dart
	class  Merge  with  M{
		String nameMerge;
		Merge(String nameMerge, String nameMixin){
			this.namemixin = nameMixin;
			this.nameMerge = nameMerge;
		}
		displayMerge() {
			print('Đây là Merger');
		}
	}
	```
	> Tất cả các phương thức và thuộc tính của mixin đã mặc định có trong class `Merge` có thể sử dụng thông qua lớp này.
- Sử dụng như class bình thường, gọi đến các phương thức của mixin thông qua đối tượng của class:
	```dart
	void  main(List<String> args) {
		Merge mer = new  Merge('Merger', 'Mixin');
		mer.displayMixin();
		mer.displayMerge();
	}
	```