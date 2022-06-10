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




public class LandCalculator extends AppCompatActivity {
    private EditText l1f,l1e,l2f,l2e,p1f,p1e,p2f,p2e;
    private TextView error,result;
    private Button resultbtn,clearbtn;
    double len1F,len2F,len1i,len2i,pr1f,pr1i,pr2f,pr2i,khetrofol,LengthF,LengthI,ProF,ProI;
   // private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("ভূমি পরিমাপ ক্যালকুলেটর");
        setContentView(R.layout.activity_land_calculator);
   /*     MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/

       /* mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        result =(TextView)findViewById(R.id.resultId) ;
        error =(TextView)findViewById(R.id.errorId);
        l1f=(EditText)findViewById(R.id.l1fId);
        l1e=(EditText)findViewById(R.id.l1eId);
        l2f=(EditText)findViewById(R.id.l2fId);
        l2e=(EditText)findViewById(R.id.l2eId);
        p1f=(EditText)findViewById(R.id.p1fId);
        p1e=(EditText)findViewById(R.id.p1eId);
        p2f=(EditText)findViewById(R.id.p2fId);
        p2e=(EditText)findViewById(R.id.p2eId);

        resultbtn=(Button)findViewById(R.id.resulbtnId);
        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(l1f.getText().toString()))
                {
                    error.setText("দৈর্ঘ্যের ইনপুট-১.১ দেখুন !");

                }else if(TextUtils.isEmpty(l1e.getText().toString()) ){
                    error.setText("দৈর্ঘ্যের ইনপুট-১.২ দেখুন !");
                }else if(TextUtils.isEmpty(l2f.getText().toString()) ){
                    error.setText("দৈর্ঘ্যের ইনপুট-২.১ দেখুন !");
                }

                else if(TextUtils.isEmpty(l2e.getText().toString()) )
                {
                    error.setText("দৈর্ঘ্যের ইনপুট-২.২ দেখুন !");
                }

                else if(TextUtils.isEmpty( p1f.getText().toString()) )
                {
                    error.setText("প্রস্থের ইনপুট-১.১ দেখুন !");
                }
                else if(TextUtils.isEmpty(p1e.getText().toString()) )
                {
                    error.setText("প্রস্থের ইনপুট-১.২ দেখুন !");
                }

                else if(TextUtils.isEmpty(p2f.getText().toString()) )
                {
                    error.setText("প্রস্থের ইনপুট-২.১ দেখুন !");
                }
                else if(TextUtils.isEmpty(p2e.getText().toString()))
                {
                    error.setText("প্রস্থের ইনপুট-২.২ দেখুন !");
                }
                else {
                    len1F = Double.parseDouble(l1f.getText().toString()) ;
                    len2F = Double.parseDouble(l2f.getText().toString()) ;
                    len2i = Double.parseDouble(l2e.getText().toString()) ;
                    len1i = Double.parseDouble(l1e.getText().toString()) ;

                    pr1f = Double.parseDouble(p1f.getText().toString()) ;
                    pr2f = Double.parseDouble(p2f.getText().toString()) ;
                    pr2i = Double.parseDouble(p2e.getText().toString()) ;
                    pr1i = Double.parseDouble(p1e.getText().toString()) ;

                    LengthF =(len1F+len2F)/2;
                    LengthI =((len1i+len2i)/2)/12;
                    ProF =(pr1f+pr2f)/2;
                    ProI=((pr1i+pr2i)/2)/12;
                    khetrofol = (LengthF+LengthI)*(ProF+ProI);


                    error.setText("");
                    result.setText("ক্ষেত্রফল : "+String.format("%.2f",khetrofol)+" বর্গ ফুট\n" +
                            String.format("%.2f",khetrofol/435.6)+" শতাংশ\n"+
                            String.format("%.2f",khetrofol/762.3)+" কাঠা (৩৫ এর মাপে (1.75) )\n"+
                            String.format("%.2f",khetrofol/718.74)+" কাঠা (৩৩ এর মাপে (1.65) )\n"+
                            String.format("%.2f",khetrofol/653.4)+" কাঠা (৩০ এর মাপে (1.50) )\n"+
                            String.format("%.2f",khetrofol/71874.0)+" একর (৩৩ এর মাপে (1.65) )\n"+
                            String.format("%.2f",(khetrofol/71874.0)*3.03)+" বিঘা (৩৩ এর মাপে (1.65) )"

                    );
                }




            }
        });

        clearbtn =(Button)findViewById(R.id.clearbtnId);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1f.setText("");
                l1e.setText("");
                l2f.setText("");
                l2e.setText("");
                p1f.setText("");
                p1e.setText("");
                p2f.setText("");
                p2e.setText("");
                result.setText("");
                error.setText("");
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
