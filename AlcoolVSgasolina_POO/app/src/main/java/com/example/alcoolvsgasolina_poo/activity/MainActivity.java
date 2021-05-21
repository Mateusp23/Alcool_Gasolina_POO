package com.example.alcoolvsgasolina_poo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.alcoolvsgasolina_poo.R;

public class MainActivity extends AppCompatActivity{

    private static int splash_time_out = 5000; // 5 segundos de tela inicial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       new Handler().postDelayed(new Runnable(){
           @Override
           public void run() {
               Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
               startActivity(homeIntent);
               finish();
           }
       },splash_time_out);
    }
}
