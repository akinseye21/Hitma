package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ItmaSignupPage2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    RadioGroup radioGroup;
    RadioButton radioButton;
    Button signUp;
    EditText date;
    String dob, states, fullname, email, phone, password, applicant_type, u_gender;           //to be passed to server
    Spinner state, gender;
    String flag;
    private ProgressDialog progressDialog;

    public static final String UPDATE_URL = "http://35.84.44.203/hitma/mobile/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itma_signup_page2);

        progressDialog = new ProgressDialog(this);

        //get passed values
        Intent intent = getIntent();

        flag = intent.getStringExtra("flag");
        fullname = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        phone = intent.getStringExtra("number");
        password = intent.getStringExtra("pword");

        //Toast.makeText(getApplicationContext(), fullname+" "+email+" "+phone+" "+password, Toast.LENGTH_LONG).show();

        date = findViewById(R.id.edtDate);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        state = findViewById(R.id.states);
        gender = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.states,R.layout.spinner_item_states);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.gender,R.layout.spinner_item_states);

        state.setAdapter(adapter);
        gender.setAdapter(adapter2);
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                states = state.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                u_gender = gender.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        radioGroup = findViewById(R.id.radioGrp);

        signUp = findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.setMessage("Registering. Please wait!");
                progressDialog.show();

                checkButton();            //calls the method checkButton()

                //send all fields to the server
                StringRequest stringRequest = new StringRequest(Request.Method.POST, UPDATE_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                progressDialog.dismiss();
//                                System.out.println("Response = "+response);
//                                Toast.makeText(getApplicationContext(), "Response = "+response, Toast.LENGTH_LONG).show();

                                try{

                                    JSONObject jsonObject = new JSONObject(response);
                                    String stats = jsonObject.getString("status");

                                    if (stats.equals("register successful")){
                                        System.out.print(stats);
                                        Toast.makeText(ItmaSignupPage2.this, "Registered Successfully", Toast.LENGTH_LONG).show();

                                        Intent i = new Intent(ItmaSignupPage2.this, ItmaDashboard.class);               //start new activity
                                        startActivity(i);
                                    }else{
                                        Toast.makeText(ItmaSignupPage2.this, "Unsuccessful, please try again", Toast.LENGTH_LONG).show();
                                        System.out.print(stats);
                                    }

                                }catch (JSONException e){
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                progressDialog.dismiss();

                                Toast.makeText(ItmaSignupPage2.this, "Network Error, Please try again", Toast.LENGTH_LONG).show();
                                System.out.print(error.getMessage());
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("fullname", fullname);
                        params.put("email", email);
                        params.put("phone", phone);
                        params.put("password", password);
                        params.put("dob", dob);
                        params.put("states", states);
                        params.put("gender", u_gender);
                        params.put("applicant_type", applicant_type);
                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(ItmaSignupPage2.this);
                requestQueue.add(stringRequest);

            }
        });


    }

    private void checkButton() {
        // get text on dob
        dob = date.getText().toString();

        //get text on states


        //get text on applicant type
        int radioID = radioGroup.getCheckedRadioButtonId();                                                 //checks the checked button in the radiogroup and store in var
        radioButton = findViewById(radioID);
        applicant_type = (String) radioButton.getText();
        //Toast.makeText(this, "RadioButton: "+applicant_type+ "\n State: "+states+ "\n dob: "+dob, Toast.LENGTH_LONG ).show();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c = Calendar.getInstance();                                                                //process of opening date picker
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        date.setText(currentDate);
    }
}
