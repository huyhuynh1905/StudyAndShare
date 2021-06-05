
<h1 align="center">Strategy Pattern - Mẫu chiến lược</h1>

### Nội dung
<h1 align="center">Strategy Pattern (Mẫu chiến lược)</h1>

Đặt vấn đề: Giả sử chúng ta có một class cha là `Vit` nó là thể hiện của tất cả các lớp con kế thừa từ nó các chức năng và phương thức của lớp cha này.
<div align="center"><img  src="https://i.imgur.com/B9NMu8p.png"/></div>

- Vấn đề 1: Chuyện sẽ chẳng có gì xảy ra nếu như những class con tạo ra chỉ là những chú vịt bình thường như Vịt Trời hay Vịt Cỏ. Nhưng nếu chúng ta tạo một con Vịt Cao Su thì sao? Nó sẽ chẳng thể bay hoặc phát ra tiếng kêu.
- Vấn đề 2: Nếu chúng ta tách fly() và quack() ra thành các interface và khi có một loại vịt nào đó sử dụng thì implements nó thì sao? -  Nó sẽ phá hủy hoàn toàn việc sử dụng lại code cho các hành vi đó, vì vậy nó chỉ tạo ra một cơn ác mộng bảo trì khác. Và cũng sẽ có thêm nhiều kiểu bay khác nhau cho mỗi loại, sẽ thật khó nếu như phải bảo trì từng loại đối tượng một nếu như muốn sửa đổi về tiếng kêu.
> Tóm lại chúng ta đang có các vấn đề: trong quá trình phát triển phần mềm chúng ta có lẻ sẽ phải thêm mới các đối tượng mà đôi lúc chúng sẽ không cần đến một vài phương thức trong lớp cha mà nó kế thừa, hoặc các phương thức đó là khác nhau cho từng loại đối tượng dẫn đến việc chúng ta khó bảo trì sau này.

Từ đó chúng ta có nguyên tắc thiết kế đầu tiên: ***Tách những thứ thay đổi ra khỏi những thứ không thay đổi***. 

- Chúng ta sẽ tách các hành động fly() và quack() thành các interface, Các class thể hiện mỗi loại bay hay tiếng kêu sẽ implement và viết lại hành vi đó cho từng loại bay và kêu:

<div align="center"><img  src="https://i.imgur.com/XyF3hFU.png"/></div>

Việc tại sao `QuackBehaviors` và `FlyBehaviors` lại là các interface thì là theo nguyên tắc thiết kế thứ 2: ***Lập trình với một interface, không phải một lớp con*** (Program to an interface, not an implementation).
> Từ đây với thiết kế này, các loại đối tượng khác có thể sử dụng lại các hành vi fly và quack, bởi vì chúng không còn bị che giấu trong các lớp `Vit` của chúng ta! Và chúng ta có thể thêm các hành vi mới mà không cần sửa đổi bất kỳ hành vi hiện có nào hoặc sửa đổi vào bất kỳ lớp `Vit` nào sử dụng hành vi fly().

Được rồi, đến đây chúng ta có thể hoàn toàn viết lại toàn bộ các class trong ví dụ này. Trong `Vit` chúng ta sẽ có 2 thuộc tính là thể hiện instant của các kiểu bay và tiếng kêu bằng mối quan hệ **HAS-A**: 
<div align="center"><img  src="https://i.imgur.com/paRdS41.png"/></div>

Nguyên tắc thiết kế thứ 3: **Sử dụng việc kết hợp (Has-A) hơn là kế thừa**.

- Đối với mỗi hành vi Quack và Fly ta sẽ có các class tương ứng với đặc điểm của từng hành vi:
<div align="center"><img  src="https://i.imgur.com/Ug0BLrr.png"/></div>

- Các hành vi tiếng kêu
<div align="center"><img  src="https://i.imgur.com/vC11olW.png"/></div>

- Chúng ta cũng có một abstract class `Vit` khai báo các instant của các hành vi trên, cũng như các phương thức để gọi đến các hành vi:

<div align="center"><img  src="https://i.imgur.com/VvXYLB4.png"/></div>

- Chúng ta có các đối tượng vịt khác nhau có các hành vi khác nhau cùng kế thừa từ `Vit` và có các *contructor*  định nghĩa các biến `flyBehavior` và  `quackBehavior` từ lớp cha riêng cho mỗi loại vịt ứng với mỗi loại hành vi:

<div align="center"><img  src="https://i.imgur.com/t7oWUhx.png"/></div>

- Chúng ta thử chạy chương trình trên:
<div align="center"><img  src="https://i.imgur.com/QvYK6Ux.png"/></div>

Công việc nãy giờ chúng ta làm chính là áp dụng ***Strategy Pattern***:  **xác định một họ các thuật toán, gói gọn từng cái và làm cho chúng có thể hoán đổi cho nhau. Strategy cho phép thuật toán thay đổi độc lập với các client sử dụng nó.**

> Ở đây mình sẽ nói về 2 ký thuật là **ủy thác (delegate)** và **kết hợp (compose)**. Uỷ thác ở đây có nghĩa là bạn sẽ không cần tạo ra các phương thức fly() và quack() mà sẽ uỷ nhiệm các hành vi đó để xử lí ở các class khác. Kết hợp ở đây ví như là một con vịt sẽ có một hành vi bay mà nó uỷ nhiệm. 

Vấn đề: Chúng ta KHÔNG NÊN “program to an implementation”. Nhưng ở code trên thì chúng ta đang làm gì trong constructor đó? Chúng ta đang tạo một new instance của một lớp con kế thừa từ lớp Quack! => Strategy làm rất tốt trong việc thay đổi dễ dàng các biến thể của Fly và Quack, tuy nhiên lại chưa làm tốt trong việc khởi tạo các biến thể hiện một cách linh hoạt. (Các vấn đề này sẽ giải quyết dần trong các pattern khác - hiện tại thì chúng ta vẫn có rất nhiều tính linh hoạt độc lập ở đây)


**Tóm tắt nội dung**:
**Strategy** xác định một họ các thuật toán, gói gọn từng cái và làm cho chúng có thể hoán đổi cho nhau. Strategy cho phép thuật toán thay đổi độc lập với các client sử dụng nó.
	- Tách những thứ thay đổi ra khỏi những thứ không thay đổi.
	- Lập trình với một interface, không phải một lớp con.
	- Sử dụng việc kết hợp (Has-A) hơn là kế thừa.
