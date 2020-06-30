<h1 align="center">Gửi Email Trong Spring MVC</h1>

### Nội dung
1. [***Khai báo thư viện và Bean.***](#muc1) 
2. [***Form gửi mail và controller.***](#muc2) 



<a name="muc1"></a>
## 1. Khai báo thư viện và Bean.

- Ngoài những thư viện yêu cầu của `spring mvc` thì trong file `pom.xml` thêm thư viện sau để gửi mail:
```xml
<!--Thư viện gửi mail-->  
<dependency>  
 <groupId>javax.activation</groupId>  
 <artifactId>activation</artifactId>  
 <version>1.1.1</version>  
</dependency>  
<dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-mail</artifactId>  
 <version>2.2.2.RELEASE</version>  
</dependency>
```
- Khai baos bean cấu hình `MailSender` trong `IoC`:
```xml
<!--Bean để gửi mail-->  
<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">  
 <property name="host" value="smtp.gmail.com"/>  
 <property name="port" value="465"/>  
 <property name="username" value="toxic.best.98@gmail.com"/>  
 <property name="password" value="***********"/>  
 <property name="defaultEncoding" value="utf-8"/>  
 <property name="javaMailProperties">
   <props> <prop key="mail.smtp.auth">true</prop>  
	 <prop key="mail.smtp.socketFactory.class">javax.net.ssl.SSLSocketFactory</prop>  
	 <prop key="mail.smtp.socketFactory.port">465</prop>  
	 <prop key="mail.smtp.starttls.enable">false</prop>  
	 <prop key="mail.debug">true</prop>
   </props>
  </property>
 </bean>
```


<a name="muc2"></a>
## 2. Form gửi mail và controller.
- Xây dựng form gửi mail có tên `formmail.jsp` trong */WEB-INF/views*:
<div align="center"><img  src="https://i.imgur.com/7mSazFl.png"/></div>

<div align="center"><img  src="https://i.imgur.com/WBQKtwc.png"/></div>

- `Controller` gửi mail:
```java
@Controller  
@RequestMapping("/mail")  
public class MailController {  
	  @Autowired  
	  JavaMailSender mailer;  
  
  
	  @RequestMapping("/send")  
	  public String sendMail(ModelMap modelMap, @RequestParam("from") String from, @RequestParam("to") String to,  
  @RequestParam("subject") String subject, @RequestParam("body") String body){  
  
        try {  
            //tạo mail  
		  MimeMessage mail = mailer.createMimeMessage();  
		  MimeMessageHelper helper = new MimeMessageHelper(mail);  
		  helper.setFrom(from,from);  
		  helper.setTo(to);  
		  helper.setReplyTo(from,from);  
		  helper.setSubject(subject);  
		  helper.setText(body,true);  
		  //gửi mail  
		  mailer.send(mail);  
		  modelMap.addAttribute("message","Gửi mail thành công!");  
	  } catch (MessagingException e) {  
            e.printStackTrace();  
		  modelMap.addAttribute("message","Gửi mail không thành công!");  
	  } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
		  modelMap.addAttribute("message","Gửi mail không thành công!");  
	  }  
        return "/formmail";  
  }
}
```
- Thông báo khi gửi mail thành công:
<div align="center"><img  src="https://i.imgur.com/XIRw2wt.png"/></div>

- Kiểm tra hòm thư đã nhận được mail:
<div align="center"><img  src="https://i.imgur.com/6JrPenm.png"/></div>