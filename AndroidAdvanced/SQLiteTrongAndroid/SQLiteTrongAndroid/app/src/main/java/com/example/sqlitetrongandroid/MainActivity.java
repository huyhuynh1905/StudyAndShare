package com.example.sqlitetrongandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqlitetrongandroid.adapter.StudentAdapter;
import com.example.sqlitetrongandroid.data.DataBaseManager;
import com.example.sqlitetrongandroid.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtPhone, edtAddress, edtEmail;
    Button btnAdd;
    DataBaseManager dataBaseManager;
    ListView listViewSt;
    StudentAdapter studentAdapter;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khởi tạo database
        dataBaseManager = new DataBaseManager(MainActivity.this);
        init();
        control();
    }

    private void control() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student st = getStudentFromEditText();
                dataBaseManager.insertStudent(st);
                setListView();
            }
        });

        listViewSt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student st = students.get(position);
                edtName.setText(st.getName());
                edtPhone.setText(st.getPhoneNumber());
                edtAddress.setText(st.getAddress());
                edtEmail.setText(st.getEmail());
            }
        });
    }

    private void init() {
        btnAdd = findViewById(R.id.btnAdd);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAdress);
        edtEmail = findViewById(R.id.edtEmail);

        listViewSt = findViewById(R.id.listStudent);
        setListView();

    }

    private void setListView() {
        if (studentAdapter==null){
            students = dataBaseManager.getListStudent();
            studentAdapter = new StudentAdapter(MainActivity.this,R.layout.item_student,students);
            listViewSt.setAdapter(studentAdapter);
        } else {
            students.clear();
            students.addAll(dataBaseManager.getListStudent());
            studentAdapter.notifyDataSetChanged();
            listViewSt.setSelection(students.size()-1);
        }
    }


    private Student getStudentFromEditText(){
        String name = edtName.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        return new Student(name,phone,address,email);
    }

    // 2 phương thức dưới này gọi ở button update and delete class Adapter
    public void updateStudentDataBase(int position){
        Student st = getStudentFromEditText();
        st.setId(students.get(position).getId());
        dataBaseManager.updateStudent(st);
        setListView();
    }
    public void deleteStudentDatabase(int position){
        dataBaseManager.deleteStudent(position);
        setListView();
    }

}
