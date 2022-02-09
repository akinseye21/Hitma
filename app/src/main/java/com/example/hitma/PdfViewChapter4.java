package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PdfViewChapter4 extends AppCompatActivity {

    TextView Topic;
    ImageView ImageText, Back;
    Button conti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_chapter4);

        Topic = findViewById(R.id.topic);
        ImageText = findViewById(R.id.image_test);
        Back = findViewById(R.id.backbtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PdfViewChapter4.this, InecCourseFour.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final String str = intent.getStringExtra("string1");
        Topic.setText(str);

        //a
        if(str.equals("Conflict Prevention at the Polling Unit \nVotingPoint")){
            ImageText.setImageResource(R.drawable.class4_1);
        }

        //b
        if(str.equals("Electoral Offences and Penalties")){
            ImageText.setImageResource(R.drawable.class4_2);
        }

        //c
        if(str.equals("Tips for Poll Officials on Basic Security \nin Election Duties (BaSED)")){
            ImageText.setImageResource(R.drawable.class4_3);
        }

        conti = findViewById(R.id.continu);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(PdfViewChapter4.this, InecCourseFour.class);
                startActivity(j);

//                Intent move = new Intent(PdfViewChapter4.this, Question3.class);
//                move.putExtra("string", str);
//                startActivity(move);
            }
        });

    }
}
