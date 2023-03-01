package com.example.myinstagram.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myinstagram.R;
import com.example.myinstagram.adapter.HorizontalAdapterClass;
import com.example.myinstagram.adapter.VerticalAdapterClass;
import com.example.myinstagram.databinding.ActivityMainBinding;
import com.example.myinstagram.interfac.HorizontalClickListner;
import com.example.myinstagram.interfac.VerticalClickListner;
import com.example.myinstagram.modelclass.HorizontalModelClass;
import com.example.myinstagram.modelclass.VerticalModelClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    //horizontal
    ArrayList<HorizontalModelClass> horizontalList = new ArrayList<>();

    ArrayList<Integer> imageList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();

    //Vertical
    ArrayList<VerticalModelClass> verticalList = new ArrayList<>();
    ArrayList<Integer> imageDpList = new ArrayList<>();
    ArrayList<String> nameIdList = new ArrayList<>();
    ArrayList<Integer> imageShowList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        view();
        viewHORIZONTAL();
        viewVERTICAl();
    }

    private void view() {
        //Dialog Box in Toolbar
        mainBinding.imgFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dailog_follow);
                dialog.getWindow().setGravity(Gravity.TOP);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
        });


        //Search
        mainBinding.laySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        //Profile
        mainBinding.layProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent1);
            }
        });
    }


    private void viewHORIZONTAL() {
        infoHORIZONTAL();

        HorizontalClickListner listner=new HorizontalClickListner() {
            @Override
            public void onClick(int img,String name) {
                Intent intent=new Intent(MainActivity.this,StoryActivity.class);
                intent.putExtra("img",img);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        };
        for (int i = 0; i < 11; i++) {
            HorizontalModelClass model = new HorizontalModelClass();
            model.setImage(imageList.get(i));
            model.setName(nameList.get(i));

            horizontalList.add(model);
        }
        HorizontalAdapterClass adapter = new HorizontalAdapterClass(horizontalList,listner);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mainBinding.recycleHorizontal.setLayoutManager(layoutManager);
        mainBinding.recycleHorizontal.setAdapter(adapter);
    }

    private void infoHORIZONTAL() {
        //image
        imageList.add(R.drawable.m3);
        imageList.add(R.drawable.parsuram2);
        imageList.add(R.drawable.tiger);
        imageList.add(R.drawable.m);
        imageList.add(R.drawable.meditating_hanuman);
        imageList.add(R.drawable.modi);
        imageList.add(R.drawable.m2);
        imageList.add(R.drawable.yogi);
        imageList.add(R.drawable.man);
        imageList.add(R.drawable.girl);
        imageList.add(R.drawable.g);
        //name
        nameList.add("Your Story");
        nameList.add("Parsuram");
        nameList.add("Tiger Resort");
        nameList.add("Mahadev");
        nameList.add("Hanuman");
        nameList.add("Narendra Modi");
        nameList.add("Mahakal");
        nameList.add("Yogi");
        nameList.add("Diku");
        nameList.add("Swity");
        nameList.add("Happy Man");
    }

    private void viewVERTICAl() {
        infoVERTICAl();

        VerticalClickListner verticalClickListner=new VerticalClickListner() {
            @Override
            public void onClick(int imgDp, String nameId, int imgShow) {

                Intent intent=new Intent(MainActivity.this,PostActivity.class);
                intent.putExtra("imgDp",imgDp);
                intent.putExtra("nameId",nameId);
                intent.putExtra("imgShow",imgShow);
                startActivity(intent);
            }
        };
        for (int i = 0; i < 5; i++) {
            VerticalModelClass model1 = new VerticalModelClass();
            model1.setImgDp(imageDpList.get(i));
            model1.setNameID(nameIdList.get(i));
            model1.setImgShow(imageShowList.get(i));

            verticalList.add(model1);
        }
        VerticalAdapterClass adapter1 = new VerticalAdapterClass(verticalList,verticalClickListner);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainBinding.recycleVertical.setLayoutManager(layoutManager1);
        mainBinding.recycleVertical.setAdapter(adapter1);
    }

    private void infoVERTICAl() {
        //imageDp
        imageDpList.add(R.drawable.badami);
        imageDpList.add(R.drawable.m2);
        imageDpList.add(R.drawable.modi);
        imageDpList.add(R.drawable.tiger);
        imageDpList.add(R.drawable.man);

        //name
        nameIdList.add("Historical place ");
        nameIdList.add("Mahadev");
        nameIdList.add("Narendra Modi ");
        nameIdList.add("Animal Life ");
        nameIdList.add("Man Style");
   //imageShow
        imageShowList.add(R.drawable.badami);
        imageShowList.add(R.drawable.m);
        imageShowList.add(R.drawable.modi);
        imageShowList.add(R.drawable.tiger);
        imageShowList.add(R.drawable.man);
    }
}