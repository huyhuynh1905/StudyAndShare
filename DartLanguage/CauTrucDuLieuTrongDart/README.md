<h1 align="center">Cấu Trúc Dữ Liệu Trong Dart</h1>

### Nội dung
1. [***Cấu trúc liệt kê Enum.***](#muc1) 
2. [***Cấu trúc dữ liệu Iterable.***](#muc2) 
3. [***Cấu trúc danh sách, mảng, list.***](#muc3) 
4.  [***Cấu trúc Map, ánh xạ.***](#muc4) 
5. [***Tập hợp - set.***](#muc5) 

<a name="muc1"></a>
## 1. Cấu trúc liệt kê Enum.
- Enum biểu diễn một tập hợp cố định các hằng số. Dùng từ khoá `enum` để tạo ra một `enum`.
- Ví dụ:
	```dart
	enum  DayOfWeek {
	monday,tuesday,wednesday,thurday,friday,saturday,sunday
	}
	```
- Sử dụng: 
	<div align="center"><img  src="https://i.imgur.com/Q0NM34f.png"/></div>



<a name="muc2"></a>
## 2. Cấu trúc dữ liệu Iterable.
- Iterable là một lớp generic biểu diễn tập hợp dữ liệu mà có thể duyệt qua hết phần tử này đến phần tử khác. Nghĩa là nó hỗ trợ `moveNext()` để đi đến phần tử tiếp theo, lấy dữ liệu phần tử hiện tại bằng `iterator.current`.
- Thường thì `Iterable` được tạo ra, liên kết với một loại kiểu dữ liệu tập hợp khác như List, Map ... (Xem ở mục sau).
- Ví dụ:
	```dart
	void  main(List<String> args) {
		var itera = new  Iterable.generate(10); //Sinh ra 10 phần tử từ 0-10
		for (var item in itera) {
			print(item);
		}
		//Hoặc duyệt bằng foreach
		itera.forEach((element) {
			print(element);
		});
	}
	```
- Các thao tác trên iterable thông dụng:
<div align="center"><img  src="https://i.imgur.com/FGQ032N.png"/></div>


<a name="muc3"></a>
## 3. Cấu trúc danh sách, mảng, list.
- Trong Dart, danh sách (cũng là mảng) được định nghĩa từ lớp generic `List`, nó chứa một tập hợp các dữ liệu - mỗi dữ liệu trong List là gọi là phần tử, vị trí của nó xác định bằng chỉ số bắt đầu từ `0`, truy cập đến mảng (danh sách) dùng ký hiệu `[]` chứa chỉ số phần tử.
- Có 2 loại List, đó là loại mà số phần tử có thể thay đổi và loại list có số phần tử cố định.
- Mảng cố định:
	```dart
	void  main(List<String> args) {
		//Khai báo một mảng cố định:
		var listStatic = new  List(2);
		listStatic[0] = 5;
		listStatic[1] = 7;
		print(listStatic);//[5, 7]
	}
	```
- Mảng có thể thay đổi được:
	```dart
	void  main(List<String> args) {
		//Mảng thay đổi được
		var listDyn = new  List();
		listDyn.add('Xin');
		listDyn.add('Chào');
		listDyn.add(19);
		listDyn.add('Bạn');
		print(listDyn); //[Xin, Chào, 19, Bạn]
		//Ngoài ra có thể chèn thêm
		var listAdd = ['huy',12];
		listAdd.insert(0, 'chào');
		listAdd.add('Bạn');
		print(listAdd); //[chào, huy, 12, Bạn]
	}
	```
	
- Các thao tác thông dụng (ngoài các thao tácc iterable ở trên): 
<div align="center"><img  src="https://i.imgur.com/Gn3s3xo.png"/></div>

>Thêm `LinkedList`: Sử dụng và ý nghĩa giống `List` (khởi tạo `new LinkedList()`), chỉ có điều nó lưu trữ dữ liệu theo cách tối ưu để duyệt qua, tìm kiếm nhanh, tốt để tương quản lý dữ liệu, như chèn và xóa một lượng lớn phần tử
<a name="muc4"></a>
## 4. Cấu trúc Map, ánh xạ.
- Đây là kiểu tập hợp dữ liệu mà mỗi phần tử biểu diễn theo cặp  `key:value`.
- Các phần tử của Map được truy cập bằng ký hiệu  `[]`  chứa  `key`  dạng  `map[key]`.
- Ví dụ khởi tạo Map với new:
	```dart
	//Tạo map bằng new
	var map1 = new  Map();
	map1['id'] = '001';
	map1['name'] = 'Huy';
	map1['age'] = 22;
	//duyệt map bằng foreach
	map1.forEach((key, value) {
		print('$key : có giá trị $value');
	});
	//Duyệt map bằng for in
	for(var key in map1.keys){
		print('$key : ${map1[key]}');
	}
	```
- Khởi tạo map với:
	```dart
	//Khởi tạo và gán phần tử:
	var map2 = { 'id':002,
				'name':'huỳnh',
				'age':22};
	```
	> Duyệt map giống như trên:
- Ngoài các phương thức - thuộc tính giống như `Iterable` ở trên thì trong map còn có thêm:
<div align="center"><img  src="https://i.imgur.com/FGQ032N.png"/></div>

> Thêm `HashMap`: Sử dụng và ý nghĩa giống `Map` (khởi tạo `new HashMap()`), có có điều các đối tượng làm key phải cung cấp sự so sánh `==` thông qua giá trị `.hashCode`
<a name="muc5"></a>
## 5. Tập hợp - Set.
- Tập hợp như tên gọi là là tập hợp các phần tử, đảm bảo sao cho mỗi phần tử chỉ được xuất hiện 1 lần.
- Khởi tạo một tập hợp bằng toán tử `new` với cú pháp: `var s = Set();`
- Nó có các phương thức và cách duyệt qua phần tử giống phần trình bày `Iterable` ở trên.
- Để thêm một phần tử vào tập hợp dùng hàm  `add(ele);`  để loại bỏ phần tử dùng hàm  `remove(ele);`, kiểm tra xem có chứa phần tử bằng hàm  `contains(ele);`

>Thêm `HashSet`: Sử dụng và ý nghĩa giống `Set` (khởi tạo `new HashSet()`), so sánh `==` thông qua giá trị `.hashCode`