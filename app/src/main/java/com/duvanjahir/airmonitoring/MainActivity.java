package com.duvanjahir.airmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.ingreso_email);
        pass=(EditText) findViewById(R.id.ingreso_password);
    }

    public void ingresar(View view){
        String Emai=email.getText().toString();
        String Pass=pass.getText().toString();
        System.out.println(Emai+" "+Pass);
    }
    public void Registarse(View view){
        Intent intent= new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}