<h1 align="center">Hibernate Với Java Servlet</h1>

### Nội dung
1. [***Hibernate là gì?***](#muc1) 
2. [***Cấu hình và thư viện.***](#muc2) 
3. [***Xây dựng class kết nối.***](#muc3)

<a name="muc1"></a>
## 1. Hibernate là gì?
- Hibernate là Framework thực hiện mapping CSDL với đối tượng, nó nằm ở giữa ứng dụng và lớp kết nối dữ liêu (Data Access Layer).
   <div align="center"><img  src="https://i.imgur.com/9wj9NtV.png"/></div>

- Hibernate Application Architecture: 
<div align="center"><img  src="https://www.tutorialspoint.com/hibernate/images/hibernate_high_level.jpg"/></div>


	+ SessionFactory (Không thay đổi giá trị): Mapping tới các bảng dữ liệu trong database. Lấy ra các bảng tương ứng Database đó và trả về session.
    + Session: Nhiệm vụ liên kết với EntityManager để thực hiện câu truy vấn cho các bảng tương ứng.
    + Transaction: Quản lí các giao dịch.

<a name="muc2"></a>
## 2. Cấu hình và thư viện.
- Thư viện (Ở đây cơ sở dữ liệu mình dùng là mySQL):

```xml
<dependency>  
 <groupId>mysql</groupId>  
 <artifactId>mysql-connector-java</artifactId>  
 <version>${mysql.connector.version}</version>  
</dependency>  
<dependency>  
 <groupId>org.hibernate</groupId>  
 <artifactId>hibernate-core</artifactId>  
 <version>${hibernate.version}</version>  
</dependency>
```

- Cấu hình file `hibernate.cfg.xml` trong thư mục **resource** có chức năng kết nối đến mySQL, file này sẽ cấu hình **session factory** khởi tạo Driver và thông tin cần thiết kết nối đến CSDL:


<div align="center"><img  src="https://i.imgur.com/k6fp7vD.png"/></div>

```xml
<?xml version = "1.0" encoding = "utf-8"?>  
<!DOCTYPE hibernate-configuration SYSTEM  
  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">  
<hibernate-configuration>  
 <session-factory> <property name = "hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>  
 <property name = "hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>  
 <property name = "hibernate.connection.url">jdbc:mysql://localhost:3306/toeiconline?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&connectionCollation=utf8_unicode_ci&characterSetResults=UTF-8</property>  
 <property name="show_sql">true</property>  
 <property name = "hibernate.connection.username">root</property>  
 <property name = "hibernate.connection.password">123456</property>  
 </session-factory></hibernate-configuration>
```


<a name="muc3"></a>
## 3. Xây dựng class kết nối:
- Trong module **core-common** chứa các class dùng chung cho toàn bộ hệ thống nên ta sẽ tạo một package **.core.common.utils** chứa các tiện ích dùng chung cho hệ thống. Class kết nối với file `hibernate.cfg.xml` cũng được chứa trong package này.
- Tạo một class `HibernateUtil` để tạo ra đối tượng SessionFactory làm việc với CSDL 

<div align="center"><img  src="https://i.imgur.com/yIiYTKD.png"/></div>

> Class này trả về cho ta một đối tượng SessionFactory thông qua duy nhất phương thức getSessionFactory().
