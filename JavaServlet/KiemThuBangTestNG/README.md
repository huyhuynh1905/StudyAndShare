<h1 align="center">Kiểm Thử Bằng TestNG Và Debug Trên IntelliJ</h1>

- Thêm thư viện *TestNG* vào trong file `pom.xml` của class cha:
	```xml
	<dependency>
	    <groupId>org.testng</groupId>
	    <artifactId>testng</artifactId>
	    <version>6.14.3</version>
	    <scope>test</scope>
	</dependency>
	```
- Ta có một phương thức lấy ra danh sách của một Entity, ta cần test xem phương thức có chạy được không:
<div align="center"><img  src="https://i.imgur.com/bWDh3kK.png"/></div>

- Ta tạo thêm một module chuyên dùng chỉ để test:
<div align="center"><img  src="https://i.imgur.com/5Ryxkwn.png"/></div>

- Trong resource của module test thì ta tạo một file `testng.xml` có nội dung cơ bản bản đầu:
	```xml
	<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >  
	  
	<suite name="TestAll" verbose="1" >  
		 <test name="case1" >  
			 <classes>  
				 <!--<class name="NoPackageTest" />-->  
			 </classes>  
		 </test>
	</suite>
	```
- Trong thẻ `<classes>` ở trên chính là đường dẫn đến Class Test mà ta muốn test, ngoài ra ta cũng phải coppy file `hibernate.cfg.xml` từ module **toeic-web** sang resource của module test. Như hình sau:
<div align="center"><img  src="https://i.imgur.com/tVGLD8W.png"/></div>

- Nội dung của Class RoleEntityTest như sau, sử dụng annotation `@Test` thêm vào phương thức Test:
<div align="center"><img  src="https://i.imgur.com/5Tx1zSs.png"/></div>

- Ta đặt check point tại các vị trí kiểm tra giá trị trả về sau đó run Debug để tiến hành Debug phương thức này.