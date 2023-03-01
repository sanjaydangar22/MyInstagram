package com.example.myinstagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myinstagram.R;
import com.example.myinstagram.modelclass.SearchModelClass;

import java.util.ArrayList;

public class SearchAdapterClass extends RecyclerView.Adapter<SearchAdapterClass.InstaHolder> {
    ArrayList<SearchModelClass> searchList;
    public SearchAdapterClass( ArrayList<SearchModelClass> searchList){
        this.searchList=searchList;
    }
    @NonNull
    @Override
    public SearchAdapterClass.InstaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list,parent,false);

        return new InstaHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapterClass.InstaHolder holder, int position) {
        holder.imgView.setImageResource(searchList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public class InstaHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        public InstaHolder(@NonNull View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.imgView);
        }
    }
}
