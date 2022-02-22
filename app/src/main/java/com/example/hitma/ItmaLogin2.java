package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ItmaLogin2 extends AppCompatActivity {

    TextView forgotPword;
    Button Login;
    EditText username, pword;
    String email, password;
    private CheckBox mCheckBoxRemember;
    private SharedPreferences mPrefs;
    private static final String PREFS_NAME = "PrefsFile";

    private ProgressDialog progressDialog;

    public static final String LOGIN_URL = "http://35.84.44.203/hitma/mobile/inec_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itma_login2);

        progressDialog = new ProgressDialog(this);
        mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        mCheckBoxRemember = findViewById(R.id.checkBoxRememberMe);
        username = findViewById(R.id.username);
        pword = findViewById(R.id.pword);


        forgotPword = findViewById(R.id.txtForgotPassword);
        forgotPword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ItmaLogin2.this, ForgotPassword.class);
                startActivity(i);
            }
        });

        Login = findViewById(R.id.btnLog);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.setMessage("Logging in...");
                progressDialog.show();

                //get all fields (username and password)
                email = username.getText().toString().trim();
                password = pword.getText().toString().trim();

                if(mCheckBoxRemember.isChecked()){
                    Boolean boolIsChecked = mCheckBoxRemember.isChecked();
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString("pref_name", email);
                    editor.putString("pref_pass", password);
                    editor.putBoolean("pref_check", boolIsChecked);
                    editor.apply();
                }else{
                    mPrefs.edit().clear().apply();
                }


                if (!TextUtils.isEmpty(email) && email.length()<100 && !TextUtils.isEmpty(password) ){
                    //send fields to server

//                    JSONObject object = new JSONObject();
//                    try{
//                        //input parameters
//                        object.put("email", email);
//                        object.put("password", password);
//                    } catch (JSONException e){
//                        e.printStackTrace();
//                    }
//
//                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                            (Request.Method.POST, LOGIN_URL, object, new Response.Listener<JSONObject>() {
//                                @Override
//                                public void onResponse(JSONObject response) {
//                                    Toast.makeText(getApplicationContext(), "response 1 = "+response, Toast.LENGTH_LONG).show();
//                                    System.out.println("Response 1 = "+response);
//                                }
//                            }, new Response.ErrorListener() {
//                                @Override
//                                public void onErrorResponse(VolleyError error) {
//                                    NetworkResponse statusCode = error.networkResponse;
//                                    Toast.makeText(getApplicationContext(), "response 2 = "+statusCode, Toast.LENGTH_LONG).show();
//                                    System.out.println("Response 2 = "+statusCode);
//                                }
//                            });
//                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//                    requestQueue.add(jsonObjectRequest);

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    progressDialog.dismiss();
                                    //Toast.makeText(getApplicationContext(), "response = "+response, Toast.LENGTH_LONG).show();
                                    System.out.println("Response = "+response);

                                    try{

                                        // get JSONObject from JSON file
                                        JSONObject jsonObject = new JSONObject(response);
                                        String login_status = jsonObject.getString("status");
                                        String email_add = jsonObject.getString("email");

                                        //using shared preference to store email to be used anywhere
                                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = pref.edit();
                                        editor.putString("email", email_add);
                                        editor.apply();

                                        if (login_status.equals("inec login successful")){
                                            //enter the app
                                            Intent j = new Intent(ItmaLogin2.this, ItmaDashboard.class);
                                            j.putExtra("email", email_add);
                                            startActivity(j);
                                        }
                                        else{
                                            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
//                                            System.out.println("Response = "+response);
//                                            Intent j = new Intent(ItmaLogin2.this, ItmaDashboard.class);
//                                            startActivity(j);
                                        }

                                    }catch (JSONException e){
                                        e.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "Wrong Login", Toast.LENGTH_LONG).show();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                    progressDialog.dismiss();

                                    Toast.makeText(ItmaLogin2.this, "Failed2 "+error.getClass(), Toast.LENGTH_LONG).show();
                                    System.out.print("error response = "+error.getClass());
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams(){
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("email", email);
                            params.put("password", password);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(ItmaLogin2.this);
//                    DefaultRetryPolicy retryPolicy = new DefaultRetryPolicy(50000, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//                    stringRequest.setRetryPolicy(retryPolicy);
                    requestQueue.add(stringRequest);


                }else{

                    progressDialog.dismiss();

                    //check for emptyness
                    if(TextUtils.isEmpty(email) || email.length()>20){
                        username.setError("Please check your input");
                    }

                    if(TextUtils.isEmpty(password) || password.length()>20 || password.length()<5){
                        pword.setError("Please check your input");
                    }

                }

            }
        });
        getPreferencesData();
    }

    private void getPreferencesData() {
        SharedPreferences sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        if(sp.contains("pref_name")){
            String u = sp.getString("pref_name", "not found");
            username.setText(u.toString());
        }

        if(sp.contains("pref_pass")){
            String p = sp.getString("pref_pass", "not found");
            pword.setText(p.toString());
        }

        if(sp.contains("pref_check")){
            Boolean b = sp.getBoolean("pref_check", false);
            mCheckBoxRemember.setChecked(b);
        }
    }
}
