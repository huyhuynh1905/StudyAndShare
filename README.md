# StudyAndShare

### Danh sách các bài:
1. [Hướng dẫn Git và Github](https://github.com/huyhuynh1905/StudyAndShare/tree/master/StudyGitAndGithub)
2. [Cài đặt và kết nối MySQL với IntelliJ](https://github.com/huyhuynh1905/StudyAndShare/tree/master/MySQL&IntelliJConection.md)
3. [Spring MVC Theo FPT](https://github.com/huyhuynh1905/StudyAndShare/tree/master/FPTSpringMVC )
4. [Dart Language](https://github.com/huyhuynh1905/StudyAndShare/tree/master/DartLanguage)
5. [Java Servlet](https://github.com/huyhuynh1905/StudyAndShare/tree/master/JavaServlet)
6. [Android nâng cao](https://github.com/huyhuynh1905/StudyAndShare/tree/master/AndroidAdvanced)
7. [Thiết Kế Trong Android](https://github.com/huyhuynh1905/StudyAndShare/tree/master/ThietKeTrongAndroid)


-----------
### Một vài kĩ thuật trong android:
1. Code ẩn bàn phím android khi được gọi tới:
```java
	public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
```

2. Code kiểm tra validation cơ bản:
```java
public boolean isValidEmail(){  
    return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();  
}
```

3. Làm full màn hình android:
<div align="center"><img src="https://i.imgur.com/glWKfiH.png"/></div>

```java
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
  WindowManager.LayoutParams.FLAG_FULLSCREEN);
```
