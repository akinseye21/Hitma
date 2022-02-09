package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InecCourseTwo extends AppCompatActivity {

    RelativeLayout testa, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, test13, test14, test15, test16;
    RelativeLayout test17, test18, test19, test20, test21, test22, test23, test24, test25;

    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15;
    TextView txt16, txt17, txt18, txt19, txt20, txt21, txt22, txt23, txt24, txt25;

    String str1;

    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inec_course_two);

        backPressed = findViewById(R.id.backbtn);
        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InecCourseTwo.this, ItmaDashboard.class);
                startActivity(i);
            }
        });

        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.text2);
        txt3 = findViewById(R.id.text3);
        txt4 = findViewById(R.id.text4);
        txt5 = findViewById(R.id.text5);
        txt6 = findViewById(R.id.text6);
        txt7 = findViewById(R.id.text7);
        txt8 = findViewById(R.id.text8);
        txt9 = findViewById(R.id.text9);
        txt10 = findViewById(R.id.text10);
        txt11 = findViewById(R.id.text11);
        txt12 = findViewById(R.id.text12);
        txt13 = findViewById(R.id.text13);
        txt14 = findViewById(R.id.text14);
        txt15 = findViewById(R.id.text15);
        txt16 = findViewById(R.id.text16);
        txt17 = findViewById(R.id.text17);
        txt18 = findViewById(R.id.text18);
        txt19 = findViewById(R.id.text19);
        txt20 = findViewById(R.id.text20);
        txt21 = findViewById(R.id.text21);
        txt22 = findViewById(R.id.text22);
        txt23 = findViewById(R.id.text23);
        txt24 = findViewById(R.id.text24);
        txt25 = findViewById(R.id.text25);

        //a
        testa = findViewById(R.id.test1);
        testa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt1.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //b
        test2 = findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt2.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //c
        test3 = findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt3.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //d
        test4 = findViewById(R.id.test4);
        test4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt4.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //e
        test5 = findViewById(R.id.test5);
        test5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt5.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //f
        test6 = findViewById(R.id.test6);
        test6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt6.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //g
        test7 = findViewById(R.id.test7);
        test7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // do nothing yet, get image from dan
            }
        });

        //h
        test8 = findViewById(R.id.test8);
        test8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt8.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //i
        test9 = findViewById(R.id.test9);
        test9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt9.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //j
        test10 = findViewById(R.id.test10);
        test10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt10.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //k
        test11 = findViewById(R.id.test11);
        test11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt11.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //l
        test12 = findViewById(R.id.test12);
        test12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt12.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //m
        test13 = findViewById(R.id.test13);
        test13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt13.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //n
        test14 = findViewById(R.id.test14);
        test14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt14.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //o
        test15 = findViewById(R.id.test15);
        test15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt15.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //p
        test16 = findViewById(R.id.test16);
        test16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt16.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //q
        test17 = findViewById(R.id.test17);
        test17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt17.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //r
        test18 = findViewById(R.id.test18);
        test18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt18.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //s
        test19 = findViewById(R.id.test19);
        test19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt19.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //t
        test20 = findViewById(R.id.test20);
        test20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt20.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //u
        test21 = findViewById(R.id.test21);
        test21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt21.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //v
        test22 = findViewById(R.id.test22);
        test22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt22.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //w
        test23 = findViewById(R.id.test23);
        test23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt23.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //w
        test24 = findViewById(R.id.test24);
        test24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt24.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //x
        test25 = findViewById(R.id.test25);
        test25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt25.getText().toString();

                Intent i = new Intent(InecCourseTwo.this, PdfViewChapter2.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

    }
}
