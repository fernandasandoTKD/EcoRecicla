package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class EstadistcsActivity extends AppCompatActivity {

     ImageView home;

     TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistcs);
        home=findViewById(R.id.ivHome);
        table=findViewById(R.id.tableEstadistic);

        Intent homeSection= new Intent(this, HomeActivity.class);
        

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });
    }

    //función para añadir campos a un tabla.

    public void addElementData(String month, String min, String max, String pro){
        TableRow  row = new TableRow(this);
        TextView  cell1= new TextView(this);
        cell1.setText(pro);
        TextView cell2= new TextView(this);
        cell2.setText(max);
        TextView cell3 = new TextView(this);
        cell3.setText(min);
        TextView cell4 = new TextView(this);
        cell4.setText(month);

        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);

        table.addView(row);
    }
}