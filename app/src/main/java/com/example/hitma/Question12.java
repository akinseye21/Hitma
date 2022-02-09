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

import java.util.ArrayList;

public class Question12 extends AppCompatActivity {

    Button check, next;
    LinearLayout answer;
    TextView answ;
    ImageView ansimg;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String selected;
    String solution;

    int counter;
    String status1, status2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question12);

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

        Intent i = getIntent();
        final ArrayList<String> question_list = i.getExtras().getStringArrayList("question List");
        final ArrayList<String> optionA_list = i.getStringArrayListExtra("option A List");
        final ArrayList<String> optionB_list = i.getStringArrayListExtra("option B List");
        final ArrayList<String> optionC_list = i.getStringArrayListExtra("option C List");
        final ArrayList<String> optionD_list = i.getStringArrayListExtra("option D List");
        final ArrayList<String> correct_option_list = i.getStringArrayListExtra("correct option List");
        final String courseName = i.getStringExtra("course name");
        final String chapter_name = i.getStringExtra("chapter_name");
        final String module = i.getStringExtra("module");
        counter = i.getExtras().getInt("count");
        status1 = i.getExtras().getString("status for question 1");

        System.out.println("question ="+question_list+"\nOptions A ="+optionA_list+"\nOptions B ="+optionB_list+"\nOptions C="+optionC_list+"\nOptions D ="+optionD_list+"\nCorrect Options ="+correct_option_list+"\nCounter ="+counter+"\nStatus ="+status1);
        //Toast.makeText(getApplicationContext(), "question ="+question_list+"\nOptions A ="+optionA_list+"\nOptions B ="+optionB_list+"\nOptions C="+optionC_list+"\nOptions D ="+optionD_list+"\nCorrect Options ="+correct_option_list+"\nCounter ="+counter+"\nStatus ="+status1, Toast.LENGTH_LONG).show();



        //Toast.makeText(getApplicationContext(), "Correct answer = "+correct_option_list.get(j), Toast.LENGTH_LONG).show();
        System.out.println("Correct answer = "+correct_option_list.get(1));
        System.out.println("question 2 module = "+module);

        //questNum.setText(j++);
        course_name.setText(courseName);
        quest.setText(question_list.get(1));
        opt1.setText(optionA_list.get(1));
        opt2.setText(optionB_list.get(1));
        opt3.setText(optionC_list.get(1));
        opt4.setText(optionD_list.get(1));

        //questCount.setText(j++);
        solution = correct_option_list.get(1);


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
                        check.setVisibility(View.INVISIBLE);

                        //increase the counter by 1
                        counter = counter + 1;
                        //change status to pass
                        status2 = "pass";

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to a new activity of questions and pass all arraylist, and counter;
                                Intent mover = new Intent(Question12.this, Question13.class);
                                mover.putExtra("question List", question_list);
                                mover.putExtra("option A List", optionA_list);
                                mover.putExtra("option B List", optionB_list);
                                mover.putExtra("option C List", optionC_list);
                                mover.putExtra("option D List", optionD_list);
                                mover.putExtra("correct option List", correct_option_list);
                                mover.putExtra("count", counter);
                                mover.putExtra("status for question 1", status1);
                                mover.putExtra("status for question 2", status2);
                                mover.putExtra("course name", courseName);
                                mover.putExtra("chapter_name", chapter_name);
                                mover.putExtra("module", module);
                                startActivity(mover);
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
                        status2 = "fail";

                        check.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to next question
                                Intent mover = new Intent(Question12.this, Question13.class);
                                mover.putExtra("question List", question_list);
                                mover.putExtra("option A List", optionA_list);
                                mover.putExtra("option B List", optionB_list);
                                mover.putExtra("option C List", optionC_list);
                                mover.putExtra("option D List", optionD_list);
                                mover.putExtra("correct option List", correct_option_list);
                                mover.putExtra("count", counter);
                                mover.putExtra("status for question 1", status1);
                                mover.putExtra("status for question 2", status2);
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
