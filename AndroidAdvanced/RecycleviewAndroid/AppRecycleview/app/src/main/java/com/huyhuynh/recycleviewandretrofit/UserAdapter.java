package com.huyhuynh.recycleviewandretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

