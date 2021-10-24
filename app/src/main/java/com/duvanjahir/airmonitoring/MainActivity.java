package com.duvanjahir.airmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class MainActivity extends AppCompatActivity {

    private HTextView hTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hTextView = (HTextView) findViewById(R.id.txtRegistrar);
        hTextView.setTextColor(Color.WHITE);
        hTextView.setBackgroundColor(Color.BLACK);
        //hTextView.setTypeface(FontManager.getInstance(getAssets()).getFont("font/Caveat-VariableFont_wght.ttf"));
        hTextView.setAnimateType(HTextViewType.LINE);
    }
}