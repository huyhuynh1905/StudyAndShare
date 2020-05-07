<h1 align="center">Start With Spring MVC</h1>

### Nội dung
1. [***Xử lí Request trong Spring MVC.***](#muc1) 
2. [***Khởi tạo project đầu tiên trên IntelliJ.***](#muc2) 
3. [***Cấu hình web.xml và DispatcherServlet.***](#muc3)
4. [***Bài tập.***](#muc4)
> Note 1: Mình chủ yếu đi vào những phần đáng chú ý, các khải niệm, kiến trúc của framework có thể tham khảo thêm trên mạng.
> Note 2: Mình sẽ sử dụng IDE IntelliJ để hướng dẫn và thực hiện (Đây là IDE mình rất thích).

<a name="muc1"></a>
## 1. Xử lí Request trong Spring MVC.
Trong phần này mình sẽ nói về một phần quan trọng của Spring MVC đó là `DispatcherServlet`.

![](https://viblo.asia/uploads/9fdcb667-825a-42fb-9c78-187ae1a937f4.png)

DispatcherServlet  tiếp  nhận  mọi  yêu  cầu  từ  người  dùng  và  thực  hiện  điều  phối qua 4 bước  sau:
1. Chuyển URL cho  bộ  phận  Handler Mapping để  lấy  action method  muốn  gọi.
2. Gọi  action method  trong  Controller  và  nhận  kết  quả.
3. Chuyển  kết  quả  cho  bộ  phận  ViewResolver  để  lấy  đường  dẫn  View.
4. Gọi  View  để  kết  xuất  kết  quả  cho client.

<a name="muc2"></a>
## 2. Khởi tạo project đầu tiên trên IntelliJ.
Trong phần này ta làm theo thứ tự hướng dẫn:
![](https://i.imgur.com/WLvVeF3.png)
> B1: Chọn **Create New Project** -> **Maven** -> **Next**

![](https://i.imgur.com/AOjtHtn.png)

> B2: Đặt tên cho các trường `GroupId` (Tên cơ quan, tổ chức, cá nhân) và trường `ArtifactID` (Tên project,dự án,...)
> 
![](https://i.imgur.com/wYVMvF0.png)
> B3: Sau khi project tải xong thì tạo các file `webapp`,`WEB-INF`,`web.xml`,.. như trong hình. Trong flie `pom.xml` thêm dòng 10.
- Sau khi đã tạo ra các file như trên thì ta tiến hành cấu hình **server Tomcat** để có thể **run** dự án (Chú ý là các bạn):
	+ Trong IntelliJ chọn **Add Configuration...**:
	![](https://i.imgur.com/KPAwqr3.png)
	+ Click vào **+** -> **Tomcat Server** -> **Local**.
	![](https://i.imgur.com/YaMQYYh.png)
	+ Hộp thoài hiện lên báo lỗi ở góc, ta nhần vào **Fix** và chọn như hình:
	![](https://i.imgur.com/FYexNht.png)
	+ Tiến điền như hình -> **OK**.
	
![](https://i.imgur.com/TGYk8TS.png)

<a name="muc3"></a>
## 3. Cấu hình web.xml và DispatcherServlet.
- Nội dung của file `web.xml` ta tiến hành khai báo `DispatcherServlet`:
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"  
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee  
 http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"  version="3.1">  
     <servlet-mapping>  
		 <servlet-name>DispatcherServlet</servlet-name>  
		 <url-pattern>/</url-pattern>  
	 </servlet-mapping>     
	 <servlet>  
		 <servlet-name>DispatcherServlet</servlet-name>  
		 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>  
         <init-param>  
			 <param-name>contextConfigLocation</param-name>  
			 <param-value>WEB-INF/config/config-spring.xml</param-value>  
		 </init-param> 
	 </servlet>  
 </web-app>
```
> Trong `<init-param>` giá trị `<param-value>` là đường dẫn chỉ đến file cấu hình spring. Đó là file cấu hình cho phép sử dụng các *annotation*, chỉ định *package controller*, cấu hình *ViewResolver*,..
- Tạo file `config-spring.xml` trong thư mục **config** (thư mục có trong hình ở B3 trong [phần 2](#muc2))`có nội dung:

![](https://i.imgur.com/rR2Gy5E.png)
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<beans xmlns="http://www.springframework.org/schema/beans"  
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xmlns:context="http://www.springframework.org/schema/context"  
  xmlns:mvc="http://www.springframework.org/schema/mvc"  
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">  
  
	 <context:component-scan base-package="com.huyhuynh.controller"/>  
	 <mvc:annotation-driven/>  
  
	 <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">  
		 <property name="prefix" value="/WEB-INF/jsp"/>  
		 <property name="suffix" value=".jsp"/>  
	 </bean>
 </beans>
```

<a name="muc4"></a>
## 4. Bài tập.
- Từ những cấu hình trên mình thực hiện bài tập ví dụ cơ bản như sau:

![](https://i.imgur.com/zswYhsK.png)

- Đầu tiên mình thêm các thư viên cần thiết (Thật ra là phải thêm ngay khi mới tạo project :v) vào file `pom.xml`:
```xml
<dependencies>  
	 <dependency> 
		 <groupId>junit</groupId>  
		 <artifactId>junit</artifactId>  
		 <version>4.12</version>  
		 <scope>test</scope>  
	 </dependency> 
	 <dependency> 		
		 <groupId>org.springframework</groupId>  
		 <artifactId>spring-webmvc</artifactId>  
		 <version>5.1.9.RELEASE</version>  
	 </dependency> 
	 <dependency> 
		 <groupId>javax.servlet</groupId>  
		 <artifactId>javax.servlet-api</artifactId>  
		 <version>3.1.0</version>  
		 <scope>provided</scope>  
	 </dependency> 
	 <dependency> 
		 <groupId>javax.servlet</groupId>  
		 <artifactId>jstl</artifactId>  
		 <version>1.2</version>  
	 </dependency>
 </dependencies>
```
- Tiếp theo tiến hành tạo ra các file `userform.jsp`,`loginfailed.jsp`,`loginsuccess.jsp` có nội dung như sau:

![](https://i.imgur.com/WmZdzv7.png)
> Tạo ra các file *jsp* trong thư mục **webapp/WEB-INF/jsp**.
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<html>  
	<head>  
		<title>User Form</title>  
	</head>  
	<body>  
		 <form action="/user-login" method="post">  
			 <div>User: </div>  
			 <input name="user">  
			 <div>Password: </div>  
			 <input name="pass">  
			 <button>Login</button>  
		 </form>
	 </body>  
</html>
```
> file `userform.jsp`
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<html>  
	<head>  
		 <title>Đăng nhập thành công</title>  
	</head>  
	<body>  
		 <div>User: </div> ${user}  
		  <div>Pass: </div> ${pass}  
	</body>  
</html>
```
> file `loginsuccess.jsp`. các `${user}` và `${pass}` chính là các tham số sẽ được gửi vào từ class controller.
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<html>  
	<head>  
		<title>User Form</title>  
	</head>  
	<body>  
		${message}  
		<form action="/user-login" method="post">  
			 <div>User: </div>  
			 <input name="user">  
			 <div>Password: </div>  
			 <input name="pass">  
			 <button>Login</button>  
		</form>  
	</body>  
</html>
```
> file `loginfailed.jsp`. Tương tự thì ta cũng có `${message}` là tham số được truyền từ class controller.

- Tạo class `UserController` trong package **com.huyhuynh.controller**:

![](https://i.imgur.com/5U3rSsK.png)
> Trong phương thức *showLogin*  thì mình có sử dụng 2 cách để gửi dữ liệu cho *View* đó là là dùng `HttpServletRequest` và `ModelMap`. Mình có thể dùng cách nào cũng được.
- Tiến hành chạy chương trình thì ta hoàn thành giống như đề bài đặt ra.
