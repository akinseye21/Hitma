package com.example.hitma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InecCourseOne extends AppCompatActivity {

    RelativeLayout test1, test2, test3, test4, test5, test6, test7, test8, test9, test10, test11;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11;
    String str1;
    String module1, module2, module3;
    int count = 0;

    private String[] chap1courses = new String[11];

    ImageView backPressed;
    String HomeStat = "true";
    String HomeStatStay = "stay";
    String HomeStatPrev = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inec_course_one);

        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.text2);
        txt3 = findViewById(R.id.text3);
        txt4 = findViewById(R.id.text4);
        txt5 = findViewById(R.id.text5);
        txt6 = findViewById(R.id.text6);
        txt7 = findViewById(R.id.text7);
        txt8 = findViewById(R.id.text8);
        txt9 = findViewById(R.id.text9);
        txt10 = findViewById(R.id.text10);
        txt11 = findViewById(R.id.text11);

        module1 = "Election Officials";
        module2 = "Other Stakeholders";
        module3 = "Preparing For The Poll";

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

        Intent mm = getIntent();
        String statme = mm.getExtras().getString("stats");
        final String course_chapter = mm.getExtras().getString("chapter_name");
        String courseName = mm.getExtras().getString("courseName");

        System.out.println("Status = "+statme);
        System.out.println("CourseName = "+courseName);


        backPressed = findViewById(R.id.backbtn);
        backPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InecCourseOne.this, ItmaDashboard.class);
                startActivity(i);
            }
        });


        if (HomeStat.equals(statme)){

            if (courseName.equals(chap1courses[0])){
                // goto 2
                str1 = chap1courses[1];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[1]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[1])){
                // goto 2
                str1 = chap1courses[2];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[2]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[2])){
                // goto 2
                str1 = chap1courses[3];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[3]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[3])){
                // goto 2
                str1 = chap1courses[4];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[4]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[4])){
                // goto 2
                str1 = chap1courses[5];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[5]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[5])){
                // goto 2
                str1 = chap1courses[6];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[6]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[6])){
                // goto 2
                str1 = chap1courses[7];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[7]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[7])){
                // goto 2
                str1 = chap1courses[8];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[8]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[8])){
                // goto 2
                str1 = chap1courses[9];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[9]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[9])){
                // goto 2
                str1 = chap1courses[10];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[10]);
                i.putExtra("module", module1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[10])){
                //goto 11

                str1 = chap1courses[11];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                i.putExtra("chapter_name", chap1courses[11]);
                i.putExtra("module", module1);
                startActivity(i);
            }

        }



        if (HomeStatStay.equals(statme)){

            if (courseName.equals(chap1courses[0])){
                // goto 2
                str1 = chap1courses[0];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[1])){
                // goto 2
                str1 = chap1courses[1];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[2])){
                // goto 2
                str1 = chap1courses[2];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[3])){
                // goto 2
                str1 = chap1courses[3];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[4])){
                // goto 2
                str1 = chap1courses[4];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[5])){
                // goto 2
                str1 = chap1courses[5];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[6])){
                // goto 2
                str1 = chap1courses[6];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[7])){
                // goto 2
                str1 = chap1courses[7];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[8])){
                // goto 2
                str1 = chap1courses[8];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[9])){
                // goto 2
                str1 = chap1courses[9];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }
            if (courseName.equals(chap1courses[10])){
                //goto 11

                str1 = chap1courses[10];

                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                i.putExtra("string1", str1);
                startActivity(i);
            }

        }




        if (HomeStatPrev.equals(statme)){
            // stay in the activity

            test1 = findViewById(R.id.test1);
            test1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    str1 = txt1.getText().toString();

                    Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
                    i.putExtra("string1", str1);
                    i.putExtra("chapter_name", course_chapter);
                    i.putExtra("module", module1);
                    startActivity(i);
                }
            });



            test2 = findViewById(R.id.test2);
            test2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //this section should be locked. output a popup


//                str1 = txt2.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test3 = findViewById(R.id.test3);
            test3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt3.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test4 = findViewById(R.id.test4);
            test4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //this section should be locked. output a popup

//                str1 = txt4.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test5 = findViewById(R.id.test5);
            test5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt5.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test6 = findViewById(R.id.test6);
            test6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt6.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test7 = findViewById(R.id.test7);
            test7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt7.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test8 = findViewById(R.id.test8);
            test8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt8.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test9 = findViewById(R.id.test9);
            test9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt9.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test10 = findViewById(R.id.test10);
            test10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt10.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

            test11 = findViewById(R.id.test11);
            test11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this section should be locked. output a popup

//                str1 = txt11.getText().toString();
//
//                Intent i = new Intent(InecCourseOne.this, PdfViewChapter1.class);
//                i.putExtra("string1", str1);
//                startActivity(i);
                }
            });

        }

    }
}
