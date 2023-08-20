package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecorecicla.modelos.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {


    Button register;
    EditText name, email, pass, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.btnRegister);
        name=findViewById(R.id.editTextUserLogin);
        email=findViewById(R.id.editTextEmail);
        user=findViewById(R.id.editTextUser);
        pass= findViewById(R.id.editTextPass);

        //Creación de intensiones re-diressión de elementos

        Intent login= new Intent(this, LoginActivity.class);

        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //Validación de datos completos

                if(!name.getText().toString().isEmpty() &&
                        !email.getText().toString().isEmpty() &&
                        !user.getText().toString().isEmpty() &&
                        !pass.getText().toString().isEmpty()){
                  if(checkUser(email.getText().toString(),user.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Este usuario ya esta registrado",Toast.LENGTH_LONG).show();
                    } else{
                        //Llamado a modelo user
                        User  users= new User(
                                name.getText().toString(),
                                email.getText().toString(),
                                user.getText().toString(),
                                pass.getText().toString() );

                        //Llamado a función, para alamacenar
                        saveUser(users);
                        //redireccionamiento a login
                        startActivity(login);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Diligencie todos los campos", Toast.LENGTH_LONG).show();
                }

            }

        });
    }


    //Función para alamacemiento de datos
    public void  saveUser(User user){

        File file= new File(getFilesDir(), "userData.txt");
        try{
            //Escribir sobre este documentos creado, y el
            FileWriter writer= new FileWriter(file,true);
            //Sobre escribir, genera nueva línea en el archivo plano.
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(user.getName()+ ","+ user.getEmail() +","+ user.getUserName() +","+ user.getPassword());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //Funcion de comparación de datos existentes

    public boolean checkUser (String email, String user){
         File file = new File(getFilesDir(),"userData.txt");
         try{
             FileReader reader= new FileReader(file);
             BufferedReader bufferedReader= new BufferedReader(reader);
             String line;
                     List<String>   emailList = new ArrayList<>();
                     List<String>   userNameList= new ArrayList<>();
                        // recoorido de lineas
                     while((line =bufferedReader.readLine())!=null){
                         String [] data= line.split(",");
                         emailList.add(data[2]);
                         userNameList.add(data[1]);
                     }

                      bufferedReader.close();

                     return emailList.contains(email) || userNameList.contains(user);

         } catch (Exception e){
             e.printStackTrace();
         }
         return false;

    }

}