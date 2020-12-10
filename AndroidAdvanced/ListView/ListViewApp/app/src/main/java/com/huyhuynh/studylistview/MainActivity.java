package com.huyhuynh.studylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Student> studentList = new ArrayList<>();
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ listview:
        listView = findViewById(R.id.listView);
        /*
        //Tạo một danh sách cơ bản String:
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ListView");
        arrayList.add("Cơ Bản");
        arrayList.add("HuyHuynh");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this
                ,android.R.layout.simple_list_item_1
                ,arrayList);

        listView.setAdapter(arrayAdapter);


        //Thao tác trên listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Đang chọn "+arrayList.get(position)
                        ,Toast.LENGTH_SHORT).show();
            }
        });

        //Kiểm tra cập nhật lại listview sau khi thao tác thêm sửa xoá arrayLisy:
        arrayAdapter.notifyDataSetChanged();
        */

        //Thêm phần tử cho list Student
        studentList.add(new Student("Huy","Thừa Thiên Huế",R.drawable.student1));
        studentList.add(new Student("Bảo","Hà Nội",R.drawable.student1));
        studentList.add(new Student("Huỳnh","Đà Nẵng",R.drawable.student1));
        studentList.add(new Student("Nguyễn","Hồ Chí Minh",R.drawable.student1));

        studentAdapter = new StudentAdapter(MainActivity.this,R.layout.onesinhvien_listview
        ,studentList);

        listView.setAdapter(studentAdapter);
    }
}