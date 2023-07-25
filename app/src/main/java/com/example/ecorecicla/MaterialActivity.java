package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MaterialActivity extends AppCompatActivity {

    Button plastic, paper;
    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        plastic=findViewById(R.id.btnPlastico);
        paper=findViewById(R.id.btnPapel);
        home=findViewById(R.id.ivHome);

        Intent sectionPlastic =new Intent(this, PlasticActivity.class);
        Intent sectionPaper =new Intent(this, PaperActivity.class);
        Intent homeSection= new Intent (this, HomeActivity.class);

        plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionPlastic);
            }
        });

        paper.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionPaper);
            }
        }));
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });

    }
}