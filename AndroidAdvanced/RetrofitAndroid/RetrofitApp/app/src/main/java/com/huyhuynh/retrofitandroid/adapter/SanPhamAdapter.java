package com.huyhuynh.retrofitandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huyhuynh.retrofitandroid.R;
import com.huyhuynh.retrofitandroid.model.SanPham;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{

    private List<SanPham> list;
    private Context context;

    public SanPhamAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<SanPham> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham,parent,false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = list.get(position);
        if (sanPham==null){
            return;
        }
        holder.tvTensp.setText(sanPham.getTensp());
        holder.tvGiasp.setText("Giá: "+sanPham.getGiasp()+" vnd");
        //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);
        Glide.with(context).load(sanPham.getHinhanh()).into(holder.imgAnhsp);

    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgAnhsp;
        TextView tvTensp,tvGiasp;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnhsp = itemView.findViewById(R.id.img_anhsp);
            tvTensp = itemView.findViewById(R.id.tv_tensp);
            tvGiasp = itemView.findViewById(R.id.tv_giasp);
        }
    }
}
