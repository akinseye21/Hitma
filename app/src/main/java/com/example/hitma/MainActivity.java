package com.example.hitma;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    protected static final int Timer_Runtime=3000;
    protected boolean mbActive;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Timer
        mProgressBar = findViewById(R.id.progressBar2);

        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                mbActive = true;
                try{
                    int waited = 0;
                    while(mbActive && (waited < Timer_Runtime)){
                        sleep(200);
                        if (mbActive){
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                }catch(InterruptedException e){
                    //error
                }finally{
                    onContinue();
                }
            }
        };
        timerThread.start();

    }

    public void updateProgress(final int timePassed){
        if (null != mProgressBar){

            final int progress = mProgressBar.getMax() * timePassed / Timer_Runtime;
            mProgressBar.setProgress(progress);
        }
    }

    public void onContinue(){
        Intent i = new Intent(this, ItmaLogin.class);
        startActivity(i);

    }
}
