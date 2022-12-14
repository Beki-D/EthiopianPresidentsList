package com.example.ethpresidentlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<President> presidentList;
    Context context;

    public RecyclerViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_president, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_presidentName.setText(presidentList.get(position).getName());
        holder.tv_date.setText(String.valueOf(presidentList.get(position).getDate()));
        Glide.with(this.context).load(presidentList.get(position).getImageURL()).into(holder.iv_presidentPicture);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send the control to AddEdit activity
                Intent intent = new Intent(context, AddEdit.class);
                //
                intent.putExtra("id", presidentList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_presidentPicture;
        TextView tv_presidentName;
        TextView tv_date;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_presidentPicture = itemView.findViewById(R.id.iv_presidentPicture);
            tv_presidentName = itemView.findViewById(R.id.tv_presidentName);
            tv_date = itemView.findViewById(R.id.tv_date);
            parentLayout = itemView.findViewById(R.id.onePresidentLayout);
        }
    }
}
