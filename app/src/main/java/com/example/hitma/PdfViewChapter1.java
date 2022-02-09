package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PdfViewChapter1 extends AppCompatActivity {


    TextView Topic;
    ImageView ImageText;

    Button continu;
    ImageView back;


    public static final String QUESTION_URL = "http://54.71.22.155/hitma/mobile/questions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view_chapter1);

        Topic = findViewById(R.id.topic);
        ImageText = findViewById(R.id.image_test);

        back = findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(PdfViewChapter1.this, InecCourseOne.class);
                startActivity(j);
            }
        });


        continu = findViewById(R.id.continu);
//        continu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent j = new Intent(PdfViewChapter1.this, InecCourseOne.class);
//                startActivity(j);
//
////                Intent i = new Intent(PdfViewChapter1.this, Question1.class);
////                startActivity(i);
//            }
//        });

        final ArrayList<String> question_list = new ArrayList<String>();
        final ArrayList<String> optionA_list = new ArrayList<String>();
        final ArrayList<String> optionB_list = new ArrayList<String>();
        final ArrayList<String> optionC_list = new ArrayList<String>();
        final ArrayList<String> optionD_list = new ArrayList<String>();
        final ArrayList<String> correct_option_list = new ArrayList<String>();

        Intent intent = getIntent();
        final String str = intent.getStringExtra("string1");
        final String chapter_name = intent.getStringExtra("chapter_name");
        final String module = intent.getStringExtra("module");
        Topic.setText(str);

        System.out.println("pdf module = "+module);

        //a
        if(str.equals("Professional Ethics of Election Officials")){

            ImageText.setImageResource(R.drawable.pic1);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = getIntent();
                    final String str = intent1.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        j.putExtra("chapter_name", chapter_name);
                                        j.putExtra("module", module);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);

                }
            });
        }



        //b
        if(str.equals("Election Officials and their Duties")){
            ImageText.setImageResource(R.drawable.class1);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //c
        if(str.equals("Persons allowed into the Polling Stations/PollingUnit and Collation Center on Polling day")){
            ImageText.setImageResource(R.drawable.class2);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", "Persons allowed into the Polling Stations/PollingUnit and Collation Center on Polling day");
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //d
        if(str.equals("Role of Security Agents")){
            ImageText.setImageResource(R.drawable.class3);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //e
        if(str.equals("Appointment of Polling Agents")){
            ImageText.setImageResource(R.drawable.class4);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //f
        if(str.equals("Role of Election Observers")){
            ImageText.setImageResource(R.drawable.class5);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //g
        if(str.equals("Role of Accredited Journalists")){
            ImageText.setImageResource(R.drawable.class6);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //h
        if(str.equals("Media Interviews")){
            ImageText.setImageResource(R.drawable.class7);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //i
        if(str.equals("Locating the Polling Unit (PU)")){
            ImageText.setImageResource(R.drawable.class8);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //j
        if(str.equals("Registration Area Centres (RACs)")){
            ImageText.setImageResource(R.drawable.class9);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", str);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

        //k
        if(str.equals("The Election Monitoring and Support Centre (EMSC)")){
            ImageText.setImageResource(R.drawable.class10);
            continu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = getIntent();
                    final String str = intent2.getStringExtra("string1");
                    Topic.setText(str);

                    //send str to the server

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, QUESTION_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        // get JSONObject from JSON file
                                        JSONArray jsonArray = new JSONArray(response);

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //question 1
                                            JSONObject section1 = jsonArray.getJSONObject(i);
                                            String question = section1.getString("question");
                                            String option1 = section1.getString("optionA");
                                            String option2 = section1.getString("optionB");
                                            String option3 = section1.getString("optionC");
                                            String option4 = section1.getString("optionD");
                                            String correct_option = section1.getString("correct_response");

                                            question_list.add(question);
                                            optionA_list.add(option1);
                                            optionB_list.add(option2);
                                            optionC_list.add(option3);
                                            optionD_list.add(option4);
                                            correct_option_list.add(correct_option);

                                        }

                                        //get corresponding response from server and pass que, options and answer as intent to next activity
                                        Intent j = new Intent(PdfViewChapter1.this, Question1.class);
                                        j.putStringArrayListExtra("question_list", question_list);
                                        j.putStringArrayListExtra("optionA_list", optionA_list);
                                        j.putStringArrayListExtra("optionB_list", optionB_list);
                                        j.putStringArrayListExtra("optionC_list", optionC_list);
                                        j.putStringArrayListExtra("optionD_list", optionD_list);
                                        j.putStringArrayListExtra("correct_option_list", correct_option_list);
                                        //pass the name of the course also
                                        j.putExtra("course name", str);
                                        startActivity(j);

//                                        Toast.makeText(PdfViewChapter1.this, "Question list = "+ question_list, Toast.LENGTH_LONG).show();
//                                        System.out.println("Question list = "+ question_list);


                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(PdfViewChapter1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    System.out.print(error.getMessage());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("course", "The Election Monitoring and Support Centre (EMSC)");
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(PdfViewChapter1.this);
                    requestQueue.add(stringRequest);
                }
            });
        }

    }
}
