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
