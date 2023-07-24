package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class HomeActivity extends AppCompatActivity {

    Button stadistics, category, tips;
    ImageView imgStadistics, imgCategory, imgTips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stadistics=findViewById(R.id.btnStadistic);
        category=findViewById(R.id.btnCategories);
        tips=findViewById(R.id.btnTips);
        imgStadistics=findViewById(R.id.ivStadistic);
        imgCategory=findViewById(R.id.ivCategories);
        imgTips=findViewById(R.id.ivTips);

        Intent  sectionStadistics=new Intent(this, EstadistcsActivity.class);
        Intent  sectionTips= new Intent (this, RecommendationActivity.class);
        Intent  sectionCategories= new Intent (this, MaterialActivity.class);

        //Section of events
        stadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionStadistics);
            }
        });

        imgStadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionStadistics);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionTips);
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionCategories);
            }
        });


        imgCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionCategories);
            }
        });

        imgTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionTips);
            }
        });

    }
}