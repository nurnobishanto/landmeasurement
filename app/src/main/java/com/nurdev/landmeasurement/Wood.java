package com.nurdev.landmeasurement;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class Wood extends AppCompatActivity {
    private Button rbtn,Cbtn;
    private TextView rtxt;
    private EditText lf,li,p,h;
    double fi,in,pr,hi,rs;
  //  private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("সাইজ কাঠের সিএফটি পরিমাপক ");
        setContentView(R.layout.activity_wood);
 /*       MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/

/*
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

*/

        lf=(EditText)findViewById(R.id.lfid);
        li=(EditText)findViewById(R.id.leId);
        p=(EditText)findViewById(R.id.pId);
        h=(EditText)findViewById(R.id.hId);
        rtxt =(TextView)findViewById(R.id.rtId);
        rbtn=(Button)findViewById(R.id.rbtnId);
        Cbtn=(Button)findViewById(R.id.cbtnId);
        Cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lf.setText("");
                li.setText("");
                p.setText("");
                h.setText("");
                rtxt.setText("");
            }

        });
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(lf.getText().toString()))
                {
                    rtxt.setText("দৈর্ঘ্যের ইনপুট-১.১ দেখুন !");

                }else if(TextUtils.isEmpty(li.getText().toString()) ){
                    rtxt.setText("দৈর্ঘ্যের ইনপুট-১.২ দেখুন !");
                }

                else if(TextUtils.isEmpty( p.getText().toString()) )
                {
                    rtxt.setText("প্রস্থের ইনপুট দেখুন !");
                }


                else if(TextUtils.isEmpty(h.getText().toString()) )
                {
                    rtxt.setText("উচ্চতা  ইনপুট দেখুন !");
                }

                else {

                    fi =Double.parseDouble(lf.getText().toString());
                    in =Double.parseDouble(li.getText().toString());
                    pr =Double.parseDouble(p.getText().toString());
                    hi =Double.parseDouble(h.getText().toString());
                    rs =((((fi*12)+in)*pr*hi)/1728);
                    rtxt.setText(String.format("%.2f",rs)+" সিএফটি");

                }

            }

        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
