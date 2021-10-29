package com.duvanjahir.airmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private AutoCompleteTextView userType;
    private EditText nameText, passwordText, passwordVerify, emailText, phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, USERS);
        userType = (AutoCompleteTextView) findViewById(R.id.registro_tipo);
        userType.setAdapter(adapter);
        nameText = (EditText) findViewById(R.id.registro_nombre);
        passwordText = (EditText) findViewById(R.id.registro_password);
        passwordVerify = (EditText) findViewById(R.id.registro_confirmacionpassword);
        phoneText = (EditText) findViewById(R.id.registro_telefono);


    }
    private static final String[] USERS = new String[] {
            "cliente", "tecnico"
    };

    public void btnRegister(View view) {

    }
}