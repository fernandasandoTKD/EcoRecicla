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


//AppCompatActivity: comparte la actividad con cualquier API, toma los recursos y adpta a las versiones.
public class PlasticActivity extends AppCompatActivity {

    ImageView home;
    EditText max, min, pro;
    Button registerPlastic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastic);
        home=findViewById(R.id.ivHome);
        max=findViewById(R.id.txtMax);
        min=findViewById(R.id.txtMin);
        pro=findViewById(R.id.txtprom);
        registerPlastic=findViewById(R.id.btnRegisterPlas);

        Intent homeSection= new Intent (this, HomeActivity.class);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeSection);
            }
        });

        registerPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verificación de campos
                if(! max.getText().toString().isEmpty() &&
                    !min.getText().toString().isEmpty() &&
                    !pro.getText().toString().isEmpty()){

                    //Almacenamiento en TXT y definición de archivo

                    File file= new File(getFilesDir(),"plastic.txt");
                    try {
                        FileWriter writer = new FileWriter(file, true);

                        //BufferedWriter, nos permite guardar y capturar a consumo
                        BufferedWriter bufferedWriter= new BufferedWriter(writer);
                        String consumo=max.getText().toString()+","+
                                        min.getText().toString()+","+
                                        pro.getText().toString()+",";
                        bufferedWriter.write(consumo);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    //Reinicio de los TXT
                    max.setText("");
                    min.setText("");
                    pro.setText("");


                }else{
                    //Mensajes de alerta
                    Toast.makeText(PlasticActivity.this,"Todos los campos deben ser diligenciados", Toast.LENGTH_LONG).show();

                }

            }
        });



    }
}