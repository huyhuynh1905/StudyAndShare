<h1 align="center">Recycleview Trong Android</h1>

### Nội dung
1. [***Giới thiệu và thư viện.***](#muc1) 
2. [***Các loại LayoutManager trong RecyleView.***](#muc2)
3. [***Custom LinearLayoutManager Horizontal + Vertical.***](#muc3)
4. [***Multi view type (Multi view holder).***](#muc4)


<a name="muc1"></a>
## 1. Giới thiệu và thư viện.
Thêm thư viện về [Recycleview](https://developer.android.com/jetpack/androidx/releases/recyclerview) và [Cardview](https://developer.android.com/jetpack/androidx/releases/cardview):
```
implementation "androidx.recyclerview:recyclerview:1.1.0"

implementation "androidx.cardview:cardview:1.0.0"
```
Một thư viện [CircleImageView](https://github.com/hdodenhof/CircleImageView) để custom hình tròn cho image:

```
implementation 'de.hdodenhof:circleimageview:3.1.0'
```
> Tham khảo thêm video hướng dẫn [tại đây](https://www.youtube.com/playlist?list=PL3Ob3F0T-08awPo1n263zt76wB5MfLsUq).

<a name="muc2"></a>
## 2. Các loại LayoutManager trong RecyleView.
Đầu tiên ta tạo một file `item_user.xml` dùng để hiển thị một item trong danh sách, ở đây mình sẽ dùng CardView để tạo để có thể custom dễ dàng hơn:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:layout_marginTop="10dp"  
  android:layout_marginEnd="10dp"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  app:cardCornerRadius="10dp">  
  
 <LinearLayout  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  android:orientation="vertical">  
  
 <ImageView  android:id="@+id/imgAvt"  
  android:layout_width="match_parent"  
  android:layout_height="130dp"  
  android:src="@drawable/avt1"  
  android:scaleType="centerCrop"/>  
         <TextView  
  android:id="@+id/txtName"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:textSize="16dp"  
  android:padding="6dp"  
  android:text="Huỳnh Bảo Huy"/>  
  
 </LinearLayout>  
</androidx.cardview.widget.CardView>
```

Vì như một List hiển thị nên sẽ có một Adapter để làm việc với Recyvleview và đối tượng. Mình sẽ tạo một class `UserAdapter.java` kế thừa từ `RecyclerView.Adapter<class Holder>` - Truyền vào một class Holder của chính cái view xml của từng item, mình tạo bằng cách tạo class này như một class con trong chính Adapter này:
```java
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {  
  
    private Context context;  
	private List<User> listUsers;  
  
	public UserAdapter(Context context) {  
		this.context = context;;  
	}  
  
    public void setData(List<User> listUsers) {  
        this.listUsers = listUsers;  
		notifyDataSetChanged();  
  }  
  
    @NonNull  
	@Override  
	public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);  
		return new UserViewHolder(view);  
	}  
  
    @Override  
	public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {  
        User user = listUsers.get(position);  
		if (user==null){  
		            return;  
		}  
        holder.txtName.setText(user.getName());  
		holder.imgAvt.setImageResource(user.getAvatar());  
	 }  
  
    @Override  
	public int getItemCount() {  
        if (listUsers!=null){  
            return listUsers.size();  
		}  
	        return 0;  
	 }  
  
    //Class ViewHolder  
	public class UserViewHolder extends RecyclerView.ViewHolder {  
        private TextView txtName;  
		private ImageView imgAvt;  
  
		public UserViewHolder(@NonNull View itemView) {  
            super(itemView);  
			txtName = itemView.findViewById(R.id.txtName);  
			imgAvt = itemView.findViewById(R.id.imgAvt);  
		}  
    }  
}
```

> Chú ý:
> - Class `UserViewHolder` kế thừa từ class `RecyclerView.ViewHolder`
>  - Trong phương thức getItemCount() ta sẽ trả về size của list.
>  - Phương thức `onCreateViewHolder` dùng để ánh xạ các view và ánh xạ layout item.
>  - Phương thức `onBindViewHolder` dùng để gán dữ liệu và xử lí trên từng item.
>  - Rõ ràng trước đó phải có một Class `User.java`:
>  <div align="center"><img  src="https://i.imgur.com/kJ3XGno.png"/></div>

Trong file `activity_main.xml` thì ta tạo ra một `RecyvleView` thôi:
<div align="center"><img src="https://i.imgur.com/xQVSVdf.png"/></div>

Trong `MainActivity` ta tiến hành khai báo và ánh xạ cho RecycleView:
<div align="center"><img src="https://i.imgur.com/ITGY3ye.png"/></div>

Tiếp theo tuỳ thuộc vào Loại Hiển thị mà ta có các cấu hình sau.

#### 2.1. GridLayoutManager.
Cấu hình GridLayoutManager:
<div align="center"><img src="https://i.imgur.com/Rk5zdWs.png"/></div>
GridLayoutManager sẽ hiển thị các item như sau:
<div align="center"><img src="https://i.imgur.com/ZI3puf4.png"/></div>

#### 2.2. LinearLayoutManager.
Cấu hình LinearLayoutManager:
```java
LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);  
recyclerView.setLayoutManager(layoutManager);
```
LinearLayoutManager sẽ hiển thị các item như sau:
<div align="center"><img src="https://i.imgur.com/hIU5uVj.png"/></div>

> Tham số `LinearLayoutManager.VERTICAL` truyền ở trên chính là chiều vuốt (đứng-vertical) và hiển thị của RecyvleView. có thể đổi `VERTICAL` hoặc `HORIZONTAL` (vuốt ngang)

#### 2.3. StaggeredGridLayoutManager.
Chú ý với StaggeredGridLayoutManager thì trong `item_user.xml` các căn chỉnh chiều dài đều là `ndroid:layout_height="wrap_content"` (nó sẽ hiển thị ngẫu nhiên tuỳ theo kích thước chiều dọc của ảnh).

Cấu hình StaggeredGridLayoutManager (2 tham số truyền vào là số cột và chiều lướt hiển thị):
```java
StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);  
recyclerView.setLayoutManager(layoutManager);
```
StaggeredGridLayoutManager sẽ hiển thị các item như sau:
<div align="center"><img src="https://i.imgur.com/BUIlJKM.png"/></div>

<a name="muc3"></a>
## 3. Custom LinearLayoutManager Horizontal + Vertical.
Ta sẽ custom một ứng dụng hiển thị bao gồm danh sách LinearLayoutManager.VERTICAL, trong đó mỗi item sẽ chứa một trường tên và một trường RecycleView dạng LinearLayoutManager.HORIZONTAL như sau:
<div align="center"><img src="https://i.imgur.com/Ee52t4p.png"/></div>

Đầu tiên ta sẽ custom `item_book.xml` để hiển thị một item ngang:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"  
  android:layout_width="100dp"  
  android:layout_height="wrap_content"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  app:cardCornerRadius="10dp"  
  android:layout_marginBottom="10dp"  
  android:layout_marginRight="10dp"  
  android:layout_marginLeft="10dp"  
  android:layout_marginTop="10dp"  
  android:id="@+id/card_item_book">  
  
 <LinearLayout  android:orientation="vertical"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content">  
 <ImageView  android:id="@+id/imgBook"  
  android:layout_width="match_parent"  
  android:layout_height="120dp"  
  android:src="@drawable/avt1"  
  android:scaleType="centerCrop"  
  />  
  
 <TextView  android:id="@+id/txtNameBook"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:text="Book 1"  
  android:textSize="16dp"  
  android:textColor="#000000"/>  
 </LinearLayout></androidx.cardview.widget.CardView>
```

Tiếp tục thêm một file `item_categry.xml` để hiển thị một dòng item:
```xml
<?xml version="1.0" encoding="utf-8"?>  
<androidx.constraintlayout.widget.ConstraintLayout  
  xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:app="http://schemas.android.com/apk/res-auto"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content">  
  
 <TextView  android:id="@+id/txtNameCategry"  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:layout_marginStart="10dp"  
  android:text="Catagry"  
  android:textColor="#C63131"  
  android:textSize="28dp"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toTopOf="parent" />  
  
 <androidx.recyclerview.widget.RecyclerView  android:id="@+id/recycleViewCategry"  
  android:layout_marginTop="10dp"  
  android:layout_width="match_parent"  
  android:layout_height="wrap_content"  
  app:layout_constraintEnd_toEndOf="parent"  
  app:layout_constraintStart_toStartOf="parent"  
  app:layout_constraintTop_toBottomOf="@+id/txtNameCategry" />  
  
</androidx.constraintlayout.widget.ConstraintLayout>
```

Vì có 2 dạng đối tượng hiển thị nên ta sẽ tạo ra 2 class `Book.java` và `Categry.java` (Categry sẽ có một thuộc tính là List\<Book> chứa danh sách book). Tiếp đó sẽ tạo ra các Adapter của mỗi class trên.
```java
@Override  
public void onBindViewHolder(@NonNull CategryViewholder holder, int position) {  
  Categry categry = categryList.get(position);  
  if (categry==null){  
	return;  
  }  
  
    holder.txtNameCategry.setText(categry.getNameCategry());  
  
  //Xử lí RecycleView của Book lồng trong này:  
  LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);  
  holder.recyclerViewBook.setLayoutManager(layoutManager);  
  
  BookAdapter bookAdapter = new BookAdapter();  
  bookAdapter.setDataBook(categry.getBookList());  
  holder.recyclerViewBook.setAdapter(bookAdapter);  
}
```

> Vì `CategryAdapter.java` có chứa một trường RecyvleView dạng Horizontal nên code sẽ khác ở trong phương thức `onBindViewHolder()`

>Còn lại việc khai báo và ánh xạ trong `MainActivity` tương tự như phần trước.
>

<a name="muc4"></a>
## 4. Multi view type (Multi view holder).
Ở phần này ta sẽ custom RecyvleView để có thể hiển thị được nhiều kiểu item trong cùng một RecycleView. Ví dụ như sau:
<div align="center"><img src="https://i.imgur.com/nJiGOe4.png"/></div>

Vì có cả 2 kiểu item hiển thị nên sẽ custom 2 file layout để tạo ra 2 kiểu trên là `item_user_feature.xml` và `item_user_normal.xml` (có thể xem thêm trong source code đính kèm).

Ta sẽ tạo một class `MultiUser.java` để hiển thị lên item, trong đó có một thuộc tính `isFeature` dùng để kiểm tra kiểu item hiển thị nào:
<div align="center"><img src="https://i.imgur.com/HglzYP7.png"/></div>

Chúng ta vẫn sẽ tạo ra một class `MultiUserAdapter.java` để hiển thị ra. Trong chính class này phải tạo ra **2 class con chứa trong nó** đại diện cho 2 kiểu hiển thị để ánh xạ cho từng item hiển thị:
```java
public class MultiUserFeatureHolder extends RecyclerView.ViewHolder{  
  
    TextView tvNameFeature;  
	ImageView imgFeature;  
	public MultiUserFeatureHolder(@NonNull View itemView) {  
	  super(itemView);  
	  tvNameFeature = itemView.findViewById(R.id.tv_feature);  
	  imgFeature = itemView.findViewById(R.id.img_feature);  
	}  
}  
  
public class MultiUserNormalHolder extends RecyclerView.ViewHolder{  
  
    TextView tvNameNormal;  
	ImageView imgNormal;  
	public MultiUserNormalHolder(@NonNull View itemView) {  
	  super(itemView);  
	  
	  tvNameNormal = itemView.findViewById(R.id.tv_normal);  
	  imgNormal = itemView.findViewById(R.id.img_normal);  
	}  
}
``` 

> Vì có 2 class ViewHolder cho mỗi loại nên class `MultiUserAdapter` sẽ kế thừa RecycleView.Adapter có generic truyền vào là RecyclerView.ViewHolder như sau:
  ```
class MultiUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
```

Tất cả các phương thức Override lại ta sẽ viết khác so với những phần trước, ngoài ra ta còn phải Override thêm phương thức `getItemViewType()` để xác định loại type. Full code class `MultiUserAdapter` như sau:

```java
public class MultiUserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {  
  
    private static final int TYPE_FEATURE = 1;  
	private static final int TYPE_NORMAL = 2;  
	private List<MultiUser> multiUsers;  
  
	public void setMultiUsers(List<MultiUser> multiUsers) {  
	  this.multiUsers = multiUsers;  
	  notifyDataSetChanged();  
	}  
  
    @NonNull  
	@Override  
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  
        if (TYPE_FEATURE==viewType){  
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_feature,parent,false);  
			return new MultiUserFeatureHolder(view);  
		} else if (TYPE_NORMAL==viewType){  
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_normal,parent,false);  
			return new MultiUserNormalHolder(view);  
		}  
        return null;  
	}  
  
    @Override  
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {  
        MultiUser user = multiUsers.get(position);  
		if (user==null){  
			return;  
		}  
        if (TYPE_FEATURE==holder.getItemViewType()){  
            MultiUserFeatureHolder multiUserFeatureHolder = (MultiUserFeatureHolder) holder;  
			multiUserFeatureHolder.imgFeature.setImageResource(user.getResoureImg());  
			multiUserFeatureHolder.tvNameFeature.setText(user.getName());  
		} else if (TYPE_NORMAL==holder.getItemViewType()){  
            MultiUserNormalHolder multiUserNormalHolder = (MultiUserNormalHolder) holder;  
			multiUserNormalHolder.imgNormal.setImageResource(user.getResoureImg());  
			multiUserNormalHolder.tvNameNormal.setText(user.getName());  
		}  
    }  
  
    @Override  
	public int getItemCount() {  
        if (multiUsers!=null){  
            return multiUsers.size();  
		}  
        return 0;  
	}  
  
    //Xác định loại type  
	@Override  
	public int getItemViewType(int position) {  
        MultiUser multiUser = multiUsers.get(position);  
		if (multiUser.isFeature()){  
            return TYPE_FEATURE;  
		} else {  
            return TYPE_NORMAL;  
		}  
	  }  
  
    //Tạo ra các class  
  public class MultiUserFeatureHolder extends RecyclerView.ViewHolder{  
  
        TextView tvNameFeature;  
		ImageView imgFeature;  
		public MultiUserFeatureHolder(@NonNull View itemView) {  
            super(itemView);  
			tvNameFeature = itemView.findViewById(R.id.tv_feature);  
			imgFeature = itemView.findViewById(R.id.img_feature);  
		}  
    }  
  
    public class MultiUserNormalHolder extends RecyclerView.ViewHolder{  
  
        TextView tvNameNormal;  
		ImageView imgNormal;  
		public MultiUserNormalHolder(@NonNull View itemView) {  
            super(itemView);  
  
			tvNameNormal = itemView.findViewById(R.id.tv_normal);  
			imgNormal = itemView.findViewById(R.id.img_normal);  
		}  
    }  
}
``` 

> Trong method `onBindViewHolder()` và `onCreateViewHolder()` sẽ tuỳ thuộc vào giá trị của `getItemViewType()` trả về để có thể ánh xạ từng item cho từng kiểu view khác nhau.
> Việc khai báo, ánh xạ và sử dụng bên `MainActivity` hoàn toàn giống như các phần trước, tuy nhiên `LinearLayoutManager layoutManager = new LinearLayoutManager(this);` chỉ cần truyền vào context mà không cần truyền các thuộc tính lướt ngang hoặc dọc.