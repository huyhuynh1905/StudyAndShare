package com.example.sqlitetrongandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlitetrongandroid.model.Student;

import java.util.ArrayList;
import java.util.List;

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
