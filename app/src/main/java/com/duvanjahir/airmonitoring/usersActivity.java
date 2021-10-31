package com.duvanjahir.airmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class usersActivity extends AppCompatActivity {
    private EditText nameText, passwordText, passwordVText, emailText, phoneText;
    private AutoCompleteTextView Typeuser;
    FirebaseFirestore db;
    private static final String[] types = new String[] { "cliente", "tecnico" };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        nameText = (EditText) findViewById(R.id.users_nombre);
        emailText = (EditText) findViewById(R.id.users_email);
        passwordText = (EditText) findViewById(R.id.users_password);
        passwordVText = (EditText) findViewById(R.id.users_confirmacionpassword);
        phoneText = (EditText) findViewById(R.id.users_telefono);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, types);
        Typeuser = (AutoCompleteTextView) findViewById(R.id.users_tipo);
        Typeuser.setAdapter(adapter);


    }
}