package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InecCourseThree extends AppCompatActivity {

    RelativeLayout test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11, test12, test13, test14, test15;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15;
    String str1;

    ImageView backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inec_course_three);

        backPressed = findViewById(R.id.backbtn);
        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InecCourseThree.this, ItmaDashboard.class);
                startActivity(i);
            }
        });

        txt1 = findViewById(R.id.test1);
        txt2 = findViewById(R.id.test2);
        txt3 = findViewById(R.id.test3);
        txt4 = findViewById(R.id.test4);
        txt5 = findViewById(R.id.test5);
        txt6 = findViewById(R.id.test6);
        txt7 = findViewById(R.id.test7);
        txt8 = findViewById(R.id.test8);
        txt9 = findViewById(R.id.test9);
        txt10 = findViewById(R.id.test10);
        txt11 = findViewById(R.id.test11);
        txt12 = findViewById(R.id.test12);
        txt13 = findViewById(R.id.test13);
        txt14 = findViewById(R.id.test14);
        txt15 = findViewById(R.id.test15);

        //first test onclick
        test1 = findViewById(R.id.question3_1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt1.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //second test onclick
        test2 = findViewById(R.id.question3_2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt2.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //third test onclick
        test3 = findViewById(R.id.question3_3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt3.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //4th test onclick
        test4 = findViewById(R.id.question3_4);
        test4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt4.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //5th test onclick
        test5 = findViewById(R.id.question3_5);
        test5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt5.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //6th test onclick
        test6 = findViewById(R.id.question3_6);
        test6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt6.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //7th test onclick
        test7 = findViewById(R.id.question3_7);
        test7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt7.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //8th test onclick
        test8 = findViewById(R.id.question3_8);
        test8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt8.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //9th test onclick
        test9 = findViewById(R.id.question3_9);
        test9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt9.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //10th test onclick
        test10 = findViewById(R.id.question3_10);
        test10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt10.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //11th test onclick
        test11 = findViewById(R.id.question3_11);
        test11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt11.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //12th test onclick
        test12 = findViewById(R.id.question3_12);
        test12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt12.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //13th test onclick
        test13 = findViewById(R.id.question3_13);
        test13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt13.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //14th test onclick
        test14 = findViewById(R.id.question3_14);
        test14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt14.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

        //15th test onclick
        test15 = findViewById(R.id.question3_15);
        test15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1 = txt15.getText().toString();

                Intent i = new Intent(InecCourseThree.this, PdfViewChapter3.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
        });

    }
}
