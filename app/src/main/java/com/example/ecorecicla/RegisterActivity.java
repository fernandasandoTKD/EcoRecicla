package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {


    Button register;
    EditText name, email, pass, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.btnRegister);
        name=findViewById(R.id.editTextUser);
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

                }
                startActivity(login);


            }
        });
    }

}