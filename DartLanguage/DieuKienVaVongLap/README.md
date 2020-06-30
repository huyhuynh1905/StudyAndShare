<h1 align="center">Cấu Trúc Rẽ Nhánh Và Vòng Lặp Trong Dart</h1>

### Nội dung
1. [***Cấu trúc điều kiện.***](#muc1) 
2. [***Vòng lặp trong dart.***](#muc2) 

<a name="muc1"></a>
## 1. Cấu trúc điều kiện.
- Biểu thức:  `if  (biểu_thức)  {  //Viết lệnh chạy khi biểu_thức là true  }`.
- Ví dụ if-else:
```dart
int a = 5;
var b = 7;
//Câu lệnh if-else
if(a>b){
	print('A lớn hơn B');
}
//if-else lồng nhau
if (a<b){
	print('A nhỏ hơn B');
} else  if(a==b){
	print('A bằng B');
} else {
	print('A Lớn hơn B');
}
```
- Ví dụ switch:
```dart
//Lệnh rẽ nhánh:
switch(a){
	case  1:
		print('A = 1');
		break;
	case  2:
		print('A = 2');
		break;
	default:
		print('A lớn hơn 2');
}
```
- Dart cung cấp lệnh Assert(biểu_thức_logic); để khi chạy mà biểu thức logic sai sẽ dừng chương trình ở đó. Assert là cách để kiểm tra một biểu thức, vấn đề là nó không có ảnh hưởng gì khi chạy ở chế độ product nó chỉ tác dụng khi phát triển (Chạy debug Ctrl + F5 trong VS):
![](https://i.imgur.com/Ibl39zn.png)

<a name="muc2"></a>
## 2. Vòng lặp trong dart.
- Vòng lặp for:
```dart
//Vòng lặp for
for(var i=0;i<3;i++){
	print('Giá trị của i: $i');
}
```
- Vòng lặp for-in:
```dart
//Duyệt danh sách (for each)
var arrays = {'xin', 'chào', 'dart'};
for (var item in arrays) {
	print('$item');
}
```
- Vòng lặp while:
```dart
//lệnh while
var count = 0;
while (count<5) {
	count++;
}
print('$count'); //kết quả in ra 5
```
- Vòng lặp do-while:
```dart
do{
	count--;
} while(count>0);
print('$count'); //kết quả in ra 0
```