
<h1 align="center">ModelAttribute Và Các Thuộc Tính Điều Khiển Trong Spring</h1>

### Nội dung
1. [***Cơ chế buộc dữ liệu.***](#muc1) 
2. [***Các điều khiển của Form Jsp Trong Spring.***](#muc2) 
3. [***Annotation @ModelAttribute.***](#muc3)
4. [***Bài tập.***](#muc4)
5.  [***Lỗi cơ bản gặp phải.***](#muc5)

<a name="muc1"></a>
## 1. Cơ chế buộc dữ liệu.

![](https://i.imgur.com/eRVLEY9.png)

- Databinding là sự kết nối dữ liệu của **bean** đặt trong *model* đến các điều khiển trên form.
- Khi thay đổi dữ liệu trên **bean** (*model*) thì dữ liệu điều khiển cũng thay đổi theo.
- Ràng buộc dữ liệu có thể là 1 chiều hoặc 2 chiều:
	+ Chiều lên: chuyển dữ liệu từ các điều khiển vào các thuộc tính của **bean**.
	+ Chiều xuống: hiển thị dữ liệu từ các thuộc tính của **bean** về các điều khiển của form.
- Thông thường thì ta dùng các biểu thức EL để buộc dữ liệu:
![](https://i.imgur.com/yB6A9eW.png)

- Dù vậy vẫn có những hạn chế khi dùng các biểu thức EL như:
	+ Phải viết mã dài dòng, khó quản lí.
	+ Đổ dữ liệu vào các list trở nên phức tạp (checkbox, radiobutton, combox,...).

> Chúng ta khắc phục ở phần 2.



<a name="muc2"></a>
## 2. Các điều khiển của Form Jsp Trong Spring.

- Spring MVC cung cấp thư viện thẻ `taglib` giúp ràng buộc dữ liệu từ bean trở nên dễ dàng hơn. Thêm đoạn sau vào đầu file `jsp` nếu làm việc với form:
	```java
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	```
	> Đọc thêm về taglib form [tại đây](https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/view.html)

- Sau khi khai báo, chúng ta có thể tạo form và ràng buộc dữ liệu:
![](https://i.imgur.com/HK0KTHu.png)
	>Chú ý ta thấy **form** mà tím chính là `prefix="form"` mà chúng ta đã khai báo ở trên.
	> Chú ý là phải tạo một class `Student` có các thuộc tính `user` và `pass` tương ứng. [Link class theo source kèm theo](https://github.com/huyhuynh1905/StudyAndShare/blob/master/FPTSpringMVC/AttributeAndFormInSpring/fptspringmvclab3/src/main/java/com/huyhuynh/models/Student.java).

- Các điều khiển form tương ứng:
![](https://i.imgur.com/PK3KYXZ.png)
	> 3 điều khiển cuối là các list control cần được cung cấp dữ liệu từ mảng, Map hoặc Collection.

-  Đổ dữ liệu vào **List Control**:
	```java
	<form:select path="tenthuoctinhcuaclass" items = "{items}"/>
	```	
<div align="center"><img  src="https://i.imgur.com/bfEA4rQ.png"/></div>
- Đối với tập item là *Conllection* hoặc *Map*:
	```java
	<form:radiobuttons path="level" items="${levels}" itemValue="id" itemLabel="name"/>
	```	
	+ Các `itemValue` và `itemLabel` lần lượt chỉ ra tên thuộc tính để làm giá trị và tên thuộc tính dùng để làm nhãn (hiển thị ra web).
<div align="center"><img  src="https://i.imgur.com/C8i4R2s.png"/></div>

<a name="muc3"></a>
## 3. Annotation @ModelAttribute.
- Trong Spring MVC thì @ModelAttribute được sử dụng để bổ sung attribute vào model trong 2 trường hợp:
	+ @ModelAttribute(name) \<argument>:  nói dễ hiểu là được sử dụng như một tham số trong một phương thức.
	![](https://i.imgur.com/alfoUUD.png)
	+ @ModelAttribute(name) \<method>: được sử dụng đứng trước một method.
	![](https://i.imgur.com/1DT0YUJ.png)

<a name="muc4"></a>
## 4. Bài tập.
- Mình sẽ thực hành thao tác với form thông qua những thứ đã học ở trên để tạo ra một trang như sau được truyền từ trang trang khác: 
![](https://i.imgur.com/JnQLWTP.png)

- Cấu trúc của bài lab như sau: 
<div align="center"><img  src="https://i.imgur.com/aW72YCt.png"/></div>

- Đây là trang `studentpage.jsp` mà ta sẽ đổ dữ liệu ra để hiển thị:
<div align="center"><img  src="https://i.imgur.com/kp5Obvp.png"/></div>

- Phương thức đổ dữ liệu ra ở trong class StudentController:
<div align="center"><img  src="https://i.imgur.com/AexMzAf.png"/></div>

- Đối với việc đổ dữ liệu ra combox (thuộc tính chuyên ngành - major) và radiobutton (thuộc tính chức vụ -level) thì ta sử dụng `@ModelAttribute` cho hai phương thức:
<div align="center"><img  src="https://i.imgur.com/XQk8vFI.png"/></div>

> - Đối với method trả vể mảng thì giá trị của thuộc tính **major** sẽ tương ứng với mỗi phần tử giống nó trong mảng.
> - Trường "id" trong class `Level` chính là giá trị tương ứng của thuộc tính **level** trong class `Student`.


<a name="muc5"></a>
## 5. Lỗi cơ bản gặp phải.
- Trong quá trình làm vì việc viết đến đâu test đến đó mà mình gặp phải một lỗi khiến mình đã phải suy nghĩ tìm cách fix đến một ngày :)))).
- Mình có một trang `loginpage.jsp` để tiến hành đăng nhập có sử dụng điền khiển `modelAttribute="student"` ở trường `<form>`:
<div align="center"><img  src="https://i.imgur.com/su2Wkc3.png"/></div>

- Mình đã viết đại một phương thức để show ra trang này chủ yếu nên không có tham số truyền vào: 
<div align="center"><img  src="https://i.imgur.com/G513MsB.png"/></div>

- Điều đó dẫn đến việc không thể load được trang với lỗi :
<div align="center"><img  src="https://i.imgur.com/zgLii79.png"/></div>

- Để khắc phục lỗi này thì bắt buộc phải viết tham số truyền vào cho phương thức gắn với `action` trong `<form>`:
<div align="center"><img  src="https://i.imgur.com/2vxiJzg.png"/></div>