package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InecCourseFour extends AppCompatActivity {

    RelativeLayout test1, test2, test3;
    TextView txt1, txt2, txt3;
    String str1;

    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inec_course_four);

        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.text2);
        txt3 = findViewById(R.id.text3);

        backPressed = findViewById(R.id.backbtn);
        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InecCourseFour.this, ItmaDashboard.class);
                startActivity(i);
            }
        });

        test1 = findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = txt1.getText().toString();

                Intent i = new Intent(InecCourseFour.this, PdfViewChapter4.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        test2 = findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = txt2.getText().toString();

                Intent i = new Intent(InecCourseFour.this, PdfViewChapter4.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        test3 = findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = txt3.getText().toString();

                Intent i = new Intent(InecCourseFour.this, PdfViewChapter4.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

    }
}
