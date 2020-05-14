<h1 align="center">EL & JSTL Trong Spring MVC</h1>

### Nội dung
1. [***EL (Expression Language).***](#muc1) 
2. [***JSTL (Java Standard Tag Library).***](#muc2) 

<a name="muc1"></a>
## 1. EL (Expression Language).
- EL là cách viết mã trên `jsp` làm việc với các attribute đặt  trong các scope (page, request, session và application).
- Cú pháp: `${<biểu thức>}`.
- Trong biểu thức này có thể có thể chứa *attribute*, *parameter*, *cookie* hay *header*.
<div align="center"><img  src="https://i.imgur.com/BT5Vwfa.png"/></div>

- Như  đã  biết trong JSP có 4 scope chia sẻ dữ liệu

	+ Page: pageScope:`${pageScope[‘x’]} hoặc ${pageScope.x}`

	 + Request: requestScope: `${requestScope[‘x’]} hoặc ${requestScope.x}`

	+ Session: sessionScope: `${sessionScope[‘x’]} hoặc ${sessionScope.x}`

	+ Application: applicationScope : `${applicationScope[‘x’]} hoặc ${applicationScope.x}`

- Nếu attribute là một **bean** thì EL cho phép truy xuất các thuộc tính một cách đơn giản:  `${bean.property}`
<div align="center"><img  src="https://i.imgur.com/3tV4CTa.png"/></div>

> Lớp JavaBean là lớp: phải  khai  báo  là public, có Constructor mặc định  không  tham  số,đọc/ghi  dữ  liệu  thông qua phương  thức  getter/setter.

<a name="muc2"></a>
## 2. JSTL (Java Standard Tag Library).
- JSTL là bộ thư viện thẻ chuẩn được bổ sung với mục đích tối ưu lập trình giao diện trong JSP.
- Thư viện: [Link Maven](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)
- Trong JSTL có rất nhiều bộ thẻ để xử lý các vấn đề khác nhau:
	+ Core: chứa các thẻ lệnh điều khiển cơ bản.
	+ Format: chứa các thẻ định dạng và đa ngôn ngữ.
	+ Xml: chứa các thẻ xử lý xml.
	+ Sql: chứa các thẻ làm việc với CSDL.
	+ Function: cung cấp các hàm hỗ trợ cho EL.
- Một số thẻ cơ bản:
	+ Thư viện cơ bản:
		```
		<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
		```
	+ Thư viện hàm:
		```
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn“  %>
		```

- Core chứa các thẻ thay thế các lệnh cơ  bản trong Java để phù hợp với lập trình giao diện theo cú pháp  thẻ.
	+ `<c:if>`: Tương tự lệnh if trong java.
	+ `<c:choose>`: Tương tự if…else if…else  trong java.
	+ `<c:foreach>`: Tương tự for-each trong java.
	+ `<c:set>`:Tương tự: \<scope>.setAttribute()  trong java
- Ví dụ demo3:
	+ file demo3.jsp: [Link](https://github.com/huyhuynh1905/StudyAndShare/blob/master/FPTSpringMVC/ELandJSTL/fptspringmvclab4/src/main/webapp/WEB-INF/views/demo3.jsp).
	+ Controller và kết quả:
	<div align="center"><img  src="https://i.imgur.com/mKOQ5EP.png"/></div>
	
- Ví dụ demo4: `<c:set>`
	<div align="center"><img  src="https://i.imgur.com/4CLCIKv.png"/></div>

- Ví dụ demo5: function
<div align="center"><img  src="https://i.imgur.com/zxSAQxy.png"/></div>