<h1 align="center">Một Số Drawable Trong Android</h1>

### Nội dung
1. [***Thẻ Shape (Hình Dạng).***](#muc1) 
2. [***Thẻ Selector***](#muc2)
3. [***Animation***](#muc3)
3.1. [*Animation Alpha*](#muc31)
3.2. [*Animation Rotate*](#muc32)
3.3. [*Animation Scale*](#muc33)
3.4. [*Animation Translate*](#muc34)
3.5. [*Sử dụng animation trong chuyển intent hoặc trong listview*](#muc35)
4. [***Thẻ Ripple cho button.***](#muc4)
<a name="muc1"></a>
## 1. Thẻ Shape (Hình Dạng).
Cấu trúc của thẻ `<shape>` được ví dụ như sau:
<div align="center"><img  src="https://i.imgur.com/nVgEAUo.png"/></div>

- Trong đó chứa các thuộc tính: 
-- Thuộc tính `android:shape="rectangle"` trong thẻ shape còn có thể có các thuộc tính khác ngoài *rectangle (hình chữ nhật)* như *ring (vòng)*, *oval (elips)*, *line (đường kẻ)*.
- Ngoài ra còn chứa 6 phần tử trong thẻ `<shape>`:
-- Thẻ `<solid>`: chứa thuộc tính `android:color="<mã màu>"` có chức năng định dạng màu cho shape này.
-- Thẻ `<size>`: chứa các thuộc tính về width và height dùng để đặt kích thước cho shape.
-- Thẻ `<corners>`: chứa các thuộc tính để bo góc cho shape, có thể bo cả 4 góc bằng `android:radius="<size>dp"` hoặc bo từng góc riêng lẻ với `android:bottomLeftRadius="<size>"`, `android:bottomRightRadius="<size>"`, `android:topLeftRadius="<size>"`, `android:topRightRadius="<size>"`.
-- Thẻ `<padding>`: chứa các thuộc tính để căn khoảng cách đến các viền của một nội dung được chứa trong shape.
-- Thẻ `<stroke>`: dùng để tạo viền cho shape. Chứa các thuộc tính như `android:width="<size>dp"` là độ dày của viền và `android:color="<mã màu>"` là màu của viền.
-- Thẻ `<gradient>`: dùng để tô 2 màu lên shape. Dùng `android:angle="<góc radian>"` để quy định góc chia của 2 màu, dùng `android:startColor="<mã màu>"` và `  
android:endColor="<mã màu>"` để quy định màu.

- Đoạn code xml trên:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<shape xmlns:android="http://schemas.android.com/apk/res/android"  
  android:shape="rectangle">  
  
 <solid android:color="#E17A7A"/>  
 <size android:width="200dp"  
  android:height="100dp"/>  
 <corners android:radius="20dp" />  
 <padding android:top="20dp"  
  android:bottom="20dp"  
  android:left="20dp"  
  android:right="20dp"/>  
 <stroke android:width="2dp"  
  android:color="#3F51B5"/>  
  
 <gradient android:angle="135"  
  android:startColor="#E3B375"  
  android:endColor="#ACD24D"/>  
</shape>
```
> Sử dụng trong các thành phần như button, edittext,.. bằng thuộc tính thêm vào: 
> `android:background="@drawable/<tên file shape>"`

<a name="muc2"></a>
## 2. Thẻ Selector.
Một thẻ `<selector>` chứa các item để custom các thuộc tính, có dạng như sau:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<selector xmlns:android="http://schemas.android.com/apk/res/android">  
 <item android:drawable="@drawable/custom_buttom"  
  android:state_pressed="false"/>  
 <item android:drawable="@color/colorPrimary"  
  android:state_pressed="true"/>  
</selector>
```

- Trong đó trong mỗi item là các thuộc tính như:
-- Thuộc tính `android:drawable="<link custom>"` để chứa hình dạng, màu sắc, đặc điểm của trạng thái item này.
-- Thuộc tính `android:state_pressed="true"` chính là chứa cái trạng thái khi lựa chọn đến nó (ở đây có nghĩa là khi nhấn vào thì nó sẽ hiển thị trạng thái của item này).
- Selector này chủ yếu dùng cho custom lại các button, checkbox, radiobutton hơn. đối với mỗi loại thì thay vì *state_pressed* như trên thì còn có nhiều loại khác.
- Sử dụng các selector này cũng như cách sử dụng shape ở trên.


<a name="muc3"></a>
## 3. Animation.
Đầu tiên ta tạo một **Resource Directory** có tên là `anim` trong *res* để chứa các animation:
<div align="center"><img  src="https://i.imgur.com/NOfT3m6.png"/></div>

Việc sử dụng các animation đối với các image(trong ví dụ về animation) như sau:
<div align="center"><img  src="https://i.imgur.com/Ii4rQHo.png"/></div>

<a name="muc31"></a>
### 3.1. Animation Alpha:
Là kiểu thay đổi từ đậm sang nhạt dần hoặc ngược lại. Có các thông tin và thuộc tính sau:

```xml
<?xml version="1.0" encoding="utf-8"?>  
<set xmlns:android="http://schemas.android.com/apk/res/android"  
  android:fillAfter="true" > 
  <!-- fillAfter là chọn trạng thái sau làm chuẩn cuối và không thay đổi-->
  
 <alpha android:fromAlpha="1.0"  
  android:toAlpha="0.1"  
  android:repeatCount="2"  
  android:repeatMode="reverse"  
  android:duration="1000"/>  
  
</set>
```

<a name="muc32"></a>
### 3.2. Animation Rotate:
Là kiểu animation xoay quanh một tâm tuỳ theo số độ radian truyền vào từ bao nhiêu:

```xml
<?xml version="1.0" encoding="utf-8"?>  
<set xmlns:android="http://schemas.android.com/apk/res/android">  
  
 <rotate android:fromDegrees="0"  
  android:toDegrees="90"
  android:repeatCount="2"  
  android:repeatMode="reverse"  
  android:duration="1000"  
  android:pivotX="50%"  
  android:pivotY="50%"/>  
<!-- Trong đó thì pivotX và pivotY dùng để xác định tâm xoay-->
</set>
```

<a name="muc33"></a>
### 3.3. Animation Scale:
Là kiểu animation dùng để phóng to hoặc thu nhỏ, phải scale theo cả 2 hướng X và Y. Nó có thể dùng các thuộc tính repeat, duration, pivot như animation rotate. 
```xml
<?xml version="1.0" encoding="utf-8"?>  
<set xmlns:android="http://schemas.android.com/apk/res/android">  
  
 <scale android:fromXScale="1"  
  android:toXScale="2"  
  android:fromYScale="1"  
  android:toYScale="2"  
  android:pivotY="50%"  
  android:pivotX="50%"/>  
  </set>
```

<a name="muc34"></a>
### 3.4. Animation Translate:
Dùng để di chuyển các view ở trên màn hình của mình:

```xml
<?xml version="1.0" encoding="utf-8"?>  
<set xmlns:android="http://schemas.android.com/apk/res/android">  
  
 <translate android:fromXDelta="1"  
  android:toXDelta="10"  
  android:fromYDelta="1"  
  android:toYDelta="10"/>  
</set>
```
> Nó có thể dùng các thuộc tính repeat, duration như các animation trước bình thường.

<a name="muc35"></a>
### 3.5. Sử dụng animation trong chuyển intent hoặc trong listview:
- Sử dụng để chuyển qua lại giữa các intent:
```java
btnNext.setOnClickListener(new View.OnClickListener() {  
    @Override  
  public void onClick(View v) {  
        startActivity(new Intent(MainActivity.this,SubActivity.class));  
		overridePendingTransition(R.anim.anim_alpha,R.anim.anim_rotate); 
		//alpha đại viện cho anim xuất hiện và rotate đại diện cho anim exit của intent
  }  
});
```
- Trong listview gán animation bằng cách thêm animation cuối và gán cho view như:

<div align="center"><img  src="https://i.imgur.com/5csLmX9.png"/></div>


<a name="muc4"></a>
## 4. Thẻ Ripple cho button.
Thẻ ripple tương tự như thẻ selector nhưng mà cấu hình tổng hợp dễ dàng hơn. (Thẻ ripple chỉ dùng được từ APIv21 ~ android 5).
- Đoạn xml cấu hình thẻ ripple:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<ripple xmlns:android="http://schemas.android.com/apk/res/android"  
  android:color="#CCC26F">  
  
 <item> 
	 <shape> 
		 <solid android:color="#FFC107"/>  
		 <size android:width="190dp"  
		  android:height="50dp"/>  
		 <corners android:radius="10dp"/>  
	 </shape> 
 </item>
 </ripple>
```