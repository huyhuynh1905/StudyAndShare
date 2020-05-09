<h1 align="center">Controller Trong Spring MVC</h1>

### Nội dung
1. [***Về @RequestMaping trong Spring MVC.***](#muc1) 
2. [***Các phương pháp nhận tham số.***](#muc2) 
3. [***Các kết quả của return.***](#muc3)
4. [***Bài tập.***](#muc4)

<a name="muc1"></a>
## 1. Về @RequestMaping trong Spring MVC.
- Annotation `@RequestMaping` được sử dụng để ánh xạ một *action* đến một phương thức *action* trong `Controller`.
	```java
	@RequestMapping("/login") 
	```
- Trên kia là cách viết thu gọn, ta có thể viết đầy đủ như:
	```java
	@RequestMapping(value = "/login")
	```
- Ta có thể dùng `@RequestMaping` cho *class* như sau:


![](https://i.imgur.com/HD0gZkA.png)


> Nó tương tự như:
	![](https://i.imgur.com/ta3spdx.png)

- Trong Spring MVC phân biệt **POST|GET** thông qua tham số `method` như sau:
	```java
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	```
	> Chú ý: `@RequestMaping phải có dạng đầy đủ.`

<a name="muc2"></a>
## 2. Các phương pháp nhận tham số.

- Trong Spring MVC có hỗ trợ phân biệt phương thức *action* theo tham số truyền theo:
	```java
	@RequestMapping(value = "/hello",params = "mvc")
	public String sayHello(){
		return "Hello";
	}
	```
	> Tương đương với đường dẫn action: /hello.jsp?mvc
	> Với cách định nghĩa này thì khi muốn goi tới phương thức này phải có tham số truyền theo. (ở ví dụ là "mvc").

- Tham số là dữ liệu truyền đến **server** khi có yêu cầu từ người dùng, Spring MVC cung cấp các phương pháp nhận tham số sau:
	+ Sử dụng HttpServletRequest tương tự Servlet.
	+ Sử dụng annotation @RequestParam.
	+ Sử dụng JavaBean
	+ Sử dụng @PathVariable để nhận một phần trên URL.
- Sử dụng **HttpServletRequest**:

![](https://i.imgur.com/LwwrB6F.png)

- Sử dụng annotation **@RequestParam**:

![](https://i.imgur.com/pdyYyoE.png)
> `@RequestParam(value,defaultValue,required)` là dạng đầy đủ của `Các kết quả của return` với:
> > value: tên tham số muốn nhận.
> > defaultValue: giá trị mặc định nếu tham số không có.
> > required: tham số có bắt buộc hay không.

> Xem thêm: Nếu thay `Các kết quả của return` ở trên thành `@CookieValue` thì ta có thể **nhận dữ liệu từ Cookie**.
- Sử dụng lớp **JavaBean**:
	+ Phải được định nghĩa là public.
	+ Phải có constructor không tham số.
	+ Đọc ghi dữ liệu thông qua getter/setter.
	
	![](https://i.imgur.com/FB2hp2s.png)

	+ Truyền vào chỉ cần các tham số cùng tên với các thuộc tính:
	
	![](https://i.imgur.com/N9Ix3NM.png)

- Sử dụng **@PathVariable** để nhận một phần trên URL:
![](https://i.imgur.com/H2PVHdS.png)


<a name="muc3"></a>
## 3. Các kết quả của return.
- Return của phương thức action không đơn thuần chỉ là tên của view mà có thể là 1 trong 3 trường hợp sau:
	+ Tên view: `return "<ten-view>"`.
	+ 
	![](https://i.imgur.com/HD0gZkA.png)
	


	+ Trả về trực tiếp nội dung trong `return` bằng cách dùng annotation **@ResponseBody** : `return "<nội dung>"`.
		+ Giả sử ta có đoạn code sau sử dụng **@ResponseBody**:![](https://i.imgur.com/vWMKtlj.png)
		
		+ Khi dùng **Postman** test thì ta nhận về giá trị là dạng JSON:
		![](https://i.imgur.com/4IPa7im.png)
		>Chú ý là phải thêm thư viện jackson vào file **pom.xml** để giá trị có thể trả về dạng JSON : [Link](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.10.0).
	
	+ Lời gọi đến một phương thức action khác: `return "redirect:/<action>"`.
	![](https://i.imgur.com/v1VEsnC.png)
	> Ảnh trên tương đương với việc nó dẫn đến phương thức:
	>>![](https://i.imgur.com/3dasBfm.png)
	

<a name="muc4"></a>
## 4. Bài tập.

- Bài tập là xây dựng các chức năng web như sau:
![](https://media.giphy.com/media/KDQCAwJzmQtuVXnkt0/giphy.gif)
- Tạo một project có cấu trúc như dưới (Xem lại cách tạo một project String MVC [tại đây](https://github.com/huyhuynh1905/StudyAndShare/tree/master/FPTSpringMVC/StartWithSpringMVC) ):
![](https://i.imgur.com/wM8vURN.png)

- Các thư viện sử dụng trong project: [Link](https://github.com/huyhuynh1905/StudyAndShare/blob/master/FPTSpringMVC/ControllerInSpring/fprspringmvclab2/pom.xml).
-  Code của file `HomController`: [Link](https://github.com/huyhuynh1905/StudyAndShare/blob/master/FPTSpringMVC/ControllerInSpring/fprspringmvclab2/src/main/java/com/huyhuynh/controller/HomeController.java).