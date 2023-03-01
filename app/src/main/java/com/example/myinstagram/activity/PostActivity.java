package com.example.myinstagram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myinstagram.R;
import com.example.myinstagram.databinding.ActivityPostBinding;

public class PostActivity extends AppCompatActivity {
    ActivityPostBinding postBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postBinding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(postBinding.getRoot());

        view();
    }

    private void view() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int img = bundle.getInt("imgDp");
            postBinding.imgDp1.setImageResource(img);
        }
        String name = getIntent().getStringExtra("nameId");
        postBinding.txtNameID.setText(name);
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null) {
            int imgShow = bundle1.getInt("imgShow");
            postBinding.imgShow.setImageResource(imgShow);
        }
        String nameBottom = getIntent().getStringExtra("nameId");
        postBinding.txtNIDBottom.setText(nameBottom);

    }
}