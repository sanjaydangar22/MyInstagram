package com.example.myinstagram.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.myinstagram.R;
import com.example.myinstagram.adapter.SearchAdapterClass;
import com.example.myinstagram.databinding.ActivitySearchBinding;
import com.example.myinstagram.modelclass.SearchModelClass;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding searchBinding;

    ArrayList<SearchModelClass> searchList = new ArrayList<>();
    ArrayList<Integer> imageList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchBinding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(searchBinding.getRoot());

        view();
    }

    private void view() {
        info();
        searchBinding.layHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
        searchBinding.layProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
                startActivity(intent);


            }
        });
        for (int i = 0; i < imageList.size(); i++) {
            SearchModelClass model = new SearchModelClass();
            model.setImage(imageList.get(i));

            searchList.add(model);
        }
        SearchAdapterClass adapterClass = new SearchAdapterClass(searchList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        searchBinding.recycleSearch.setLayoutManager(gridLayoutManager);
        searchBinding.recycleSearch.setAdapter(adapterClass);


    }

    private void info() {

        imageList.add(R.drawable.modi);
        imageList.add(R.drawable.m3);
        imageList.add(R.drawable.badami);
        imageList.add(R.drawable.g);
        imageList.add(R.drawable.man);
        imageList.add(R.drawable.m2);
        imageList.add(R.drawable.parsuram2);
        imageList.add(R.drawable.girl);
        imageList.add(R.drawable.yogi);
        imageList.add(R.drawable.meditating_hanuman);
        imageList.add(R.drawable.tiger);
        imageList.add(R.drawable.m);
        imageList.add(R.drawable.yogi);
        imageList.add(R.drawable.badami);
        imageList.add(R.drawable.g);
        imageList.add(R.drawable.man);
        imageList.add(R.drawable.m2);
        imageList.add(R.drawable.parsuram2);
        imageList.add(R.drawable.girl);
        imageList.add(R.drawable.m);
        imageList.add(R.drawable.meditating_hanuman);
        imageList.add(R.drawable.m);
    }
}