package com.example.myinstagram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myinstagram.R;
import com.example.myinstagram.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding profileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(profileBinding.getRoot());

        view();
    }

    private void view() {
        //Home
        profileBinding.layHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        //Search
        profileBinding.laySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}