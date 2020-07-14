package com.example.sqlitetrongandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.sqlitetrongandroid.MainActivity;
import com.example.sqlitetrongandroid.R;
import com.example.sqlitetrongandroid.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> students;
    int layout;
    MainActivity context;

    public StudentAdapter( MainActivity context, int layout,List<Student> students) {
        this.students = students;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        private TextView txID;
        private TextView txName;
        private Button btnUpdate;
        private Button btnDel;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolderl=null;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolderl = new ViewHolder();
            viewHolderl.txID = convertView.findViewById(R.id.txID);
            viewHolderl.txName = convertView.findViewById(R.id.txName);
            viewHolderl.btnUpdate = convertView.findViewById(R.id.btnUpdate);
            viewHolderl.btnDel = convertView.findViewById(R.id.btnDel);

            convertView.setTag(viewHolderl);
        } else {
            viewHolderl = (ViewHolder) convertView.getTag();
        }

        final Student st = students.get(position);
        viewHolderl.txName.setText(st.getName());
        viewHolderl.txID.setText(st.getId()+"");
        viewHolderl.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.updateStudentDataBase(position);
            }
        });
        viewHolderl.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.deleteStudentDatabase(st.getId());
            }
        });
        return convertView;
    }
}
