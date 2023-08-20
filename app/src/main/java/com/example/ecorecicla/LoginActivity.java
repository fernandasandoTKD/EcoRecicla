package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.modelos.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView register;

    EditText userLogin, passLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Section of redirect  to other page
        login =findViewById(R.id.btnRegister);
        register=findViewById(R.id.txtRegister);
        userLogin=findViewById(R.id.editTextUserLogin);
        passLogin=findViewById(R.id.editTextTextPassLogin);

        Intent home= new Intent(this, HomeActivity.class);
        Intent registerSection= new Intent(this, RegisterActivity.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!userLogin.getText().toString().isEmpty() &&
                !passLogin.getText().toString().isEmpty()){
                    if(checkUser(userLogin.getText().toString(),passLogin.getText().toString())){
                        startActivity(home);
                    }else {
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña no validos",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Los campos deben estar completos",Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                startActivity(registerSection);
            }
        });

    }

    public  boolean checkUser(String user, String pass){
        File file= new File(getFilesDir(), "userData.txt");
        try{
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line;
            while((line=reader.readLine())!= null){
                String [] userData=line.split(",");;
                String email =userData[1];
                String userName=userData[2];
                String password=userData[3];

                if(email.equals(user) || userName.equals(user) && password.equals(pass)){
                        return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}