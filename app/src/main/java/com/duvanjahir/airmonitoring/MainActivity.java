package com.duvanjahir.airmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class MainActivity extends AppCompatActivity {

    /*private HTextView hTextView;*/
    private EditText emailText, passwordText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*hTextView = findViewById(R.id.txtRegistrar);
        hTextView.setTextColor(Color.WHITE);
        hTextView.setBackgroundColor(Color.BLACK);
        //hTextView.setTypeface(FontManager.getInstance(getAssets()).getFont("font/Caveat-VariableFont_wght.ttf"));
        hTextView.setAnimateType(HTextViewType.LINE);*/

        emailText = (EditText) findViewById(R.id.ingreso_email);
        passwordText = (EditText) findViewById(R.id.ingreso_password);

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