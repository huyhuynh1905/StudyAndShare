<h1 align="center">SQLite Trong Android</h1>

### Nội dung
1. [***SQLite là gì?***](#muc1) 
2. [***Thực hành SQLite.***](#muc2)

<a name="muc1"></a>
## 1. SQLite là gì?
- `SQLite` là một thư viện phần mềm mà triển khai một `SQL Database Engine`, không cần máy chủ, không cần cấu hình, khép kín và nhỏ gọn. Nó là một cơ sở dữ liệu, không cần cấu hình, có nghĩa là giống như các cơ sở dữ liệu khác mà bạn không cần phải cấu hình nó trong hệ thống của mình.
- `SQLite engine` không phải là một quy trình độc lập (standalone process) như các cơ sở dữ liệu khác, bạn có thể liên kết nó một cách tĩnh hoặc động tùy theo yêu cầu của bạn với ứng dụng của bạn. `SQLite` truy cập trực tiếp các file lưu trữ (storage files) của nó.
- Tại sao nên dùng SQLite?
	-   `SQLite`  không yêu cầu một quy trình hoặc hệ thống máy chủ riêng biệt để hoạt động.
	-   `SQLite`  không cần cấu hình, có nghĩa là không cần thiết lập hoặc quản trị.
	-   Một cơ sở dữ liệu  `SQLite`  hoàn chỉnh được lưu trữ trong một file disk đa nền tảng (cross-platform disk file).
	-   `SQLite`  rất nhỏ và trọng lượng nhẹ, dưới 400KiB được cấu hình đầy đủ hoặc dưới 250KiB với các tính năng tùy chọn bị bỏ qua.
	-   `SQLite`  là khép kín (self-contained), có nghĩa là không có phụ thuộc bên ngoài.
	-   Các transaction trong `SQLite`  hoàn toàn tuân thủ  `ACID`, cho phép truy cập an toàn từ nhiều tiến trình (process) hoặc luồng (thread).
	-   `SQLite`  hỗ trợ hầu hết các tính năng ngôn ngữ truy vấn (query language) được tìm thấy trong tiêu chuẩn  `SQL92 (SQL2)`.
	-   `SQLite`  được viết bằng  `ANSI-C`  và cung cấp API đơn giản và dễ sử dụng.
	-   `SQLite`  có sẵn trên  `UNIX`  (Linux, Mac OS-X, Android, iOS) và Windows (Win32, WinCE, WinRT).

<a name="muc2"></a>
## 2. Thực hành SQLite.
- Bài này mình sẽ làm các chức năng thêm, xoá, sửa một danh sách sinh viên. Giao diện và các thành phần có trong bài này như sau:
![](https://i.imgur.com/bDzoBYM.png) ![](https://i.imgur.com/nHbgv1D.png)
 - Ta tạo một class `DataBaseManager` để làm việc với SQLite như sau:
 ```java
public class DataBaseManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student_database.sqlite";
    public static final String TABLE_NAME = "students";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE_NUMBER = "phone";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";

    public static final int VERSION = 1;

    //Viết lại phương thức khởi tạo
    public DataBaseManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo ra bảng
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                NAME + " TEXT, "+
                PHONE_NUMBER +" TEXT, "+
                ADDRESS +" TEXT, " +
                EMAIL +" TEXT)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Phương thức insert học sinh vào
    public void insertStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        //Dùng ContentValues để đưa dữ liệu đối tượng vào, khỏi cần viết query
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,student.getName());
        contentValues.put(PHONE_NUMBER,student.getPhoneNumber());
        contentValues.put(ADDRESS,student.getAddress());
        contentValues.put(EMAIL,student.getEmail());

        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }
    //Phương thức lấy danh sách sinh viên:
    public List<Student> getListStudent(){
        List<Student> students = new ArrayList<>();
        String query = "Select * from "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){ //Data có trả về
            do {
                Student st = new Student();
                st.setId(cursor.getInt(0));
                st.setName(cursor.getString(1));
                st.setPhoneNumber(cursor.getString(2));
                st.setAddress(cursor.getString(3));
                st.setEmail(cursor.getString(4));
                students.add(st);
            } while (cursor.moveToNext());
        }
        return students;
    }
    //Phương thức update
    public int updateStudent(Student st){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,st.getName());
        contentValues.put(PHONE_NUMBER,st.getPhoneNumber());
        contentValues.put(ADDRESS,st.getAddress());
        contentValues.put(EMAIL,st.getEmail());

        return db.update(TABLE_NAME,contentValues,ID+" = ?",new String[] {String.valueOf(st.getId())});
    }
    //Phương thức delete
    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+" = ?",new String[]{String.valueOf(id)});
    }
}
```

>Sau khi tạo xong Class `DataBaseManager` thì ở `MainActivity` chỉ cần tạo mới đối tượng thì hàm **onCreate** trong  `DataBaseManager` sẽ tự động tạo cả Database và Table cho chúng ta.

- Vì 2 button **Update** và **Delete** nằm ở List nên ta viết 2 phương thức ở `MainActivity` để từ button tại class `StudentAdapter` gọi thực hiện:
<div align="center"><img  src="https://i.imgur.com/G1tx9WL.png"/></div>

- Xử lí sự kiện trong button **Update** và **Delete** trong Adapter:
<div align="center"><img  src="https://i.imgur.com/HvZQoNZ.png"/></div>

> Xem thêm các code trong project đính kèm theo bài để hiểu rõ.


-  Error/Warring: Ở bài này mình gặp một lỗi khi dùng customview (item_student.xml) để custom lại danh sách gắn vào adapter đó là lỗi **Không thể  click vào item trong listview** (cannot click item listview custom android). Và cách khắc phục lỗi này là: 
 <div align="center"><img  src="https://i.imgur.com/4pONlGB.png"/></div>
 
>Thêm dòng: `android:descendantFocusability="blocksDescendants"` vào trong layout của file `item_student.xml`.