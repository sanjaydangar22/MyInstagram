package com.example.myinstagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinstagram.R;
import com.example.myinstagram.interfac.HorizontalClickListner;
import com.example.myinstagram.modelclass.HorizontalModelClass;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalAdapterClass extends RecyclerView.Adapter<HorizontalAdapterClass.InstaHolder> {
    ArrayList<HorizontalModelClass> horizontalList;
    HorizontalClickListner listner;
    public HorizontalAdapterClass(ArrayList<HorizontalModelClass> horizontalList, HorizontalClickListner listner){
        this.horizontalList=horizontalList;
        this.listner=listner;
    }
    @NonNull
    @Override
    public HorizontalAdapterClass.InstaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list,parent,false);

        InstaHolder instaHolder=new InstaHolder(v);
        return instaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapterClass.InstaHolder holder, int position) {
        holder.imgDP.setImageResource(horizontalList.get(position).getImage());
        holder.txtName.setText(horizontalList.get(position).getName());
        holder.layHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClick(horizontalList.get(position).getImage(),horizontalList.get(position).getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class InstaHolder extends RecyclerView.ViewHolder {
        CircleImageView imgDP;
        TextView txtName;
        LinearLayout layHorizontal;
        public InstaHolder(@NonNull View itemView) {
            super(itemView);
            imgDP=itemView.findViewById(R.id.imgDP);
            txtName=itemView.findViewById(R.id.txtName);
            layHorizontal=itemView.findViewById(R.id.layHorizontal);
        }
    }
}
