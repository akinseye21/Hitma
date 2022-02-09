package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question14 extends AppCompatActivity {

    public static final String RESULT_URL = "http://54.71.22.155/hitma/mobile/results";

    Button check, next;
    LinearLayout answer;
    TextView answ;
    ImageView ansimg;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String selected;
    String solution;
    TextView score, update, conti;

    private String[] chap1courses = new String[11];

    int counter;
    String status1, status2, status3, status4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question14);

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

        chap1courses[0] = "Professional Ethics of Election Officials";
        chap1courses[1] = "Election Officials and their Duties";
        chap1courses[2] = "Persons allowed into the Polling Stations/PollingUnit and Collation Center on Polling day";
        chap1courses[3] = "Role of Security Agents";
        chap1courses[4] = "Appointment of Polling Agents";
        chap1courses[5] = "Role of Election Observers";
        chap1courses[6] = "Role of Accredited Journalists";
        chap1courses[7] = "Media Interviews";
        chap1courses[8] = "Locating the Polling Unit (PU)";
        chap1courses[9] = "Registration Area Centres (RACs)";
        chap1courses[10] = "The Election Monitoring and Support Centre (EMSC)";

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
        status2 = i.getExtras().getString("status for question 2");
        status3 = i.getExtras().getString("status for question 3");

        //get email from shared preference
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        final String email_add = prefs.getString("email", "No email found defined");

        System.out.println("question ="+question_list+"\nOptions A ="+optionA_list+"\nOptions B ="+optionB_list+"\nOptions C="+optionC_list+"\nOptions D ="+optionD_list+"\nCorrect Options ="+correct_option_list+"\nCounter ="+counter);
        //Toast.makeText(getApplicationContext(), "question ="+question_list+"\nOptions A ="+optionA_list+"\nOptions B ="+optionB_list+"\nOptions C="+optionC_list+"\nOptions D ="+optionD_list+"\nCorrect Options ="+correct_option_list+"\nCounter ="+counter, Toast.LENGTH_LONG).show();

        System.out.println("module = "+module+ "\nchapter = "+chapter_name);



        //Toast.makeText(getApplicationContext(), "Correct answer = "+correct_option_list.get(j), Toast.LENGTH_LONG).show();
        //System.out.println("Correct answer = "+correct_option_list.get(3));

        //questNum.setText(j++);
        course_name.setText(courseName);
        quest.setText(question_list.get(3));
        opt1.setText(optionA_list.get(3));
        opt2.setText(optionB_list.get(3));
        opt3.setText(optionC_list.get(3));
        opt4.setText(optionD_list.get(3));

        //questCount.setText(j++);
        solution = correct_option_list.get(3);


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

                else {
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
                        status4 = "pass";


                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to a new activity of questions and pass all arraylist, and counter;

                                //custom dialogue
                                Dialog dialog = new Dialog(Question14.this);
                                dialog.setContentView(R.layout.custompopup3);

                                score = dialog.findViewById(R.id.scores);
                                update = dialog.findViewById(R.id.status);
                                conti = dialog.findViewById(R.id.conti);
                                score.setText(String.valueOf(counter));
                                update.setText("Question 1= "+status1+"\nQuestion 2= "+status2+"\nQuestion 3= "+status3+"\nQuestion 4= "+status4);
                                conti.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        //send fields to server
                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, RESULT_URL,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        try{

                                                            // get JSONObject from JSON file
                                                            JSONObject jsonObject = new JSONObject(response);
                                                            String stats_course = jsonObject.getString("test_status");

                                                            if (stats_course.equals("next course")){
                                                                //go to next phase of course
                                                                //if the string in the courseName is course1, move to the course2 content. If coourse2, move to course 3. etc

                                                                String nxtCourse = "";

                                                                if (courseName.equals(chap1courses[0])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[0];
                                                                }
                                                                if (courseName.equals(chap1courses[1])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[1];
                                                                }
                                                                if (courseName.equals(chap1courses[2])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[2];
                                                                }
                                                                if (courseName.equals(chap1courses[3])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[3];
                                                                }
                                                                if (courseName.equals(chap1courses[4])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[4];
                                                                }
                                                                if (courseName.equals(chap1courses[5])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[5];
                                                                }
                                                                if (courseName.equals(chap1courses[6])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[6];
                                                                }
                                                                if (courseName.equals(chap1courses[7])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[7];
                                                                }
                                                                if (courseName.equals(chap1courses[8])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[8];
                                                                }
                                                                if (courseName.equals(chap1courses[9])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[9];
                                                                }
                                                                if (courseName.equals(chap1courses[10])){
                                                                    //move to course 2
                                                                }

                                                                String statme = "true";

                                                                //send the courseName to course1
                                                                Intent w = new Intent(Question14.this, InecCourseOne.class);
                                                                w.putExtra("courseName", nxtCourse);
                                                                w.putExtra("stats", statme);
                                                                startActivity(w);

                                                            }


                                                        }catch (JSONException e){
                                                            e.printStackTrace();
                                                            Toast.makeText(getApplicationContext(), "Weird", Toast.LENGTH_LONG).show();
                                                        }

                                                    }
                                                },
                                                new Response.ErrorListener() {
                                                    @Override
                                                    public void onErrorResponse(VolleyError error) {
                                                        Toast.makeText(Question14.this, "Something is wrong", Toast.LENGTH_LONG).show();
                                                        System.out.print(error.getMessage());
                                                    }
                                                }){
                                            @Override
                                            protected Map<String, String> getParams(){
                                                Map<String, String> params = new HashMap<String, String>();
                                                params.put("email", email_add);
                                                params.put("course", courseName);
                                                params.put("module", module);
                                                params.put("chapter", chapter_name);
                                                params.put("question_1", status1);
                                                params.put("question_2", status2);
                                                params.put("question_3", status3);
                                                params.put("question_4", status4);
                                                return params;
                                            }
                                        };

                                        RequestQueue requestQueue = Volley.newRequestQueue(Question14.this);
                                        requestQueue.add(stringRequest);

                                    }
                                });
                                dialog.show();

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
                        status4 = "fail";

                        check.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //move to next question
                                //custom dialogue
                                Dialog dialog = new Dialog(Question14.this);
                                dialog.setContentView(R.layout.custompopup3);

                                score = dialog.findViewById(R.id.scores);
                                update = dialog.findViewById(R.id.status);
                                conti = dialog.findViewById(R.id.conti);
                                score.setText(String.valueOf(counter));
                                update.setText("Question 1= "+status1+"\nQuestion 2= "+status2+"\nQuestion 3= "+status3+"\nQuestion 4= "+status4);

                                conti.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {



                                        //send fields to server
                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, RESULT_URL,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        try{

                                                            // get JSONObject from JSON file
                                                            JSONObject jsonObject = new JSONObject(response);
                                                            String stats_course = jsonObject.getString("test_status");

                                                            if (stats_course.equals("repeat course")) {
                                                                //go back to the initial course
                                                                Toast.makeText(getApplicationContext(), email_add+" You fail "+response, Toast.LENGTH_LONG).show();
                                                                System.out.println("You fail "+response);

                                                                String nxtCourse = "";

                                                                if (courseName.equals(chap1courses[0])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[0];
                                                                }
                                                                if (courseName.equals(chap1courses[1])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[1];
                                                                }
                                                                if (courseName.equals(chap1courses[2])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[2];
                                                                }
                                                                if (courseName.equals(chap1courses[3])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[3];
                                                                }
                                                                if (courseName.equals(chap1courses[4])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[4];
                                                                }
                                                                if (courseName.equals(chap1courses[5])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[5];
                                                                }
                                                                if (courseName.equals(chap1courses[6])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[6];
                                                                }
                                                                if (courseName.equals(chap1courses[7])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[7];
                                                                }
                                                                if (courseName.equals(chap1courses[8])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[8];
                                                                }
                                                                if (courseName.equals(chap1courses[9])){
                                                                    //set nxtCourse string to be for course 2
                                                                    nxtCourse = chap1courses[9];
                                                                }
                                                                if (courseName.equals(chap1courses[10])){
                                                                    //
                                                                    nxtCourse = chap1courses[10];
                                                                }

                                                                String statme = "stay";

                                                                //send the courseName to course1
                                                                Intent w = new Intent(Question14.this, InecCourseOne.class);
                                                                w.putExtra("courseName", nxtCourse);
                                                                w.putExtra("stats", statme);
                                                                startActivity(w);
                                                            }

                                                        }catch (JSONException e){
                                                            e.printStackTrace();
                                                            Toast.makeText(getApplicationContext(), "Weird", Toast.LENGTH_LONG).show();
                                                        }

                                                    }
                                                },
                                                new Response.ErrorListener() {
                                                    @Override
                                                    public void onErrorResponse(VolleyError error) {
                                                        Toast.makeText(Question14.this, "Something is wrong", Toast.LENGTH_LONG).show();
                                                        System.out.print(error.getMessage());
                                                    }
                                                }){
                                            @Override
                                            protected Map<String, String> getParams(){
                                                Map<String, String> params = new HashMap<String, String>();
                                                params.put("email", email_add);
                                                params.put("module", module);
                                                params.put("chapter", chapter_name);
                                                params.put("course", courseName);
                                                params.put("question_1", status1);
                                                params.put("question_2", status2);
                                                params.put("question_3", status3);
                                                params.put("question_4", status4);
                                                return params;
                                            }
                                        };

                                        RequestQueue requestQueue = Volley.newRequestQueue(Question14.this);
                                        requestQueue.add(stringRequest);

                                    }
                                });

                                dialog.show();

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
