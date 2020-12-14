package com.huyhuynh.recycleviewandretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
