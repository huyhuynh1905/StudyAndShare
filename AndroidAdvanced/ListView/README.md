<h1 align="center">ListView Trong Android</h1>

### Nội dung
1. [***ListView cơ bản.***](#muc1) 
2. [***Custom Listview và sử dụng ViewHolder.***](#muc2)

<a name="muc1"></a>
## 1. ListView cơ bản.
- Ta sẽ tạo ra một listview chỉ chứa danh sách các String để làm ví dụ:
 <div align="center"><img  src="https://i.imgur.com/qHfqGep.png"/></div>
 <div align="center">Đây là layout chính, ta thêm vào một listview.</div>
 
> Trong đó thì thuộc tính `android:listSelector="#E16A6A"` chính là màu khi ta chọn một item trong listview.
> Nếu trong GridView thì có thêm `android:numColumns="<số cột>"` để quy định số cột của một GridView.

- Trong **MainActivity** ta tiến hành khai báo và khởi tạo listview, đây là listview cơ bản nhất:
 <div align="center"><img  src="https://i.imgur.com/bucnJXy.png"/></div>

- Để thao tác với các phần tử trên listview ta có thể sử dụng hàm bắt sự kiện lên các Item:
 <div align="center"><img  src="https://i.imgur.com/7uWXKec.png"/></div>

> Dùng `<adapter>.notifyDataSetChanged()` để tự động cập nhật lại listview khi mà list có sự thay đổi.




<a name="muc2"></a>
## 2. Custom Listview và sử dụng ViewHolder.
- ListView custom là Listview do chính chúng ta định nghĩa ra, thường được dùng nhiều nhất để thể hiện toàn bộ các thuộc tính của đối tượng (Sử dụng object).
- Các bước tạo ra listview trong phần này là: Tạo Object > Tạo một `<dòng item>.xml` trong layout > Custom Adapter của object > Khai báo và sử dụng.
- Tạo một class đối tượng `Student.java` có các thuộc tính và các phương thức khởi tạo, getter và setter:
 <div align="center"><img  src="https://i.imgur.com/VpnwOHg.png"/></div>

- Custom một `onesinhvien_listview.xml` chứa các thông tin muốn hiển thị:
 <div align="center"><img  src="https://i.imgur.com/F9jTPRP.png"/></div>


- Custom lại Adapter - extends từ `BaseAdapter` và thêm vào các thuộc tính như sau:
 <div align="center"><img  src="https://i.imgur.com/l8bpXJR.png"/></div>
 
 - Trong Adapter này ta khai báo và sử dụng ViewHolder nhằm mục đích tăng tốc độ cho app, tránh khởi tạo lại view:
 ```java
 private class ViewHolder{  
    TextView tvName,tvAddress;  
  ImageView imageView;  
}  
@Override  
public View getView(int position, View convertView, ViewGroup parent) {  
    ViewHolder viewHolder;  
 if (convertView==null){  
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
  convertView = inflater.inflate(layout,null);  
  viewHolder = new ViewHolder();  
  
  //Ánh xạ view  
  viewHolder.tvName = convertView.findViewById(R.id.tvName);  
  viewHolder.tvAddress = convertView.findViewById(R.id.tvAddress);  
  viewHolder.imageView = convertView.findViewById(R.id.imgPicture);  
  
  convertView.setTag(viewHolder);  
  } else {  
        viewHolder = (ViewHolder) convertView.getTag();  
  }  
    //Gán giá trị  
  viewHolder.tvName.setText(studentList.get(position).getName());  
  viewHolder.tvAddress.setText(studentList.get(position).getAddress());  
  viewHolder.imageView.setImageResource(studentList.get(position).getImage());  
  
 return convertView;  
}
 ```


- Khai báo trong `MainActivity` tương tự như listview cơ bản:
 <div align="center"><img  src="https://i.imgur.com/l11zOfx.png"/></div>

- Kết quả ứng dụng chạy:
 <div align="center"><img  src="https://i.imgur.com/rA1Dij4.png"/></div>
