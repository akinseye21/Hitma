package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Question1 extends AppCompatActivity {

    Button check, next;
    LinearLayout answer;
    TextView answ;
    ImageView ansimg;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String selected;
    String solution;


    int counter = 0;
    String status1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        TextView chap_name = findViewById(R.id.txt);
        TextView quest = findViewById(R.id.question);
        TextView course_name = findViewById(R.id.nameofcourse);
        TextView questNum = findViewById(R.id.questionNumber);
        TextView questCount = findViewById(R.id.questionCounter);
        RadioButton opt1 = findViewById(R.id.option1);
        RadioButton opt2 = findViewById(R.id.option2);
        RadioButton opt3 = findViewById(R.id.option3);
        RadioButton opt4 = findViewById(R.id.option4);
        check = findViewById(R.id.btncheck);
        next = findViewById(R.id.btnnext);
        answer = findViewById(R.id.txtanswer);
        radioGroup = findViewById(R.id.radGrp);
        answ = findViewById(R.id.ans);
        ansimg = findViewById(R.id.ansimg);


        //get all passed array list
        Intent i = getIntent();
        final ArrayList<String> question_list = i.getExtras().getStringArrayList("question_list");
        final ArrayList<String> optionA_list = i.getStringArrayListExtra("optionA_list");
        final ArrayList<String> optionB_list = i.getStringArrayListExtra("optionB_list");
        final ArrayList<String> optionC_list = i.getStringArrayListExtra("optionC_list");
        final ArrayList<String> optionD_list = i.getStringArrayListExtra("optionD_list");
        final ArrayList<String> correct_option_list = i.getStringArrayListExtra("correct_option_list");
        final String courseName = i.getStringExtra("course name");
        final String chapter_name = i.getStringExtra("chapter_name");
        final String module = i.getStringExtra("module");





        //Toast.makeText(getApplicationContext(), "Correct answer = "+correct_option_list.get(j), Toast.LENGTH_LONG).show();
        System.out.println("Correct answer = "+correct_option_list.get(0));
        System.out.println("question 1 module = "+module);

        //questNum.setText(j++);
        chap_name.setText(module);
        course_name.setText(courseName);
        quest.setText(question_list.get(0));
        opt1.setText(optionA_list.get(0));
        opt2.setText(optionB_list.get(0));
        opt3.setText(optionC_list.get(0));
        opt4.setText(optionD_list.get(0));

        //questCount.setText(j++);
        solution = correct_option_list.get(0);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkButton();


                String ans = null;

                int radioID = radioGroup.getCheckedRadioButtonId();
                //checks the checked button in the radiogroup and store in var
                radioButton = findViewById(radioID);

                if(radioID == -1){
                    ans = "";
                }
                else{
                    selected = (String) radioButton.getText();
                    if (selected.equals(solution)) {
                        ans = "correct";
                    }
                    if (!selected.equals(solution)){
                        ans = "wrong";
                    }
                }


                switch (ans){
                    case ("correct"):
                        answer.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        //next.setText("NEXT");
                        check.setVisibility(View.GONE);

                        //increase the counter by 1
                        counter = counter + 1;
                        //change status to pass
                        status1 = "pass";

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to a new activity of questions and pass all arraylist, and counter;
                                Intent mover = new Intent(Question1.this, Question12.class);
                                mover.putExtra("question List", question_list);
                                mover.putExtra("option A List", optionA_list);
                                mover.putExtra("option B List", optionB_list);
                                mover.putExtra("option C List", optionC_list);
                                mover.putExtra("option D List", optionD_list);
                                mover.putExtra("correct option List", correct_option_list);
                                mover.putExtra("count", counter);
                                mover.putExtra("status for question 1", status1);
                                mover.putExtra("course name", courseName);
                                mover.putExtra("chapter_name", chapter_name);
                                mover.putExtra("module", module);
                                startActivity(mover);
                                //passingData();
                            }
                        });
                        break;

                    case ("wrong"):
                        answ.setText("WRONG");
                        answer.setBackgroundColor(Color.RED);
                        ansimg.setImageResource(R.drawable.wrong);
                        answer.setVisibility(View.VISIBLE);

                        check.setText("NEXT");
                        check.setBackgroundColor(Color.RED);

                        //increase the counter by 0
                        counter = counter + 0;
                        //change status to pass
                        status1 = "fail";

                        check.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to next question
                                Intent mover = new Intent(Question1.this, Question12.class);
                                mover.putExtra("question List", question_list);
                                mover.putExtra("option A List", optionA_list);
                                mover.putExtra("option B List", optionB_list);
                                mover.putExtra("option C List", optionC_list);
                                mover.putExtra("option D List", optionD_list);
                                mover.putExtra("correct option List", correct_option_list);
                                mover.putExtra("count", counter);
                                mover.putExtra("status for question 1", status1);
                                mover.putExtra("course name", courseName);
                                mover.putExtra("chapter_name", chapter_name);
                                mover.putExtra("module", module);
                                startActivity(mover);

                            }
                        });
                        break;

                    default:
                        //no answer selected
                        Toast.makeText(getApplicationContext(), "No answer selected", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
