<h1 align="center">Observer Pattern (Người quan sát)</h1>

##### BẠN BIẾT CÁCH ĐĂNG KÝ MUA MUA MỘT TỜ BÁO HOẶC TẠP CHÍ NHƯ THẾ NÀO KHÔNG:

1.  Một nhà xuất bản báo đi vào kinh doanh và bắt đầu xuất bản báo.
2.  Bạn đăng ký vào một nhà xuất bản cụ thể và mỗi khi có một bài báo mới, nó sẽ được gửi cho bạn. Miễn là bạn vẫn là một thuê bao, bạn sẽ nhận được báo mới.
3.  Bạn hủy đăng ký khi bạn không muốn mua nữa và chúng sẽ không được gửi cho bạn.
4.  Trong khi đó nhà xuất bản vẫn kinh doanh, người dân, khách sạn, hãng hàng không và các doanh nghiệp khác vẫn liên tục đăng ký và hủy đăng ký mua báo.

Ta có thể coi  **Publishers + Subscribers = Observer Pattern** (Nhà xuất bản + Người đăng ký = Mẫu người quan sát).
> Chúng ta sẽ gọi nhà xuất bản là **SUBJECT** và người đăng kí là **OBSERVER**.

#### Định nghĩa về Observer Pattern:  ***Observer pattern xác định một phụ thuộc một-nhiều giữa các đối tượng để khi một đối tượng thay đổi trạng thái, tất cả các phụ thuộc của nó được thông báo và tự động cập nhật.***

> Nói dễ hiểu thì là: **Observer** phụ thuộc vào **Subject** sao cho khi **Subject** thay đổi trạng thái, **Observer** sẽ được thông báo. Tùy thuộc vào cách thông báo, **Observer** cũng có thể được cập nhật với các giá trị mới.
<div align="center"><img  src="https://i.imgur.com/TDCCDoo.png"/></div>

####  Loose Coupling (Khớp nối lỏng lẻo trong Observer):
Ta có thể hiểu là hai đối tượng có khớp nối lỏng lẻo là hai đối tượng tương tác nhưng không biết rõ về nhau:
- Điều duy nhất mà Subject biết về một người quan sát (observer) là nó implement một interface nhất định (interface Observer). - Nó không cần biết lớp con của Observer, những gì lớp con làm,...
- Có thể thêm, xoá observer bất cứ lúc nào mà không cần phải sửa đổi nội dung của subject.
- Chúng ta có thể tái sử dụng subject và observer độc lập với nhau hoặc thay đổi một trong hai mà không làm ảnh hưởng đến đối tượng còn lại.

Từ đó làm chúng ta có một nguyên tắc thiết kế khác: **Cố gắng tạo ra các thiết kế liên kết lỏng lẻo giữa các đối tượng tương tác**.

Đặt vấn đề: Chúng ta xây dựng một ứng dụng IoT nông nghiệp, trong đó các cảm biến nhiệt độ, độ ẩm được đặt trên khu vườn nhằm mục đích thu thập dữ liệu. Mỗi khi các thông số thay đổi thì sẽ cập nhật đến các màn hiền hiển thị thông số, giả sử ta có 3 màn hình hiển thị khác nhau cho các yêu cầu khác nhau như màn hình hiển thị thông số, màn hình cảnh báo tưới nước và màn hình theo dõi trên điện thoại.

<div align="center"><img  src="https://i.imgur.com/xvkC9wS.png"/></div>

Ta tiến hành xây dựng các chức năng của chương trình này:

- Đầu tiên ta xây dựng 2 interface là `Subject` và `Observer`:
<div align="center"><img  src="https://i.imgur.com/HlnbgCf.png"/></div>

- Tiếp theo ta sẽ xây dựng Class `ThuThapDuLieu` implements từ interface `Subject`:
<div align="center"><img  src="https://i.imgur.com/71edfbx.png"/></div>

- Sau đó là các class cảu các màn hình observer nhận thông tin từ subject trên:
<div align="center"><img  src="https://i.imgur.com/05yQONj.png"/></div>

> Các màn hình khác xây dựng tương tự, ta để ý thấy trong hàm contructor của các observer sẽ truyền vào subject mà nó muốn nhận thông tin, nó có chức năng quan trọng trong việc đăng kí thêm và xoá đi ác observer.

- Và đây là kết quả thu được khi chạy chương trình: 
<div align="center"><img  src="https://i.imgur.com/ZnnyyzG.png"/></div>
<div align="center"><img  src="https://i.imgur.com/xKyd3Yb.png"/></div>


**Tóm tắt nội dung**:
-   **Observer Pattern**  xác định mối quan hệ một-nhiều giữa các đối tượng.
-   **Subjects**, hoặc tên gọi khác như chúng ta cũng biết,  **Observable**, cập nhật những  **Observer**  bằng interface chung.
-   **Observer Pattern**  đạt được “khớp nối lỏng lẽo” trong đó Observable không biết gì về người quan sát (observer) , ngoài việc biết chúng implement interface Observer.
-   Bạn có thể push (đẩy) hoặc kéo (pull) dữ liệu từ  **Observable**  được khi sử dụng mẫu  **Observer Pattern**  (kéo(pull) được coi là chính xác hơn).
-   Không phụ thuộc vào một thứ tự thông báo cụ thể cho những Observer của bạn.
-   Java có một số triển khai Observer Pattern, chứa bên trong java.util.Observable. Xem qua các vấn đề khi triển khai java.util.Observable.