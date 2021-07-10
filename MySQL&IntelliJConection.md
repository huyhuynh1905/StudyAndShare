<h1 align="center">Cài Đặt Và Kết Nối MySQL Với IntelliJ</h1>

### Nội dung
1. [***Cài đặt MySQL.***](#muc1) 
2. [***Kết nối với IntelliJ.***](#muc2)

<a name="muc1"></a>
## 1. Cài đặt MySQL.
- Đầu tiên các bạn vào trang chủ của MySQL để download phần mềm cài đặt về máy ([Link Download](https://dev.mysql.com/downloads/workbench/)) hoặc có thể tải bản [MySQL 8.0.20.0](https://actvneduvn-my.sharepoint.com/:u:/g/personal/at131217_actvn_edu_vn/EY_KaYdTrIhMug98-oDbtE8BDiY4WLeSi16xtAqnJRbe7A?e=qYAXon).
 <div align="center"><img  src="https://i.imgur.com/daIiqkC.png"/></div>

- Khởi động phần mềm và tiến hành cài đặt:
	> B1: Đồng ý với điều khoản sử dụng phần mềm và **OK**:
<div align="center"><img  src="https://i.imgur.com/UV1WkYl.png"/></div>

	
> Bước này bạn chọn **Excute** và đợi cài đặt các gói cài đặt -> Chọn **Next** -> **Yes**:
	
<div align="center"><img  src="https://i.imgur.com/jjL7Jvu.png"/></div>

> Bước này tiếp tục chọn **Excute** và tiếp tục đợi cài đăt -> **Next** liên tục:

<div align="center"><img  src="https://i.imgur.com/qR0HOQn.png"/></div>

> Đến đây đặt **password** cho database -> Tiếp tục **Next**: 

<div align="center"><img  src="https://i.imgur.com/obV4Ucv.png"/></div>


> Đến đây chọn **Excute** và tiếp tục đợi các gói cài đặt:

<div align="center"><img  src="https://i.imgur.com/VoTclfZ.png"/></div>

> Sau đó **finish** quá trình cài đặt xong, mở MySQL lên sẽ bắt chúng ta nhập **password** để vào, vậy là hoàn tất cài đặt:

<div align="center"><img  src="https://i.imgur.com/O2tawc3.png"/></div>


<a name="muc2"></a>
## 2. Kết nối với IntelliJ.
- Giả sử đối với một dự án web ta có tạo một CSDL gồm có 2 bảng như sau:

<div align="center"><img  src="https://i.imgur.com/02Kr4nO.png"/></div>

- Trong IntelliJ, chọn **Database** ở thanh bên phải -> **+** -> **Data Source** -> Chọn tiếp **MySQL**:

<div align="center"><img  src="https://i.imgur.com/Kqunl2N.png"/></div>

- Sau đó một cửa sổ kết nối hiện lên, nhập các tham số **User** và **Pass word** của MySQL (user thường là root) -> **Test Connection** để tiến hành kiểm tra kết nối và cài đặt Driver nếu có -> Kết nối thành công thì chọn **OK**:

<div align="center"><img  src="https://i.imgur.com/Z7ZFS6y.png"/></div>

- Sau khi kết nối thành công thì bên bảng **Database** sẽ hiện lên các cơ sở dữ liệu chúng ta có, có thể ẩn hoặc hiện ra bằng cách nhấn vào số bên cạnh: 
<div align="center"><img  src="https://i.imgur.com/bp3WWuf.png"/></div>

- Sử dụng khá đơn giản bằng IntelliJ, muốn sử dụng query console thì chỉnh cần click chuột phải vào database -> new -> query console. Còn nếu muốn nhập dữ liệu vào một bảng thì chỉ cần đúp vào một bảng và chọn dấu **+** để tiến hành nhập dữ liệu vào database:
<div align="center"><img  src="https://i.imgur.com/Lt42ZAS.png"/></div>

> Sau khi thêm sửa xong nhấn tổ hợp **Ctrl + Enter** để đồng bộ dữ liệu giữa IntelliJ và MySQL.

> Trong project tạo một thư mục ApplicationFile để chứa các file cần trong dự án, ví dụ như trong thư mục File đó có một thư mục Database chứa các đoạn script khởi tạo cơ sở dữ liệu và ràng buộc chúng (Giúp dự án dễ hiểu, dễ quản lí hơn):
	<div align="center"><img  src="https://i.imgur.com/3lW2QhQ.png"/></div>
