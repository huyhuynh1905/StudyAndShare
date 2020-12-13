<h1 align="center">Fragment Trong Android</h1>

### Nội dung
1. [***Giới thiệu Fragment***](#muc1) 
2. [***Ví dụ về Fragment***](#muc2)


<a name="muc1"></a>
## 1. Giới thiệu Fragment.
**Một số đặc điểm của Fragment trên viblo tổng kết:**
-   Fragment là một thành phần android độc lập, được sử dụng bởi một activity, giống như một sub-activity.
-   Fragment có vòng đời và giao diện riêng.
-   Các Fragment thường có một file java đi kèm với file giao diện xml. Các fragment không có file giao diện xml thường được gọi là headless fragments.
-   Vòng đời của fragment bị ảnh hưởng trực tiếp bởi vòng đời của activity chủ . Ví dụ, khi hoạt động bị tạm dừng, tất cả phân đoạn trong nó cũng vậy, và khi hoạt động bị hủy, tất cả phân đoạn cũng vậy.
-   Một Fragment có thể được sử dụng trong nhiều Activitiy.
-   Fragment được thêm vào API 11 trở lên.
-   Fragment sử dụng phương thức getActivity() để lấy ra Activity cha
-   Fragment được định nghĩa trong file xml của activity (static definition) hoặc có thể sửa đổi fragment khi đang chạy (dynamic definition)
<div align="center"><img  src="https://i.imgur.com/6lJR1xR.png"/></div>
<div align="center">Vòng đời của một Fragment.</div>


<a name="muc2"></a>
## 2. Ví dụ về Fragment.
Trong ví dụ này ta sẽ tiến hành tạo ra 2 Fragment Red và Blue, mỗi Fragment có một button để chuyển đổi qua lại giữa 2 Fragment và sử dụng animation trong khi chuyển đổi.
<div align="center"><img  src="https://i.imgur.com/R6i84Vt.png"/></div>

- Code của một Fragment (Fragment kia tương tự và chỉ thay đổi về tên các biến):
```java
public class FragmentBlue extends Fragment {  
    private Button btnShowRed;  
 private View blueView;  
 private OnRedClickButtonListener listener;  
  
  @Nullable  
 @Override  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {  
        blueView = inflater.inflate(R.layout.fragment_blue,container,false);  
  init();  
  control();  
 return blueView;  
  }  
  
    public void setListener(OnRedClickButtonListener listener) {  
        this.listener = listener;  
  }  
  
    private void control() {  
        btnShowRed.setOnClickListener(new View.OnClickListener() {  
            @Override  
  public void onClick(View v) {  
                listener.clickButton();  
  }  
        });  
  }  
  
  
    private void init() {  
        btnShowRed = blueView.findViewById(R.id.btnShowRed);  
  }  
  
    public interface OnRedClickButtonListener{  
        void clickButton();  
  }  
}
```

> Ở đây ta sử dụng một interface `OnRedClickButtonListener` dùng chung để từ `MainActivity` có thể dễ dàng thao tác trực tiếp với các thuộc tính trong Fragment.

- Trong `MainActivity` ta tiến hành khai báo và sử dụng các Fragment:

```java
public class MainActivity extends AppCompatActivity {  
    FragmentRed fragmentRed;  
  FragmentBlue fragmentBlue;  
  
  @Override  
  protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
  setContentView(R.layout.activity_main);  
  
  showBlueFragment();  
  }  
  
    private void showRedFragment() {  
        if (fragmentRed==null){  
            fragmentRed = new FragmentRed();  
  //Code này để dùng interface ở fragment  
  fragmentRed.setListener(new FragmentRed.OnBlueClickButtonListener() {  
                @Override  
  public void clickButton() {  
                    showBlueFragment();  
  }  
            });  
  }  
        getSupportFragmentManager().beginTransaction()  
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out,R.anim.anim_left_in,R.anim.anim_left_out)  
                .replace(R.id.layout_activity,fragmentRed,FragmentRed.class.getName())  
                .addToBackStack(null)  
                .commit();  
  }  
  
    private void showBlueFragment() {  
        if (fragmentBlue==null){  
            fragmentBlue = new FragmentBlue();  
  fragmentBlue.setListener(new FragmentBlue.OnRedClickButtonListener() {  
                @Override  
  public void clickButton() {  
                    showRedFragment();  
  }  
            });  
  }  
        getSupportFragmentManager().beginTransaction()  
                .setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out,R.anim.anim_left_in,R.anim.anim_left_out)  
                .replace(R.id.layout_activity,fragmentBlue,FragmentRed.class.getName())  
                .addToBackStack(null)  
                .commit();  
  }  
}
```

> Trong đó thuộc tính `.setCustomAnimations(R.anim.anim_right_in,R.anim.anim_right_out,R.anim.anim_left_in,R.anim.anim_left_out)` được thêm ngay sau `beginTransaction()` đùng để tạo animation giữa lúc chuyển fragment.

> Tham khảo thêm:
> - Từ khoá: "send data fragment", "fragment remove", "fragment pop back stack".