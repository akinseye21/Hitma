package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ItmaSignupPage1 extends AppCompatActivity {

    String fullname, email, phone, password, confirm_pword;
    EditText name, mail, number, pword, confirmpword;
    String flag = "register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itma_signup_page1);

        name = findViewById(R.id.full_name);
        mail = findViewById(R.id.email);
        number = findViewById(R.id.phone);
        pword = findViewById(R.id.pword);
        confirmpword = findViewById(R.id.confirmpword);


        Button signUp = findViewById(R.id.btnNext);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullname = name.getText().toString().trim();
                email = mail.getText().toString().trim();
                phone = number.getText().toString().trim();
                password = pword.getText().toString().trim();
                confirm_pword = confirmpword.getText().toString().trim();

                if (fullname.equals("") && email.equals("") && phone.equals("") && password.equals("")){
                    name.setError("Check your input");
                    mail.setError("Check your input");
                    number.setError("Check your input");
                    pword.setError("Check your input");
                }
                else if (fullname.equals("")){
                    name.setError("Check your input");
                }
                else if (email.equals("")){
                    mail.setError("Check your input");
                }
                else if (phone.equals("")){
                    number.setError("Check your input");
                }
                else if (password.equals("")){
                    pword.setError("Check your input");
                }
                else if (!password.equals(confirm_pword)){
                    pword.setError("Password do not match");
                    confirmpword.setError("Password do not match");
                }
                else{
                    Intent i = new Intent(ItmaSignupPage1.this, ItmaSignupPage2.class);
                    i.putExtra("name", fullname);
                    i.putExtra("email", email);
                    i.putExtra("number", phone);
                    i.putExtra("pword", password);
                    i.putExtra("flag", flag);
                    startActivity(i);
                }


            }
        });
    }
}
