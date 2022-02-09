package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PdfViewChapter2 extends AppCompatActivity {

    TextView Topic;
    ImageView ImageText, Back;
    Button conti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_chapter2);

        Topic = findViewById(R.id.topic);
        ImageText = findViewById(R.id.image_test);
        Back = findViewById(R.id.backbtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PdfViewChapter2.this, InecCourseTwo.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final String str = intent.getStringExtra("string1");
        Topic.setText(str);

        if(str.equals("Setting up the Polling Unit")){
            ImageText.setImageResource(R.drawable.class2_1);
        }

        if(str.equals("Accreditation and Voting \nat Appropriate Polling Unit/Voting Point")){
            ImageText.setImageResource(R.drawable.class2_2);
        }

        if(str.equals("Accreditation and Voting")){
            ImageText.setImageResource(R.drawable.class2_3);
        }

        if(str.equals("Opening of Polls")){
            ImageText.setImageResource(R.drawable.class2_4);
        }

        if(str.equals("How to Apply the Indelible Ink")){
            ImageText.setImageResource(R.drawable.class2_5);
        }

        if(str.equals("Tendered Ballot Paper")){
            ImageText.setImageResource(R.drawable.class2_6);
        }

        if(str.equals("Functions of the PVC")){
            ImageText.setImageResource(R.drawable.class2_7);
        }

        if(str.equals("HANDLING PERSONS \nWITH DISABILITIES \n(PWDs)")){
            ImageText.setImageResource(R.drawable.class2_8);
        }

        if(str.equals("CLOSE OF POLLS")){
            ImageText.setImageResource(R.drawable.class2_9);
        }

        if(str.equals("Preparing for Ballot Sorting")){
            ImageText.setImageResource(R.drawable.class2_10);
        }

        if(str.equals("Sorting Procedure")){
            ImageText.setImageResource(R.drawable.class2_11);
        }

        if(str.equals("Counting Procedure")){
            ImageText.setImageResource(R.drawable.class2_12);
        }

        if(str.equals("Recording of Votes on \nForm EC.8A Series")){
            ImageText.setImageResource(R.drawable.class2_13);
        }

        if(str.equals("Packing Up")){
            ImageText.setImageResource(R.drawable.class2_14);
        }

        if(str.equals("The SCR")){
            ImageText.setImageResource(R.drawable.class2_15);
        }

        if(str.equals("Features of the SCR")){
            ImageText.setImageResource(R.drawable.class2_16);
        }

        if(str.equals("Functions of the SCR")){
            ImageText.setImageResource(R.drawable.class2_17);
        }

        if(str.equals("Packing and Unpacking")){
            ImageText.setImageResource(R.drawable.class2_18);
        }

        if(str.equals("Charging the Device")){
            ImageText.setImageResource(R.drawable.class2_19);
        }

        if(str.equals("Turning on/off the Device")){
            ImageText.setImageResource(R.drawable.class2_20);
        }

        if(str.equals("Logging into the IVAS Software")){
            ImageText.setImageResource(R.drawable.class2_21);
        }

        if(str.equals("Identification")){
            ImageText.setImageResource(R.drawable.class2_22);
        }

        if(str.equals("Verification")){
            ImageText.setImageResource(R.drawable.class2_23);
        }

        if(str.equals("Authentication")){
            ImageText.setImageResource(R.drawable.class2_24);
        }

        conti = findViewById(R.id.continu);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(PdfViewChapter2.this, InecCourseTwo.class);
                startActivity(j);

//                Intent move = new Intent(PdfViewChapter2.this, Question3.class);
//                move.putExtra("string", str);
//                startActivity(move);
            }
        });

    }
}
