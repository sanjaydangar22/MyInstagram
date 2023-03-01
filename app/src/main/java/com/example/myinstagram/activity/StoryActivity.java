package com.example.myinstagram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myinstagram.R;
import com.example.myinstagram.databinding.ActivityMainBinding;
import com.example.myinstagram.databinding.ActivityStoryBinding;

public class StoryActivity extends AppCompatActivity {
ActivityStoryBinding storyBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storyBinding=ActivityStoryBinding.inflate(getLayoutInflater());
        setContentView(storyBinding.getRoot());

        view();
    }

    private void view() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int img = bundle.getInt("img");
            storyBinding.imgDP.setImageResource(img);
        }
        String name=getIntent().getStringExtra("name");

        storyBinding.txtNameID.setText(name);

        Intent intent=new Intent(StoryActivity.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },4000);

    }
}