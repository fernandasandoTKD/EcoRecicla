package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MaterialActivity extends AppCompatActivity {

    Button plastic, paper, cardborad, aluminum;
    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        plastic=findViewById(R.id.btnPlastico);
        paper=findViewById(R.id.btnPapel);
        cardborad=findViewById(R.id.btnCarton);
        aluminum=findViewById(R.id.btnAluminio);
        home=findViewById(R.id.ivHome);

        Intent sectionPlastic =new Intent(this, PlasticActivity.class);
        Intent sectionPaper =new Intent(this, PaperActivity.class);
        Intent sectionCardborad= new Intent(this, CardboardActivity.class);
        Intent sectionAluminum= new Intent (this, AluminumActivity.class);
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
        cardborad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionCardborad);
            }
        });

        aluminum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sectionAluminum);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });



    }
}