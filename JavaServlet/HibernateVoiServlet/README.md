<h1 align="center">Hibernate Với Java Servlet</h1>

### Nội dung
1. [***Hibernate là gì?***](#muc1) 
2. [***Cấu hình và thư viện.***](#muc2) 
3. [***Xây dựng class kết nối.***](#muc3)
4. [***Tạo các Entity của bảng dữ liệu.***](#muc4)
5. [***Thiết kế quan hệ (khoá ngoại) cho các Entity.***](#muc5)

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


<a name="muc4"></a>
## 4. Tạo các Entity của bảng dữ liệu.
- Trong module **core-persistence-data** sẽ chứa các Entity đại diện của các bảng trong đối tượng - ở CSDL có bao nhiêu bảng thì ở đây có bấy nhiêu class Entity, ví dụ ở đây ta tạo 2 entity *User* và *Role* đại diện cho 2 bảng trên CSDL:

<div align="center"><img  src="https://i.imgur.com/TAAtEQ1.png"/></div>

>- Trong ảnh trên có annotation **@Entity** dùng để khai báo đây là một class Entity với **@Table (name = "<Tên Bảng>")**.
>- Annotation **@Id** chỉ trường dữ liệu nào là khoá chính của bảng, trong này có thêm annotaion **@GenerateValue** chỉ là trường đó có tham số kiểu tự động tăng (Vì trong bảng này chỉ có 1 trường khoá chính và tự động tăng nên không cần dùng **@Column**).
> - Annotation **@column** dùng để ánh xạ tới các trường trong bảng CSDL.

- Sau khi tạo xong các lớp Entity thì cần phải thêm module **core-persistence-data** vào module có file `pom.xml` chứa gói war (cũng là module chứa file cấu hình `hibernate.cfg.xml` ở phần 2 - ví dụ này là ở module **toeic-web**). Ta thêm dependency module **core-persistence-data** vào:
<div align="center"><img  src="https://i.imgur.com/dwTDxPk.png"/></div>

- Sau khi thêm xong và refresh lại Maven thì ta tiến hành ánh xạ 2 class trên vào file cấu hình `hibernate.cfg.xml` để hoàn tất việc kết nối và ánh xạ:
<div align="center"><img  src="https://i.imgur.com/WjWBNsp.png"/></div>

<a name="muc5"></a>
## 5. Thiết kế quan hệ (khoá ngoại) cho các Entity.

- Như ví dụ trên thì giả sử 2 bàng trong CSDL **role** và bảng **user** có quan hệ 1-n (1 role có thể có nhiều user).
- Vậy trong class entity `User.java` ở trên ta thêm một trường thuộc tính thể hiện quan hệ với entity `Role.java`:

	```java
	@ManyToOne  
	@JoinColumn(name = "roleid")  
	private Role role;
	```
	> - Annotation **@ManyToOne** thể hiện khoá ngoại với dạng n-1, tức là sẽ có nhiều user có cùng 1 kiểu role.
	> - Annotation **@JoinColumn** để map vào trường thuộc tính roleid trong bảng `user` trong database.

- Trong class `Role.java` thì ngược lại, nó sẽ ở phía quan hệ 1-n nên khai báo một thuộc tính dạng List của `User`:

	```java
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)  
	private List<User> userList;
	```
	> - Vì `Role` thể hiện quan hệ 1-n nên nó sẽ dùng annotation **@OneToMany**.
	> > - Thuộc tính *mappedBy = "role"*: Dùng để ánh xạ đến thuộc tính khoá ngoại trong class `User.java` (Nên nó sẽ trùng tên với tên thuộc tính khoá ngoại trong class `User.java`).
	> > - Thuộc tính *fect = <Tham Số>* sẽ có 2 tham số đó là `FetchType.LAZY` và `FetchType.EAGER`. Sự khác nhau là LAZY là khi query thì chỉ load dữ liệu của row trong bảng lên thôi, khi nào dùng mới lấy List khoá ngoại lên, còn EAGER sẽ lấy lên toàn bộ giá trị khoá ngoại của 1 row (Kéo theo việc tốc độ sẽ chậm đi).

- Quan hệ n-n (Many to Many) thì ta tách nó về 2 quan hệ trên (Ví dụ như nhiều user sẽ có thể comment nhiều bài viết và nhiều bài viết được comment bởi nhiều user - Ta thêm một bảng comment có quan hệ với user là 1 - n và quan hệ với bảng bài viết là n - 1 ).