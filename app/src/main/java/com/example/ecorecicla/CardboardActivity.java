package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CardboardActivity extends AppCompatActivity {

    ImageView home;
    EditText price, kg, month;
    Button registerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardboard);
        home=findViewById(R.id.ivHome);
        price=findViewById(R.id.txtPrice);
        kg=findViewById(R.id.txtKg);
        month=findViewById(R.id.txtMes);
        registerCard=findViewById(R.id.btnRegister);

        Intent homeSection= new Intent (this, HomeActivity.class);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });

        registerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verificación de campos
                if(!price.getText().toString().isEmpty() &&
                        !kg.getText().toString().isEmpty() && !month.getText().toString().isEmpty()){

                    //Almacenamiento en TXT y definición de archivo

                    File file= new File(getFilesDir(),"card.txt");
                    try {
                        FileWriter writer = new FileWriter(file, true);

                        //BufferedWriter, nos permite guardar y capturar a consumo
                        BufferedWriter bufferedWriter= new BufferedWriter(writer);
                        String consumo= price.getText().toString()+","+
                                kg.getText().toString()+","+
                                month.getText().toString()+",";
                        bufferedWriter.write(consumo);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    //Reinicio de los TXT
                    price.setText("");
                    kg.setText("");
                    month.setText("");


                }else{
                    //Mensajes de alerta
                    Toast.makeText(CardboardActivity.this,"Todos los campos deben ser diligenciados", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}