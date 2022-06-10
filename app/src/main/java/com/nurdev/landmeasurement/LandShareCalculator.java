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



public class LandShareCalculator extends AppCompatActivity {
    private Button submit;
    private EditText sotangso,length,lengthi;
    private TextView resultxt;
   // private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("ভূমি বিচ্ছেদ ক্যালকুলেটর");
        setContentView(R.layout.activity_land_share_calculator);

 /*       MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/


      /*  mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        submit=(Button)findViewById(R.id.submitId);
        sotangso=(EditText)findViewById(R.id.sotokId);
        length=(EditText)findViewById(R.id.lenthId);
        lengthi=(EditText)findViewById(R.id.lenthiId);
        resultxt=(TextView)findViewById(R.id.resulttextId);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(sotangso.getText().toString()))
                {
                    resultxt.setText("কত শতাংশ ঘরটি খালি রয়েছে !");
                    resultxt.setTextColor(getResources().getColor(R.color.Red));
                } else if(TextUtils.isEmpty(length.getText().toString()))
                {
                    resultxt.setText("এক পাশের দৈর্ঘের ঘরটি খালি রয়েছে !");
                    resultxt.setTextColor(getResources().getColor(R.color.Red));
                }else if(TextUtils.isEmpty(lengthi.getText().toString()))
                {
                    resultxt.setText("এক পাশের দৈর্ঘের ঘরটি খালি রয়েছে !");
                    resultxt.setTextColor(getResources().getColor(R.color.Red));
                }
                else {
                    double bf = Double.parseDouble(sotangso.getText().toString());
                    double f = Double.parseDouble(length.getText().toString());
                    double i = Double.parseDouble(lengthi.getText().toString());
                    double b =bf*435.6*12*12;
                    double d = i+(f*12);
                    double r = b/d;double I = (r%12);
                    double F = ((r-I)/12);

                    resultxt.setText("অন্য পাশের প্রস্থ "+String.format("%.0f",F)+" ফুট , "+String.format("%.0f",I)+" ইঞ্চি ");

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
