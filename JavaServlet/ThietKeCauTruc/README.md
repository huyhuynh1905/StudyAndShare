<h1 align="center">Thiết Kế Một Cấu Trúc Các Module Servlet</h1>

### Nội dung
1. [***Khởi tạo project.***](#muc1) 
2. [***Module web-logic.***](#muc2) 
3. [***Module toeic-web.***](#muc3)
4. [***Các module-core khác.***](#muc4)

<a name="muc1"></a>
## 1. Khởi tạo project.
- Ta khởi tạo một Maven project mới:
 <div align="center"><img  src="https://i.imgur.com/wo33c2H.png"/></div>
 
 - Ta xem project này là một project cha (root) chứa các module project con để dễ quản lí, build maven.
 - Trong file `pom.xml` của lớp cha chứa một `<packaging>pom</packaging>` (lúc tạo các module sau thì intelliJ sẽ tự thêm vào cho mình).
 - Trong file `pom.xml` của lớp cha ta sẽ khai báo toàn bộ thư viện dùng trong các module con:

	```xml
	<properties>  
	 <javaservlet.api.version>3.1.0</javaservlet.api.version>  
	</properties>  
	  
	<dependencies>  
	 <dependency> <groupId>javax.servlet</groupId>  
	 <artifactId>javax.servlet-api</artifactId>  
	 <version>${javaservlet.api.version}</version>  
	 <scope>provided</scope>  
	 </dependency>
	</dependencies>
	```

 - Click phải chuột vào project cha và new một  module để thêm các modelu mà ta cần dùng:
  <div align="center"><img  src="https://i.imgur.com/sUTk1ch.png"/></div>

<a name="muc2"></a>
## 2. Module web-logic:
- Trong file `pom.xml` của module này, ta khai báo đến file `pom.xml` của lớp cha để có thể nhận thư viện của lớp cha:
	```xml 
	<relativePath>../pom.xml</relativePath>
	```

 <div align="center"><img  src="https://i.imgur.com/xKjULBQ.png"/></div>
 
- Trong file `pom.xml` của project cha cũng cần phải khai báo cho module này (Nếu bằng intelliJ thì khi tạo module mới sẽ tự động được khai báo thêm vào file `pom.xml` của lớp cha các module này):
	```xml
	<modules>  
	 <module>toeic-web-logic</module>  
	</modules>
	```
- Trong Module này tạo các package **controller**, **command**, **utils**, **common**, 
<div align="center"><img  src="https://i.imgur.com/qICgylx.png"/></div>

		- **controller**: Là package chứa các class servlet.
		- **command**: Chứa các model.
		- **common**: Trong package chứa một class `WebConstaint` chứa tất cả các hằng số dùng chung cho toàn bộ web-logic-controller.
		- **utils**: Chứa các tiện ích, phương thức dùng chung cho web.

<a name="muc3"></a>
## 3. Module toeic-web:
- Đây là module build ra gói war để deloy lên server.
<div align="center"><img  src="https://i.imgur.com/P0AzeLd.png"/></div>

- Trong main tạo một folder `webapp` -> Tạo một folder nữa là `WEB-INF` -> Tạo tiếp một file `web.xml`:
```xml
<?xml version="1.0" encoding="ISO-8859-1"?>  
  
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"  
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee  
 http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" version="3.1">  
 <display-name>Toeic Online</display-name>  
  
</web-app>
```
> Trong này điền thêm các đối tượng như welcome-file-list,...

- Trong file `pom.xml` của module này cũng thêm các khai báo  đến `pom.xml` module cha và thêm `<packaging>war</packaging>` (Vì đây sẽ là module build ra server):
<div align="center"><img  src="https://i.imgur.com/4FiZXK9.png"/></div>

- Để các module có thể sử dụng với nhau, ví dụ như từ module web sử dụng đến module web-logic thì ta khai báo trong `pom.xml` dependency (version chính là version trong thẻ `<parent>` ở file `pom.xml` của module thêm vào):
```xml
<dependency>  
 <groupId>huyhuynh.com</groupId>  
 <artifactId>toeic-web-logic</artifactId>  
 <version>1.0-SNAPSHOT</version>  
</dependency>
```

<a name="muc4"></a>
## 4. Các module-core khác:
- Các module khác cần được tạo để chia dự án:
<div align="center"><img  src="https://i.imgur.com/o5JYk9A.png"/></div>

- Trong các module này tất cả trong file `pom.xml` đều phải khai báo `<relativePath>../pom.xml</relativePath>` đến `pom.xml` của module cha.
- Sau khi tạo xong các module trên thì chạy clean maven để hoàn tất các bước căn bản của một project servlet. Dùng lệnh `mvn clean install` hoặc kick phải file pom -> maven -> **Reimport**
<div align="center"><img  src="https://i.imgur.com/lhpELmq.png"/></div>

- Chi tiết từng phần được nói rõ ở đây: 

	+ Module **core-common**: Chứa tất cả các class, phương thức dùng chung cho toàn bộ hệ thống.
	+ Module **core-persistence-data**: Chứa tất cả các Entity (java bean) của các bảng của CSDL, trong CSDL có bao nhiêu bảng thì phải có bấy nhiêu lớp Entity.
	+ Module **core-data**: Chứa các API đọc đến CSDL như các API về findAll() hay upDate().
	+ Module **core-dao**: Chứa các interface chức năng của các class entity
	+ Module **core-dao-impl**:  Chứa các class triển khai implement các interface từ core-dao.
	+ Module **core-dto**: dto là trung gian để hiển thị dữ liệu lên view. dto sẽ nhận dữ liệu từ entity thông qua service