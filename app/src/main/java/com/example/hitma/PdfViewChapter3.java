package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PdfViewChapter3 extends AppCompatActivity {

    TextView Topic;
    ImageView ImageText, Back;
    Button conti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_chapter3);

        Topic = findViewById(R.id.topic);
        ImageText = findViewById(R.id.image_test);
        Back = findViewById(R.id.backbtn);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PdfViewChapter3.this, InecCourseThree.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final String str = intent.getStringExtra("string1");
        Topic.setText(str);
        //Toast.makeText(getApplicationContext(), "String = "+str, Toast.LENGTH_LONG).show();

        //a
        if(str.equals("Collation of Election Results")){
            ImageText.setImageResource(R.drawable.collation_of_election_results);
        }

        //b
        if(str.equals("Collation of Presidential Election \nResults at RA/Ward Level")){
            ImageText.setImageResource(R.drawable.collation_at_ward_level);
        }

        //c
        if(str.equals("Collation of Presidential Election \nResults at LGA Level")){
            ImageText.setImageResource(R.drawable.collation_at_lga_level);
        }

        //d
        if(str.equals("Collation of Presidential Election \nResults at State Level")){
            ImageText.setImageResource(R.drawable.collation_at_state_level);
        }

        //e
        if(str.equals("Final Collation and Declaration of \nPresidential Election Results")){
            ImageText.setImageResource(R.drawable.final_collation_and_declaration);
        }

        //f
        if(str.equals("Collation of Senatorial District Election \nResults at LGA/Area Council Level")){
            ImageText.setImageResource(R.drawable.collation_of_senatorial_district_election_result);
        }

        //g
        if(str.equals("Final Collation and Declaration of \nSenatorial District Election \nResults at State Level")){
            ImageText.setImageResource(R.drawable.final_collation_and_declaration_of_senatorial_district_state_level);
        }

        //h is not here

        //i
        if(str.equals("Final Collation and Declaration of \nFederal Constituency Results")){
            ImageText.setImageResource(R.drawable.final_collation_and_declaration_of_federal_constituency_results);
        }

        //j
        if(str.equals("Collation of Governorship Election \nResults at LGA Level")){
            ImageText.setImageResource(R.drawable.collation_of_governorship_election_result_at_lga);
        }

        //k
        if(str.equals("Final Collation and Declaration of \nGovernorship Election Results at \nState Level")){
            ImageText.setImageResource(R.drawable.final_collation_and_declaration_of_governorship_election_results_at_state_level);
        }

        //l
        if(str.equals("Collation and Declaration of \nState Constituency Election Results \nwith Not more than one LGA (LGA Level)")){
            ImageText.setImageResource(R.drawable.l_3);
        }

        //m
        if(str.equals("Collation and Declaration of \nState Constituency Election Results \nwith more than one LGA (LGA Level)")){
            ImageText.setImageResource(R.drawable.m_3);
        }

        //n
        if(str.equals("Collation of State Constituency \nElection Results with Less than \nOne LGA (at State Constituency Level)")){
            ImageText.setImageResource(R.drawable.n_3);
        }

        //o
        if(str.equals("MARGIN OF LEAD SCENARIOS")){
            ImageText.setImageResource(R.drawable.o_3);
        }

        //p
        if(str.equals("MANAGEMENT OF THE MARGIN \nOF LEAD PRINCIPLES")){
            ImageText.setImageResource(R.drawable.response_scenerio);
        }

        conti = findViewById(R.id.continu);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(PdfViewChapter3.this, InecCourseThree.class);
                startActivity(j);

//                Intent move = new Intent(PdfViewChapter3.this, Question3.class);
//                move.putExtra("string", str);
//                startActivity(move);
            }
        });

    }
}
