<h1 align="center">Bắt Đầu Với Dart</h1>

### Nội dung
1. [***Dart là gì?***](#muc1) 
2. [***Cài đặt Dart trên Window.***](#muc2) 
3. [***Chương trình Dart đầu tiên.***](#muc3)

<a name="muc1"></a>
## 1. Dart là gì?
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACoCAMAAABt9SM9AAAAyVBMVEX///91dXUst/YCWJtBxP8FWp0BV5tycnJsbGxpaWne3t5vb296enqMjIwAVJhCx/+Tk5PM7//V1dUASZHN1+Hq6uq4uLg3vvpFuvH09PQ4kciBgYGbm5usrKyhtsvA6f/29vaurq7JycnQ0NDj4+MXf78Sdbajo6MASZV+oMWf4P9h0P+H2v9kj7vZ5O4AUptazv/H8P9ZqtgdicM+pt0CbbCEyOxvnsiqwdkjaKa8zuFEerBUhLVfX1/o7/aQrc0AQY+S1vp7sNK4GCs8AAAJAklEQVR4nO3ca3ubNhgGYIgTJBnsOvYg88AbBm8k7da0O/S84///UQMkgQCBJAx1e+V9PiWObeCOJHSyLQsCgUAgEAgEAoFAIBAIBAKBQCAQCAQCgUAgEAgEAoFAIBAIBAKBQCBfYW6fv3h2/ern20ufx1eQ2xfXLK+Aazg1VZHnlz6dLzm3L+5Eq+u7ny99Rl9sbl9dtwNa8kioQEseORVoSdJs1kFrIENUoNVI+w4IWr3pbatAqx0tKtAqoks1oda+mzie5q1nzWt9qsm0lsTtBNneKgq2+ynef6a8fvHMLNdTaC2JLQtCLsbh8TTBEebIr799Z5jfpyhbPVhUzCVhcv4hps/3V388rs2yWPz05uzjDmEVXtgNJri6iXPz7dVP+eXzOMNhT1rfvz33uAqsPNjeTnGBE+bd/bdXtZaCquZa7H4588AcCzXT4CLRJNc4kMgrovtfeb/OsbiWhtVkWgzLi8SsQhtjAcz1/POOosqmPBjWw/qwK7GolpbVVFoUC61aD8d+mnm1F3LnvS8aYb1fU6xcS5Oq5jpPqweL/i3DbtVyLc85iiomWB92DsPqatWNfrfITaA1hJV37zPCSxeesyaaYL1fLzjWXUNr0c7kWsNYlnXyWOFCdjz+KKoYYH24X1RYolaHqst1tpYKK79TYaa1GX0QZQywPq4FrKomSqnaXGe38mosK2BaeL7evD7WN3nBErGoVq/VtFoaWNaRa8UjD6KMPtandQur0BqwanKdqaWDZUW03XIP446hjjbWy6JgNbHuxJGPQos/MlJLC8viXfmeWZu97583n6ON9cu6g6XWktwxH0dp6WGxfr577Pxle1whUgatDmmsccT9abtdtvq4DEvZl3v56HSxxml90jjVdvSw2NXYqPmon2HsCt18TKLO9fo07LdtZhOCMf6TFqKTF5Zh78B+y9MzGqUFq40ljKpveFQVcVRN1MQ60aKFU5Ehqjv4FRhZtTqvCBfxKFXIR1CsEOVv2xy384G8/HxePi7kWEzrRoxca3GOliaWtSovCAn/8cBFbaryKbg5AeaVD4b5T/GmGg4IWNL09OnervuwCq2bdoaLlmOupYuVsO5DzB/gfdVuSNbBsnOsvSeUw1FYf7GCJcPK260OllRLeMRYSxdrT6+U8JZ5VV150VTlEaokFrUqLE8siKOwHgawVFqyouXsDFt5XSwrLK/VZb34iNMgEgbpyfdP6dGrahkR+voca1Pr5m0U4ViNucZq7tGVnU987wxgaWuJjxhqaWMdyotljVbA51fJQWjPTxteUIQOGcNiZQhhYuc3O4/dDf3sUORIb4coOh5YZBP/VcGSY11d/djVUmA5/3wzCxZttMqWOr+t2bSctW99KZ+iqG8EDKvseyCySRlj3HidTqc0rqz6sAa1uvWw+Hk3D9aSNugeO/MNbrVNND6rUaRS9BhfgdG2raKD9bcaS0/rM2D5FMvlFSwgEquqya4X0Ly6Ue/2/3k0sGKhAvVi3XW1LoIV0xqGq9ZoKX/N0RWqqyVg4YEFSA0soWA5vViSVl7Rws+ERSuYcnY5xk1UjuUOradpYN2sdbC6ZesyWLYelhWVF074IJFjoaHXqLHe7RwtrI7Wl42VlPWwmlZlWMO7ANRY79eaWO1W/ouuhtYWN3AYFhl8jRLrw72jjdXUuggWG++4nVk+f5kmSZJu/Zj+fpJhKVY7lFif1gZYDa2LYLGuA4obDwbF1F85CUOIG2bF7J8US7EXR4UVPzomWOI98SJY20antEwSksY0DcoHM5utL8NSzBirsF4+Nq5ShSW28hfBYsOd+olLD0smtBBpFSWGNbxXYmosQasfa8ZOaUZHg9UCz4FI5/542ljD9wWtamiCVbVbi4tgsYvmPYJNPfdXbD/FxWQ8mg3L+rg2xWJaw7VwJizWvvOLruZJXRxGQbrdbtMkW7l1xZwYK++TmmKVNXGgYM2IFdCeA2vfEz6fhTOxMdqn1RrGxFjxzdoUq9BaXAaLdZdok8U6qDbq7gjcH/AcWGWv1DHDamh1rebDSikBG/GxYlZPLYiR9uDPxrIe7o2xRC15wZoHi642cB06Hy/pzZfvOA9WoWWKVbTyLavPgMUWwti90G/VNNlzp8cStPSxmJbEajYsn+9no7+mrSmrZujKxgxYuZY5Fq2JfQVrDixW7XgnK2lNhjYj78FPgWU97IyxSq3egjUDFltQRXxcSNv3nomE5Tx3QxpWtkywCq3PiMUXn6vV6EGsFZoRi2kZYeVaj31WU2P5fNm9XnBoLCG2smXd1VFY6eCTyjy095SalK3FzFgBH8G4dUHa4l4A3l0dhaX1AbSHe2Os/J74KC9Yk2KlIR8DiuVo37/FNByHFXU2NPUn1zLGomWrW7Cmw/KDau9ZbhULf2HtUmdbY1zvrTHDOrCGTuuUH3bGWKWWxGoSrP0yycRpULdhVW3WcptaS7uepDHDSlhZ7V+zFvPwz++mWM1RtXMWVvPzhi4hpDE71fnAIV8MJMLV+RF1D0dg+ews+Ap/PLyJ/OHHO2OtK9moeiTWQFy389EKfs+zXZwlJ3/vL4OQsOGjfA5esYLG2zrXzYIk2BA8/PS/za0ELWc2LESyuPuyQzVRSjfY8k3LCO+lqzsqrErfRuV3JQyuX+d5c4aWMxeWSzbypQb5llKETvKlMOXabNTc+KzCsv4dreXMgoVcbB96L/IgeaEb+j3rhuqF7FVDS4k1Wss5CwtJ4hZrEOFx8BMPW7tVuBBt7uk+UWyKFW+wEdZIrV0zZtskT+Gqm+gQJKdY+drEq3sX+S008tk7luFYdvmNLUSJlb8d4t06hIa3RtD8e3VnnOv/vm/mL40DTZRTsLGLjd3Yi5JY/pQkKKP1Qag088pd4l6m9Yns56qvGevm2Wvta5sn+/2UX/Fj8m4jtH6Y8FS/sphrPWEsc62njGWs9aSxTLWeNpah1hPHMtN66lhGWk8ey0QLsAy0AMtAC7AsfS3AKqKpBVhl9LQAi+ZWJ59x/goCgUAgEAgEAoFAIBAIBAKBQCAQCAQCgUAgEAgEAoFAIBAIBAKBQCBPL/8DYZoAqei425kAAAAASUVORK5CYII=)
Dart là ngôn ngữ lập trình đa mục đích ban đầu được phát triển bởi Google và sau đó được Ecma (ECMA-408) phê chuẩn làm tiêu chuẩn. Nó được sử dụng để xây dựng các ứng dụng web, server, máy tính để bàn và thiết bị di động. Dart là một ngôn ngữ hướng đối tượng, được xác định theo lớp, với cơ chế garbage-collected, sử dụng cú pháp kiểu C để dịch mã tùy ý sang JavaScript. Nó hỗ trợ interface, mixin, abstract, generic, static typing và sound type (2 cái cuối có thể hiểu là type-safe). Dart là ngôn ngữ mã nguồn mở và miễn phí, được phát triển trên [GitHub](https://github.com/dart-lang).

- Những điều bạn nên nhớ ở Dart:
	- Do Dart là ngôn ngữ thuần OOP nên tất cả những thứ bạn gán cho biến đều là  `object`, mọi  `object`  đều là  `instance`  (thể hiện) của một  `class`. Kể cả số, method (hàm), và  `null`  cũng đều là  `object`. Tất cả các  `object`  đều kế thừa từ  [Object](https://api.dartlang.org/dev/2.0.0-dev.55.0/dart-core/Object-class.html)  class.
    
	-   Kiểu type của 1 variable là  `optional`  bởi vì Dart có thể tự suy ra type dựa trên giá trị truyền vào cho biến. Ở đoạn code bên trên, biến  `number`  được hiểu là kiểu  `int`. Khi bạn muốn khai báo 1 variable mà type của nó không được xác định, hãy sử dụng type  [dynamic](https://www.dartlang.org/guides/language/effective-dart/design#do-annotate-with-object-instead-of-dynamic-to-indicate-any-object-is-allowed).
    
	-   Như các ngôn ngữ khác, Dart hỗ trợ  `generic type`, ví dụ như  `List<int>`  (1 danh sách kiểu số nguyên) hoặc  `List<dynamic>`  (1 danh sách các  `object`  mà type không xác định, nó có thể chấp nhận mọi loại type).
    
	-   Dart hỗ trợ  `top-level function`  (giống như  `main()`), đồng nghĩa bạn có thể sử dụng hàm đó ở bất cứ đâu mà không cần thông qua tên class hay bất kỳ instance của class nào cả. Bạn cũng có thể tạo một hàm bên trong một hàm (còn gọi là  `nested function`  hoặc  `local function`).
    
	-   Tương tự Dart cũng hỗ trợ  `top-level variable`.
    
	-   Không giống với Java, Dart không hỗ trợ  `public`,  `protected`, và  `private`. Nếu như  `identifier`  (tên biến, hàm,...) bắt đâu vời dấu gạch dưới ( _ ) , thì nó  `private`  trong  `library`  của nó. Mỗi file  `.dart`  được coi là 1  `library`. Chi tiết  [Libraries and visibility](https://www.dartlang.org/guides/language/language-tour#libraries-and-visibility)  .
    
	-   `Identifier`  có thể bắt đầu bằng một chữ cái hoặc dấu gạch dưới ( _ ).
    
	-   Sometimes it matters whether something is an expression or a statement, so it helps to be precise about those two words. (Đoạn này mình không hiểu lắm, anh em chia sẻ giúp)
    
	-   Dart tools có thể báo cho bạn 2 loại vấn đề: warnings và errors. Warnings là những dấu hiểu chỉ ra rằng code của bạn có thể không hoạt động, nhưng chương trình của bạn vẫn có thể chạy. Errors có thể là error lúc compile-time hoặc run-time. Error lúc compile-time hiển nhiên sẽ khiến code bạn không chạy được, còn kết quả của error run-time sẽ là những  [exceptions](https://www.dartlang.org/guides/language/language-tour#exceptions)  được throw ra khi chạy.

<a name="muc2"></a>
## 2. Cài đặt Dart trên Window.
- Để cài đặt Dart thì đầu tiên phải cài thêm [Chocolatey](https://chocolatey.org/install#individual):
	+ Mở PowerShell chạy quyền Administrator chạy lệnh: `Get-ExecutionPolicy` => Kết quả trả về *Restricted*
	+ Tiếp theo chạy lệnh: `Set-ExecutionPolicy AllSigned`.
	+ Bây giờ chạy lệnh cài đặt Chocolatey: 
	
	```Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))```

- Sau khi cài đặt xong Chocolatey thì ta chạy lệnh để cài đặt Dart:
	```
	choco install dart-sdk
	```
	Đây là hình ảnh sau khi cài đặt Dart thành công!
	![](https://i.imgur.com/lGDSF9B.png)

> Cài đặt Dart SDK bằng cách tải về Dart: [https://gekorm.com/dart-windows/](https://gekorm.com/dart-windows/)
<a name="muc3"></a>
## 3. Chương trình Dart đầu tiên.
- Chương trình đầu tiên trên DartPad:
	 ```dart
	 void main() {
	    print('hello world');
	}
	 ```

	Ta thu được kết quả:

	![](https://i.imgur.com/AYfsTBG.png)

- Bạn có thể dùng dòng lệnh cmd bằng cách tạo một file `hello.dart` bất kì có nội dung như trên => dùng CMD để chạy lệnh `dart hello.dart` để thực thi chương trình:
Kết quá:
![](https://i.imgur.com/bNOQJBQ.png)

- Nếu bạn dùng VSCode thì có thể cài đặt plugin Dart để code Dart:
![](https://i.imgur.com/FGTIPK7.png)