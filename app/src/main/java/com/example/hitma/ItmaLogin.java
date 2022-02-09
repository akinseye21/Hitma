package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItmaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itma_login);

        Button inecReg = findViewById(R.id.btnRegInec);
        inecReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ItmaLogin.this, ItmaSignupPage1.class);
                startActivity(i);
            }
        });

        Button inecLogin = findViewById(R.id.inecLogin);
        inecLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(ItmaLogin.this, ItmaLogin2.class);
                startActivity(j);
            }
        });
    }
}
