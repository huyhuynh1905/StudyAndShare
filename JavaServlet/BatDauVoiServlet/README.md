
<h1 align="center">Bắt Đầu Với Java Servlet</h1>

### Nội dung
1. [***Servlet là gì?***](#muc1) 
2. [***Cấu hình và thư viện.***](#muc2) 
3. [***Chương trình Servlet đầu tiên.***](#muc3)

<a name="muc1"></a>
## 1. Servlet là gì?

![](https://www3.ntu.edu.sg/home/ehchua/programming/howto/images/HTTP_ClientServerSystem.png)

- Servlet có thể được mô tả bằng nhiều cách, tùy thuộc vào ngữ cảnh:
	-   Servlet là một công nghệ được sử dụng để tạo ra ứng dụng web.
	-   Servlet là một API cung cấp các interface và lớp bao gồm các tài liệu.
	-   Servlet là một thành phần web được triển khai trên máy chủ để tạo ra trang web động.
- Có nhiều interface và các lớp trong API servlet như Servlet, GenericServlet, HttpServlet, ServletRequest, ServletResponse, ...
- Servlet thực hiện các nhiệm vụ chính sau đây:
	-   Đọc dữ liệu rõ ràng do khách hàng (trình duyệt) gửi. Điều này bao gồm một mẫu HTML trên một trang Web hoặc nó cũng có thể đến từ một applet hoặc một chương trình khách hàng HTTP tùy chỉnh.
	-   Đọc dữ liệu yêu cầu HTTP ẩn được gửi bởi khách hàng (trình duyệt). Điều này bao gồm các cookie, loại phương tiện truyền thông và các chương trình nén mà trình duyệt hiểu được, v.v.
	-   Xử lý dữ liệu và tạo ra các kết quả. Quá trình này có thể yêu cầu nói chuyện với một cơ sở dữ liệu, thực hiện một cuộc gọi RMI hoặc CORBA, gọi một dịch vụ Web, hoặc tính trực tiếp phản hồi.
	-   Gửi dữ liệu rõ ràng (tức là tài liệu) tới khách hàng (trình duyệt). Tài liệu này có thể được gửi bằng nhiều định dạng, bao gồm văn bản (HTML hoặc XML), nhị phân (hình ảnh GIF), Excel, v.v ...
	-   Gửi phản hồi HTTP ẩn cho khách hàng (trình duyệt). Điều này bao gồm nói với trình duyệt hoặc các trình khách khác loại tài liệu đang được trả về (ví dụ, HTML), thiết lập cookie và các tham số bộ nhớ đệm, và các tác vụ khác.

<a name="muc2"></a>
## 2. Cấu hình và thư viện.
- Khởi chạy bằng IntelliJ, tạo mới một Maven project trên IntelliJ:
   <div align="center"><img  src="https://i.imgur.com/Btm1FOs.png"/></div>

- Tiếp tục next và đặt tên, chọn nơi lưu cho project => nhấn finish:
   <div align="center"><img  src="https://i.imgur.com/IOKGbOj.png"/></div>

- Project sau khi được tạo ban đầu:
   <div align="center"><img  src="https://i.imgur.com/2LAPM66.png"/></div>
- Trong file `pom.xml` thì ta thêm `packaging` war vào (dòng 10), sau đó thêm các thư viện servlet vào và đồng bộ maven:
	<div align="center"><img  src="https://i.imgur.com/3AQb52N.png"/></div>
- Tạo một file `web.xml` với đường dẫn trong hình có nội dung:
	<div align="center"><img  src="https://i.imgur.com/XQr0yrb.png"/></div>
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <display-name>Tên Project</display-name>

</web-app>
```
- Cấu hình **Tomcat Server** (Thực hiện sau khi thêm packing war ở `pom.xml` và syn file pom) :
<div align="center"><img  src="https://i.imgur.com/gxFstGz.png"/></div>

- Sau đó phía dưới sẽ xuất hiện một dòng lỗi `Fix` ta tiến hành chọn như hình -> OK:
<div align="center"><img  src="https://i.imgur.com/jUY8OnV.png"/></div>

<a name="muc3"></a>
## 3. Chương trình Servlet đầu tiên.
- Cây thư mục của chương trình, các file thư viện và cấu hình ta làm như phần trên:
<div align="center"><img  src="https://i.imgur.com/hhn55TZ.png"/></div>

- Class `DemoServlet` ta extends từ `HttpServlet` của thư viện servlet, ta viết lại nội dung của 2 phương thức doGet() và doPost():
```java
@WebServlet("/demo-servlet")  
public class DemoServlet extends HttpServlet {  
    @Override  
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
  
        resp.setContentType("text/html"); //In ra dạng html  
  PrintWriter out = resp.getWriter(); //in ra màn hình giao diện html  
  out.println("Hello Servlet");  
  }  
  
    @Override  
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
        super.doPost(req, resp);  
  }  
}
```
- Trong file `index.jsp` ta thêm một dòng `<a href="demo-servlet"></a>`
- Trong `web.xml` ta tạo danh sách bắt đầu với `wellcome-list` như sau:
<div align="center"><img  src="https://i.imgur.com/75WGJiM.png"/></div>

- Chạy chương trình ta được kết quả:
<div align="center"><img  src="https://i.imgur.com/C319CaU.png"/></div>
