<h1 align="center">Image Slide Trong Android</h1>


### Nội dung
1. [***Cấu hình và thư viện.***](#muc1) 
2. [***Xây dựng các file layout.***](#muc2)
3. [***Xây dựng chức năng.***](#muc3)

<div align="center"><img  src="https://i.imgur.com/81fLj7E.gif"/></div>

<a name="muc1"></a>
## 1. Cấu hình và thư viện.
- Đầu tiên thêm thư viện cần dùng trong ví dụ này:
```
//tạo indicator trong slide show image  
implementation 'me.relex:circleindicator:2.1.4'

//cardview để bo góc slide
implementation "androidx.cardview:cardview:1.0.0"

//Ngoài ra mình còn dùng thư viện glide để load ảnh từ drawable
implementation 'com.github.bumptech.glide:glide:4.11.0'
```
- Chú ý ở trên thư viện [CircleIndicator](https://github.com/ongakuer/CircleIndicator) dùng để tạo các indicator, có thể tham khảo theo link.

<a name="muc2"></a>
## 2. Xây dựng các file layout.
- Theo thứ tự mình sẽ xây dựng file layout để hiển thị 1 hình ảnh (file item hiển thị như một hình ảnh trong slide), xây dựng 2 file cho indicator (2 file một dành cho dạng selected và một cho dạng unselected, có thể tạo hình tròn hay chữ nhật tuỳ ý ở đây), một file layout nơi hiển thị image slide.
- Đầu tiên xây dựng file `item_photoslide.xml` trong **layout**:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<LinearLayout  
  xmlns:android="http://schemas.android.com/apk/res/android"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content">  
  
 <ImageView  android:id="@+id/imgSliderItem"  
  android:scaleType="centerCrop"  
  android:src="@drawable/imageslidehome_sinhtohoaqua"  
  android:layout_width="match_parent"  
  android:layout_height="225dp"/>  
</LinearLayout>
```
> Layout này chứ một ImageView, có thể tuỳ chỉnh lại kích thước để phù hợp với từng yêu cầu

- Tiếp theo xây dựng 2 file mô tả 2 trạng thái của indicator trong **drawable**:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<shape xmlns:android="http://schemas.android.com/apk/res/android">  
 <solid android:color="#fff"/>  
 <size android:width="3dp" android:height="0.5dp"/>  
</shape>
```
> 2 file này có nội dung như nhau, chỉ khác màu được chọn trong thẻ `<solid>` để phân biệt giữa indicator đang hiển thị và ko đang hiển thị.

- Tiếp theo là trong layout chính muốn hiển thị ra image slide show ta thêm vào một `FrameLayout` như sau:
```xml
<FrameLayout  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content">  
 <androidx.cardview.widget.CardView
  android:layout_width="match_parent"  
  android:layout_height="225dp"  
  app:cardCornerRadius="10dp"  
  android:layout_margin="10dp">  
 <androidx.viewpager.widget.ViewPager  
  android:id="@+id/viewPagerSlideShow"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"/>  
 <me.relex.circleindicator.CircleIndicator  
  android:id="@+id/indicatorSlider"  
  android:layout_width="wrap_content"  
  android:layout_height="30dp"  
  android:layout_marginBottom="7dp"  
  app:ci_width="3dp"  
  app:ci_height="1dp"  
  app:ci_drawable="@drawable/indicator_imageshow_selected"  
  app:ci_drawable_unselected="@drawable/indicator_imageshow_unselected"  
  android:layout_gravity="bottom|center"/>  
  
  
 </androidx.cardview.widget.CardView>
 </FrameLayout>
```
> Trong thẻ `CircleIndicator` các thuộc tính *ci_drawable* và *ci_drawable_unselected* chính là 2 cái layout đã tạo ở trên.
> Thẻ cardview dùng để bo góc slide cho đẹp, chú ý thẻ này nên đặt trong `FrameLayout` nếu thẻ cha bên ngoài là `NestedScrollView`. (Khuyên nên bọc trong FrameLayout đa số trường hợp).

<a name="muc3"></a>
## 3. Xây dựng chức năng.

- Cũng theo thứ tự, đầu tiên ta tạo một class **PhotoSliderShowHome.java** đối tượng chứa ảnh:
```java
public class PhotoSliderShowHome {  
    private int imageSlider;  
  
    public PhotoSliderShowHome() {  
    }  
  
    public PhotoSliderShowHome(int imageResorce) {  
        this.imageSlider = imageResorce;  
  }  
  
    public int getImageSlider() {  
        return imageSlider;  
  }  
  
    public void setImageSlider(int imageSlider) {  
        this.imageSlider = imageSlider;  
  }  
}
```
> Ảnh này mình để trong thư mục drawable nên có kiểu int.

- Sau đó tạo class Adapter của ImageSlide này:
```java
public class AdapterImageSliderShow extends PagerAdapter {  
  
    private Context context;  
    private List<PhotoSliderShowHome> listPhoto;  
  
	public AdapterImageSliderShow(Context context, List<PhotoSliderShowHome> listPhoto) {  
        this.context = context;  
		this.listPhoto = listPhoto;  
  }  
  
    @NonNull  
	@Override  
	public Object instantiateItem(@NonNull ViewGroup container, int position) {  
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_show_image_slider  
										  ,container,false);  
		//Ánh xạ và thêm ảnh vào:  
		ImageView imageView = view.findViewById(R.id.imgSliderItem);  
		Glide.with(context).load(listPhoto.get(position).getImageSlider()).into(imageView);  
  
		//Sau đó add view vào container  
		container.addView(view);  
  
		return view;  
  }  
  
    @Override  
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {  
        //Trên kia thêm thì ở hàm destroy này thì xoá
        container.removeView((View) object);  
  }  
  
    @Override  
	public int getCount() {  
        if (listPhoto!=null){  
            return listPhoto.size();  
		}  
        return 0;  
    }  
  
    @Override  
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {  
        return view==object;  
    }  
}
```

- Đây là code trong class fragment hay activity chứa image slide:
```java
//Trước đó phải khai báo và ánh xạ các view:
//Xử lí slider show:  
listPhotoSlider = loadImageSlider(); //hàm này trả về danh sách hình ảnh (tự viểt)
adapterSliderHome = new AdapterImageSliderShow(getActivity(),listPhotoSlider);  
viewPagerHome.setAdapter(adapterSliderHome);  
circleIndicatorHome.setViewPager(viewPagerHome);  
adapterSliderHome.registerDataSetObserver(circleIndicatorHome.getDataSetObserver()); //Quan trọng phải có
```

- Nếu muốn làm cho các image tự chuyện động:
```java
//Trước đó khai báo Timer là một biến toàn cục (thư viện java.util.Timer)

if (listPhotoSlider==null||listPhotoSlider.isEmpty()||viewPagerHome==null){  
    return;  
}  
if (timer==null){  
    timer = new Timer();  
}  
timer.schedule(new TimerTask() {  
    @Override  
	public void run() {  
        new Handler(Looper.getMainLooper()).post(new Runnable() {  
            @Override  
			public void run() {  
                int currentImage = viewPagerHome.getCurrentItem();  
				int totalItem = listPhotoSlider.size()-1;  
				if (currentImage<totalItem){  
				    currentImage++;  
				    viewPagerHome.setCurrentItem(currentImage);  
				} else {  
				    viewPagerHome.setCurrentItem(0);  
				}  
			}  
		});  
  }  
},500,3000);
```

> Chú ý nếu dùng timer thì nhớ huỷ trong hàm detroy:
```java
@Override  
public void onDestroy() {  
    super.onDestroy();  
	if (timer!=null){  
        timer.cancel();  
		timer=null;  
  }  
}
```