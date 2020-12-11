<h1 align="center">Intent, AsynTask Và Volley Trong Android</h1>

### Nội dung
1. [***Intent Trong Android***](#muc1) 
2. [***AsynTask Trong Android***](#muc2)
3. [***Volley Trong Android***](#muc3)


<a name="muc1"></a>
## 1. Intent Trong Android.
Phần này về Intent sẽ nói đến việc sử dụng Intent khi chuyển giữa các Activity, send data qua lại hoặc nhận kết quả trả về từ một Activity. (Để hiểu rõ hơn thì tìm hiểu về vòng đời của Activity trước).
<div align="center"><img  src="https://i.imgur.com/3gZKKA4.png"/></div>
<div align="center">Hai loại Intent trong Android</div>

- Việc sử dụng Intent để chuyển đổi màn hình của các Activity rất đơn giản:
```java
Intent intent = new Intent(<Activity1>.this,<Activity2>.class);  
startActivity(intent); //Nếu không cần kết quả trả về từ Activity 2
```

- Truyển và nhận dữ liệu của các Intent:
```java
//Code truyền dữ liệu từ Activity 1
	Intent intent = new Intent(<Activity1>.this,<Activity2>.class);  
	intent.putExtra(<key>,<value>);  
	//Truyền object thì class đó phải implements Srrializable  
	//Ngoài ra có thể dùng Bundle để đóng gói:  
	Bundle bundle = new Bundle();  
	bundle.putSerializable(<key>,<value>);//truyền đối tượng.  
	bundle.putString(<key>,<value>);//truyền kiểu dữ liệu cơ bản.  
	bundle.putIntArray(<key>,<value>);//truyền mảng.  
	intent.putExtra(<key>,bundle);  
	startActivity(intent);

//Code nhận dữ liệu bên Activity 2:
	Intent intent = getIntent();  
	String str = intent.getStringExtra(<key>);  
	Object object = intent.getSerializableExtra(<key>);  
	//Nếu dùng bundle:  
	Bundle bundle = intent.getBundleExtra(<key>);  
	String strbundle = bundle.getString(<key>);  
	Object obj = bundle.getSerializable(<key>);
```
- Nếu muốn nhận request trả về từ Activity:
-- Trước tiên ta nên khai báo một hằng số globle `final int CODE_REQUEST_FOR_<NAME> = <Số>;`  để kiểm tra có khớp với yêu cầu trả về nào.
```java
//Chuyển intent muốn nhận result trả về:
	Intent intent = new Intent(MainActivity.this,InfoActivity.class);  
	startActivityForResult(intent,CODE_REQUEST_FOR_<NAME>);

//Bên Activity 2 trước khi kết thúc trả về Activity 1 phải:
	Intent intent = new Intent();  
	intent.putExtra(<Key>,<Value>);  
	setResult(RESULT_OK,intent);
```
```java
//Viết lại phương thức để nhận giá trị được trả về Activity:
@Override  
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  
    if (requestCode==CODE_REQUEST_FOR_<NAME> && resultCode==RESULT_OK){  
	    //lấy ra các dữ liệu mình cẩn
        String data= data.get<Kiểu Data>Extra("<key>");
  } else {  
        Toast.makeText(MainActivity.this,"Lỗi!",Toast.LENGTH_LONG).show();  
  }  
}
```


<a name="muc2"></a>
## 2. AsynTask Trong Android.
Ta có thể tạo một class con trong class chính thực hiện các thao tác trên class.
- Ba đối số truyền vào trong AsynTask<1,2,3> lần lượt là: 1 - Kiểu truyền vào hàm excute(), 2 - Kiểu chạy xử lí, 3 - Kiểu trả về trong hàm *doInBackground*. Dưới ví dụ này là truyền vào chuỗi và nhận lại chuỗi.
```java
private class ReadJSON extends AsyncTask<String, Void, String>{  
  
    @Override  
    protected String doInBackground(String... strings) {  
    	//Code chạy lấy về từ string  
	String urlStr = strings[0]; //Đường dẫn truyền vào  
	StringBuilder strReturn = new StringBuilder();  
	try {  
		URL url = new URL(urlStr);  
		InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());  
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
		//Đọc dòng dữ liệu nhận được  
		String line = "";  
		while ((line=bufferedReader.readLine())!=null){  
               		strReturn.append(line);  
		}  
            	bufferedReader.close();  
		inputStreamReader.close();  
	} catch (MalformedURLException e) {  
            	e.printStackTrace();  
	} catch (IOException e) {  
            	e.printStackTrace();  
	}  
  
        return strReturn.toString();  
}  
  
	@Override  
	protected void onPostExecute(String s) {  
	    	//Code xử lí sau khi nhận được json  
		super.onPostExecute(s);  
	}  
}
```

>Sử dụng gọi đến class này: `new ReadJSON().execute("<url>");`

- Hướng dẫn làm việc với JSON:
```java
//Xử lí các đối tượng JSON:
	JSONObject jsonObject = new JSONObject(s);  
	String str = jsonObject.getString("<key>");
//Đối với mảng JSON và cách duyệt như mảng bình thường
	JSONArray jsonArray = new JSONArray(s);  
	for (int i = 0; i<jsonArray.length();i++){  
	    	JSONObject object = jsonArray.getJSONObject(i);  
		String data = object.getString("<key>");  
	}
```

<a name="muc3"></a>
## 3. Volley Trong Android.
> Khác với AsynTask có thể làm trên local ứng dụng và dùng trong local thì Volley là một thư viện HTTP giúp kết nối mạng cho các ứng dụng Android dễ dàng hơn và quan trọng nhất là nhanh hơn.

Thêm [thư viện volley](https://developer.android.com/training/volley): 
```
dependencies {  
	 implementation 'com.android.volley:volley:1.1.1'  
}
```

- Code xử lí các request volley. đầu tiên khai báo Volley, sau đó khai báo nhận về request có các tham số truyền vào như sau:
```java
RequestQueue requestQueue = Volley.newRequestQueue(this);  
JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "url", null,  
		 new Response.Listener<JSONObject>() {  
           		@Override  
			public void onResponse(JSONObject response) {  
                		//Xử lí trả về  
			}  
        	}, new Response.ErrorListener() {  
            		@Override  
			public void onErrorResponse(VolleyError error) {  
                		//Xử lí thông báo ra lỗi  
			}  
        	});  
//chạy  
requestQueue.add(jsonObjectRequest);
```

> Có thể thay thế `JsonObjectRequest` trên bằng `StringRequest` (Sẽ ko có tham số null) hoặc `JsonArrayObjectRequest` tuỳ thuộc vào loại dữ liệu mình nhận về mong muốn.
