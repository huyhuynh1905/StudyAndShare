
<h1 align="center">Dependence Injection Và Upload File Trong Spring MVC</h1>

### Nội dung
1. [***Dependence Injection .***](#muc1) 
2. [***Upload File lên server.***](#muc2) 
<a name="muc1"></a>
## 1. Dependence Injection.
> DI: Dependence Injection
- Dependence Injection trong Spring MVC giải quyết bài toán thay đổi thông tin các đối tượng mà không phải hiệu chỉnh lại mã của website.
- DI là  cách  truyền  một module vào  một module khác  thông qua cấu  hình XML hay viết  mã  dưới  sự  hỗ  trợ  của DI container/
- DI được dùng để làm giảm sự phụ thuộc giữa các module, dễ dàng hơn trong việc thay đổi module, bảo trì code và testing.
- Để hình dung ta tiến hành thực hành:
>B1: Đầu tiên ta cứ tiến hành tạo project cơ bản như ở [StartWithSpringMVC](https://github.com/huyhuynh1905/StudyAndShare/tree/master/FPTSpringMVC/StartWithSpringMVC), cấu trúc bài như sau:
<div align="center"><img  src="https://i.imgur.com/iOSo9yz.png"/></div>

>B2: Để cụ thể hoá DI thì ta tạo một lớp `Company.java`:
<div align="center"><img  src="https://i.imgur.com/4rw7LiA.png"/></div>

>B3: Khai  báo bean trong file cấu  hình  của Spring. DI container sẽ  tạo  đối  tượng  khi  khởi  khởi  động. Ở đây mình tạo ví dụ 3 đối tượng: 

```xml
<!--Cấu hình bean cho một class-->  
<bean id="companyKMA" class="com.huyhuynh.models.Company">  
	 <property name="name" value="KMA Huy"/>  
	 <property name="slogan" value="Spring MVC"/>  
	 <property name="logo" value="/images/spring-mvc.png"/>  
</bean>  
<bean id="companyFPT" class="com.huyhuynh.models.Company">  
	 <property name="name" value="FPT Spring"/>  
	 <property name="slogan" value="FPT Spring MVC"/>  
	 <property name="logo" value="/images/spring-mvc.png"/>  
</bean>  
<bean id="companyLab" class="com.huyhuynh.models.Company">  
	 <property name="name" value="Spring Lab 5"/>  
	 <property name="slogan" value="Spring MVC Lab 5"/>  
	 <property name="logo" value="/images/spring-mvc.png"/>  
</bean>
```

>B4: Sau  khi bean được  khai  báo  nó  có  thể  được  tiêm  vào  các  thành  phần  khác  để  sử  dụng  bằng  cách  sử  dụng `@Autowired`  và `@Qualifier`. Lớp Controller có 3 cách để sử dụng các bean đã khai báo này:

<div align="center"><img  src="https://i.imgur.com/ErHGbpf.png"/></div>

>B5: Tạo file `demobean.jsp` để hiển thị kết quả:

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>  
<html>  
<head>  
 <title>Demo Bean</title>  
</head>  
<body>  
 <img src="<c:url value="${companyKMA.logo}" />">  
 <div>${companyKMA.name}</div>  
 <div>${companyKMA.slogan}</div>">  
    <br>  
 <div>FPT</div>  
 <div>${companyFPT.name}</div>  
 <div>${companyFPT.slogan}</div>
</html>
```

>B6: Ta thu được kết quả hiển thị: 
<div align="center"><img  src="https://i.imgur.com/D7iCz9H.png"/></div>

> Thêm: @Autowired  sẽ  nhận  biết bean thông qua kiểu  dữ  liệu.
> > Lớp bean được  chú  thích  bởi  @Component hoặc  @Service, @Repository sẽ  tự  khai  báo  mà  bạn  không  cần  phải  khai  báo  bằng  tay  vào file cấu  hình. Tuy nhiên cần định nghĩa lớp chứa bean vào: ![](https://i.imgur.com/D18d70S.png)
> Tạo một Class component:
![](https://i.imgur.com/dw07KVd.png)
Sử dụng class này bằng @Autowired  khai báo ở như trên kia bình thường.


<a name="muc2"></a>
## 2. Upload File lên server.
- Upload file là  một  chức  năng  quan  trọng  trong  ứng  dụng web.
- Thêm thư viện cần thiết vào file `pom.xml`:
	```xml
	<dependency>  
		 <groupId>commons-io</groupId>  
		 <artifactId>commons-io</artifactId>  
		 <version>2.4</version>  
	</dependency>  
	<dependency>  
		 <groupId>commons-fileupload</groupId>  
		 <artifactId>commons-fileupload</artifactId>  
		 <version>1.4</version>  
	</dependency>
	```
- Để  upload file, trước  hết  bạn  cần  khai  báo bean `CommonsMultipartResolver`  vào file cấu  hình: 
![](https://i.imgur.com/CCwnSwr.png)
	```xml
	<!--Bean upoadfile-->  
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">  
		 <property name="maxUploadSize" value="20971520"/>  
	</bean>
	```

- Tạo một trang `demoupload.jsp` :
<div align="center"><img  src="https://i.imgur.com/VFUTwXB.png"/></div>


>Chú ý: Form upload file bắt  buộc  các  thuộc  tính:
>+ method=“POST”
>+ enctype=“multipart/form-data”

	Trang này cho nội dung: 
	
<div align="center"><img  src="https://i.imgur.com/aZIJxjr.png"/></div>

- Controller xử lí uploadfile: 
<div align="center"><img  src="https://i.imgur.com/lL4VL1B.png"/></div>

- Trang `uploadsuccess.jsp` hiển thị các thông tin mà controller ở trên trả về: 
<div align="center"><img  src="https://i.imgur.com/tAkVv7c.png"/></div>

- Kết quả:
<div align="center"><img  src="https://i.imgur.com/PomWTC9.png"/></div>

> Chú ý: Trong bài này bắt buộc phải thêm `mvc:resources` trong **bean** nếu không có thể ảnh sẽ không hiển thị:
> ```xml
> <mvc:resources mapping="/images/**" location="/WEB-INF/views/images/"/>
> ```
> ![](https://i.imgur.com/AVkShKK.png)