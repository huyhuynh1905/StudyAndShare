package com.huyhuynh.studylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<Student> studentList;
    private int layout;
    private Context context;

    public StudentAdapter( Context context, int layout,List<Student> studentList) {
        this.studentList = studentList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


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

}
