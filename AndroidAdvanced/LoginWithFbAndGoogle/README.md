<h1 align="center">Đăng Nhập Ứng Dụng Bằng Facebook Và Google</h1>

### Nội dung
1. [***Đăng nhập ứng dụng với Facebook.***](#muc1) 
2. [***Đăng nhập ứng dụng với Google.***](#muc2)

> Chú ý là cả facebook và google nếu dùng trong activity thì phải được khởi tạo và khai báo trước setContentView. Trong Fragment thì khai báo trước khi trả về view là được.

<a name="muc1"></a>
## 1. Đăng nhập ứng dụng với Facebook.
Đầu tiền vào [Facebook Developer](https://developers.facebook.com/apps/) để tạo ra một ứng dụng.
<div align="center"><img  src="https://i.imgur.com/tfEZbxd.png"/></div>

Các bước tạo ra ứng dụng như hướng dẫn của Facebook [tại đây](https://developers.facebook.com/docs/facebook-login/android).
Sau đó ta vào quản lí ứng dụng vừa tạo, vào **Cài đặt** > **Thông tin cơ bản** để tiếp tục thêm một nền tảng và điền các thông tin lại:
<div align="center"><img  src="https://i.imgur.com/yyGmenx.png"/></div>

> Chú ý để có được Hash chính trên kia ta có thể tạo một phương thức lấy Hash chính trong chính ứng dụng bằng code:
```java
//Phương thức này chỉ chạy mục đích lấy key cho project trên facebook  
private void useTheRightKeyHashFacebook(){  
    // Add code to print out the key hash  
 //PackageName: package of my project: com.huyhuynh.applazada  try {  
        PackageInfo info = getActivity().getPackageManager().getPackageInfo(  
                "com.huyhuynh.applazada",  
  PackageManager.GET_SIGNATURES);  
 for (Signature signature : info.signatures) {  
            MessageDigest md = MessageDigest.getInstance("SHA");  
  md.update(signature.toByteArray());  
  Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));  
  }  
    } catch (PackageManager.NameNotFoundException e) {  
  
    } catch (NoSuchAlgorithmException e) {  
  
    }  
}
```
>Lúc chạy ta sẽ dùng `Logcat` để có thể lấy được Key trả ra bằng Log.d!

Để có thể test trên ứng dụng khi đang trong chế độ **Đang phát triển** ta phải thêm người dùng thử nghiệm vào ở trong **Vai trò** > **Vai trò**:
<div align="center"><img  src="https://i.imgur.com/6DWMGph.png"/></div>

Các bưới cài đặt trên Android:
1.  Trong dự án của bạn, hãy mở  file **build.gradle (Project)**, và thêm dòng này vào  `buildscript { repositories {}}`:
    ```
    jcenter()
    ```
    
2.  Trong dự án của bạn, hãy mở file  **build.gradle (Project: tên ưng·)**  và thêm thư viện (Lúc này mới nhất đang là bản 8.1.0):
	```
	implementation 'com.facebook.android:facebook-login:8.1.0'
	```
3. Trong file **/app/res/values/strings.xml** thêm:
	```xml
	<string  name="facebook_app_id">|Điền id của ứng dụng|</string>
	<string  name="fb_login_protocol_scheme">fb|Điền id của ứng dụng như trên|</string>
	```
4. Mở file **/app/manifest/AndroidManifest.xml** thêm đoạn này trong thành phần **application**:
	```
	<meta-data android:name="com.facebook.sdk.ApplicationId" android:value="@string/facebook_app_id"/> 
	<activity android:name="com.facebook.FacebookActivity" android:configChanges= "keyboard|keyboardHidden|screenLayout|screenSize|orientation" android:label="@string/app_name" /> 
	<activity android:name="com.facebook.CustomTabActivity" android:exported="true"> 
		<intent-filter> 
			<action android:name="android.intent.action.VIEW" /> 
			<category android:name="android.intent.category.DEFAULT" /> 
			<category android:name="android.intent.category.BROWSABLE" /> 
			<data android:scheme="@string/fb_login_protocol_scheme" /> 
		</intent-filter> 
	</activity>
	```
Đến đây xem như hoàn tất các công việc cài đặt và cấu hình. Đến đoạn code, giả sử ta có một Activity đăng nhập có một button đăng nhập bằng facebook.

-  Đầu tiên ta phải khai báo trước các phản hồi đăng nhập, mình sẽ cho vào một phương thức sau đó gọi phương thức này trước bắt sự kiện nhần của button (chú ý vị trí đặt phương thức này ở đầu):
	```java
	private void xuLiDangNhapBangFaceBook() {  
	    callbackManager = CallbackManager.Factory.create();  
		LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {  
	        @Override  
			public void onSuccess(LoginResult loginResult) {  
	            Log.d("LoginFacebook:", "Thành Công");
	            //xử lí nếu đăng nhập thành công  
			}  
	  
	        @Override  
			public void onCancel() {  
			    Log.d("LoginFacebook:", "Thoát"); 
			    //không đăng nhập mà bấm thoát 
			}  
	  
	        @Override  
			public void onError(FacebookException error) {  
				Log.d("LoginFacebook:", "Lỗi\n"+error.toString());
				//Xử lí nếu xảy ra lỗi đăng nhập  
			}  
	    });  
	}
	```
- Để `callbackManager` ở trên có thể nhận được các kết quả trả về khi đăng nhập thì ta phải viết lại phương thức `onActivityResult` và thêm dòng code `callbackManager.onActivityResult()` vào:
	```java
	@Override  
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  
	    callbackManager.onActivityResult(requestCode,resultCode,data);  
		super.onActivityResult(requestCode, resultCode, data);
	}  
	```
- Cuối cùng là code trong bắt sự kiện nhần đăng nhập bằng button:
	```java
	btnLoginWFacebook.setOnClickListener(new View.OnClickListener() {  
	    @Override  
		public void onClick(View v) {  
		     LoginManager.getInstance().logInWithReadPermissions(FragmetnDangNhap.this,  
					  Arrays.asList("email", "public_profile", "user_friends","basic_info")); 
		}  
	});
	```
>Chú ý là trong mảng Arrays ở trên phải truyền truyền vào ít nhất 3/4 các quyền sẽ xin (như trên trên) để tránh gặp lỗi.

- Đăng xuất: ta gọi lệnh đăng xuất bằng `LoginManager.getInstance().logOut();` . Chú ý là khi đăng nhập thì Facebook sẽ cho ta một AccessToken chứa thông tin đã xin như trên, trước khi đăng xuất nên check xem token này có null hay không.
- Code để lấy ra token:
	```java
	AccessToken accessToken;  
	AccessTokenTracker accessTokenTracker;  
	public AccessToken layTokenFacebook(){  
	    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {  
	        @Override  
			protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {  
			     accessToken = currentAccessToken;  
			}  
		};  
		accessToken = AccessToken.getCurrentAccessToken();  
	  
		return accessToken;  
	}
	```
>Các biến `accessToken` và `accessTokenTracker` là các biến toàn cục trong một class xử lí logic.

- Cách để đọc thông tin trong một token:
	```java
	if (accessToken!=null) {  
	    GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {  
	        @Override  
			public void onCompleted(JSONObject object, GraphResponse response) {  
				try {  
				    String userFacebook = object.getString("name");  
				} catch (JSONException e) {  
			        e.printStackTrace();  
				}  
			    Log.d("Token", "Tên người dùng: " + userFacebook);  
			  }  
		});  
	  
		Bundle bundle = new Bundle();  
		bundle.putString("feilds", "name");  
		graphRequest.setParameters(bundle);  
		graphRequest.executeAsync();  
	}
	```

<a name="muc2"></a>
## 2. Đăng nhập ứng dụng với Google.
Việc đăng nhập với google sẽ đơn giản và ít xảy ra lỗi hơn google. Hướng dẫn [tại đây](https://developers.google.com/identity/sign-in/android/start-integrating) (bên trái chính là từng phần của hướng dẫn).

Đầu tiên ta sẽ tiến hành tạo một project thực hiện việc đăng nhập login google:
<div align="center"><img  src="https://i.imgur.com/DE6Uldx.png"/></div>
Tiếp đó ta tiếp tục đặt tên cho việc cấu hình xác thực: 
<div align="center"><img  src="https://i.imgur.com/tebkh5m.png"/></div>
Bước tiếp theo ta sẽ tiến hành cấu hình cho project này nhận ra với project app android của ta:
<div align="center"><img  src="https://i.imgur.com/m2fB7Sb.png"/></div>

>Chú thích cách lấy mã SHA-1: 
><div align="center"><img  src="https://i.imgur.com/ImuFNlZ.png"/></div>

Sau đó ta sẽ download `CLIENT CONFIGURATION` là một file json về
<div align="center"><img  src="https://i.imgur.com/LA7iYqC.png"/></div>

>File cấu hình json down về đó coppy thêm vào **app** như sau (Đổi sang chế độ project):
> <div align="center"><img  src="https://i.imgur.com/UiMc76t.png"/></div>

Cuối cùng là thêm thư viện vào cho ứng dụng và tiến hành `Sync`:
```
implementation 'com.google.android.gms:play-services-auth:19.0.0'
```

Tiếp theo là phần code xử lí đăng nhập bằng google. Ta cũng ví dụ có một button đăng nhập bằng Google trong một Activity ([xem hướng dẫn](https://developers.google.com/identity/sign-in/android/sign-in)).
- Cũng giống như facebook ta cũng sẽ tạo một phương thức khởi tạo và khai báo sử dụng (Sẽ có một biến toàn cục nhận giá trị `GoogleSignInClient` được trả về của phương thức):
	```java
	public GoogleSignInClient khaiBaoDangNhapGoogle(Context context) {  
	    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)  
	            .requestEmail()  
	            .build();  
		return GoogleSignIn.getClient(context,gso);  
	}
	```
- Ta cũng phải viết lại phương thức `onActivityResult()`:
	```java
	@Override  
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {   
		super.onActivityResult(requestCode, resultCode, data);  
		 if (requestCode == RC_SIGN_IN) {    
			Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);  
			handleSignInResult(task);  
		 }  
	}
	```
	> Giải thích: RC_SIGN_IN là một hằng số nguyên được khai báo toàn cục nhằm mục đích kiểm tra giá trị trả về.
	Phương thức `handleSignInResult(task);` được gọi chính là phương thức sẽ xử lí nếu có gái trị trả về
- Phương thức `handleSignInResult(task)` được gọi ở trên có nội dung:
	```java
	private void handleSignInResult(Task<GoogleSignInAccount> task) {  
	    try {  
	        GoogleSignInAccount account = task.getResult(ApiException.class);
	        //Code xử lí nếu đăng nhập thành công
			Log.d("GoogleHandle", "handleSignInResult: Thành công!" +account);  
		} catch (ApiException e) {  
			//Xử lí nếu có lỗi  
		}  
	}
	```
- Sau khi có các phương thức đầy đủ thì ta tiến hành bắt sự kiện khi nhấn button đăng nhập bằng google:
	```java
	btnLoginWGoogle.setOnClickListener(new View.OnClickListener() {  
	    @Override  
		public void onClick(View v) {  
	        Intent signInIntent = googleSignInClient.getSignInIntent();  
			startActivityForResult(signInIntent, RC_SIGN_IN); //Chính là requestCode đã nói ở trên
		}  
	});
	```
- Khác với facebook thông tin trả về sẽ chứa trong `AccessToken` thì thông tin đăng nhập của google sẽ chứa trong ``, đoạn code sau giúp đọc thông tin được trả về:
```java
GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(context);  
if (acct != null) {  
    String personName = acct.getDisplayName();  
	String personGivenName = acct.getGivenName();  
	String personFamilyName = acct.getFamilyName();  
	String personEmail = acct.getEmail();  
	String personId = acct.getId(); 
}
```
> Có thể tạo một phương thức trả về `GoogleSignInAccount` để tiện lợi lấy ra các thông tin mà mình muốn sử dụng ở nhiều vị trí trong class.

- Cuối cùng là đăng xuất:
```java
if (googleSignInAccount!=null){  
    googleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {  
        @Override  
		public void onComplete(@NonNull Task<Void> task) {  
            Log.d("googleSignOut","Logout thanh cong!");
            //Code xử lí sau đăng xuất
		}  
    });  
}
```