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


public class Wood2Activity extends AppCompatActivity {
    private Button rbtn,Cbtn;
    private TextView rtxt;
    private EditText lf,li,bf,bi;
    double fi,in,pr,hi,rs;
   // private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("গোল কাঠের সিএফটি পরিমাপক ");
        setContentView(R.layout.activity_wood2);
  /*      MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/

      /*  mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        lf=(EditText)findViewById(R.id.lfid);
        bf=(EditText)findViewById(R.id.bfid);
        li=(EditText)findViewById(R.id.leId);
        bi=(EditText)findViewById(R.id.beId);

        rtxt =(TextView)findViewById(R.id.rtId);
        rbtn=(Button)findViewById(R.id.rbtnId);
        Cbtn=(Button)findViewById(R.id.cbtnId);
        Cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lf.setText("");
                bf.setText("");
                li.setText("");
                bi.setText("");

                rtxt.setText("");
            }

        });
        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(lf.getText().toString()))
                {
                    rtxt.setText("দৈর্ঘ্যের ফুটের ইনপুট দেখুন !");

                }
                else if(TextUtils.isEmpty(li.getText().toString()) ){
                    rtxt.setText("দৈর্ঘ্যের ইঞ্চির ইনপুট দেখুন !");
                }
                else if(TextUtils.isEmpty(bf.getText().toString()) ){
                    rtxt.setText("বেড়ের ফুটের ইনপুট দেখুন !");
                }
                else if(TextUtils.isEmpty(bi.getText().toString()) ){
                    rtxt.setText("বেড়ের ইঞ্চির ইনপুট দেখুন !");
                }




                else {

                    fi =Double.parseDouble(lf.getText().toString());
                    in =Double.parseDouble(li.getText().toString());

                    pr =Double.parseDouble(bf.getText().toString());
                    hi =Double.parseDouble(bi.getText().toString());
                    rs =((((fi*12)+in)*((pr*12)+hi)*((pr*12)+hi))/27648);
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
