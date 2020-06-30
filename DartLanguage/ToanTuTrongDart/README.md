<h1 align="center">Toán Tử Trong Dart</h1>

### Nội dung
1. [***Toán tử cơ bản.***](#muc1) 
2. [***Toán tử logic.***](#muc2) 
3. [***Toán tử trên lớp và đối tượng.***](#muc3)

<a name="muc1"></a>
## 1. Toán tử cơ bản.

```dart
var a = 5;
var b = 6;
//các toán tử cơ bản
var cong = a+b; //cong = 11
var tru = a-b; //tru = -1
var nhan = a*b; //nhan = 30
var chia = a/b; //chia = 0.8333333333333334
var chialaynguyen = a ~/ b; //lấy kết quả nguyên.
var chialaydu = a%b; //chia lấy phần dư.
```
> Các toán tử a++,b--,--a,++b,+=a,-=b,... của java thì trong dart vẫn có.

<a name="muc2"></a>
## 2. Toán tử logic.

- Toán tử `||`: Phép logic hoặc, `a || b` kết quả `true` nếu `a` hoặc `b` là `true`.
- Toán tử `&&`: Phép logic và, `a && b` kết quả `true` nếu `a` và `b` đều `true`.
- Toán tử `!<biểu_thức>`: Phép phủ định `!a` nếu `a` là `true` thì kết quả phép toán là `false`.
- Ngoài ra trong dart có 2 loại biểu thức điều kiện:
`biểu_thức_điều_kiện ? biểu_thức_1 : biểu_thức_2`
`biểu_thức_1 ?? biểu_thức_2` (nhận biểu thức 1 nếu biểu thức 1 != null và ngược lại).

<a name="muc3"></a>
## 3. Toán tử trên lớp và đối tượng.
- Từ khoá `as` -  Chuyển kiểu: **var as MyClass**.
- Từ khoá `is` và `is!` - Kiểm tra: **var is MyClass**.