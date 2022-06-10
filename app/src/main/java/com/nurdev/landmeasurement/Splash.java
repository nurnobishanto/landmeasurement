package com.nurdev.landmeasurement;



import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nurdev.landmeasurement.R;

public class Splash extends AppCompatActivity {
    float i;
    String s;
    public TextView splashTesxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);




        splashTesxt =(TextView)findViewById(R.id.SpashtextId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();



            }
        });
        thread.start();

    }
    public void doWork()
    {
        for (i=0;i<1;i+=0.01)
        {
            try {
                Thread.sleep(25);
                splashTesxt.setScaleX(i);
                splashTesxt.setScaleY(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}


