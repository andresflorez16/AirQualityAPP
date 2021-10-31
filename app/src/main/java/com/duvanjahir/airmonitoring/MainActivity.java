package com.duvanjahir.airmonitoring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class MainActivity extends AppCompatActivity {

    /*private HTextView hTextView;*/
    private EditText emailText, passwordText;
    FirebaseFirestore db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = (EditText) findViewById(R.id.ingreso_email);
        passwordText = (EditText) findViewById(R.id.ingreso_password);
        initialize();
    }

    public  void  initialize(){
        FirebaseApp.initializeApp(this);
        db=FirebaseFirestore.getInstance();
    }

    public void login(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.equals("") || password.equals("")) {
            Toast.makeText(this, "Verifique los campos", Toast.LENGTH_SHORT).show();
        }else {
            db.collection("users").document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()) {
                        DocumentSnapshot doc = task.getResult();
                        if(doc.get("email").toString().equals(email) && doc.get("password").toString().equals(password)) {
                            Toast.makeText(getApplicationContext(), "Bienvenido admin", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    public void btnRegister(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        System.out.println(email + " " + password);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}