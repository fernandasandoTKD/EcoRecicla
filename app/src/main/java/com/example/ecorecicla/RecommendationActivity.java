package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.ecorecicla.modelos.Aluminum;
import com.example.ecorecicla.modelos.Cardboard;
import com.example.ecorecicla.modelos.Paper;
import com.example.ecorecicla.modelos.Plastic;

import java.util.List;

public class RecommendationActivity extends AppCompatActivity {

    ImageView home;
    TableLayout tableRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        home=findViewById(R.id.ivHome);
        tableRecommendation=findViewById(R.id.TableRecommendation);

        Intent homeSection= new Intent(this, HomeActivity.class);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });
    }

    public void inflateTable(List<Aluminum> aluminnum, List <Cardboard> cardboard, List <Paper> paper, List <Plastic> plastic){

    }
}