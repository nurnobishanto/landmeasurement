package com.nurdev.landmeasurement;



import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class UnitCalculator extends AppCompatActivity {
    private Button smt;
    private TextView price;
    private EditText dor,dam;
   // private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("মূল্য ক্যালকুলেটর");
        setContentView(R.layout.activity_unit_calculator);

/*        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/

     /*   mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        smt =(Button)findViewById(R.id.sorbomutId);
        price =(TextView) findViewById(R.id.priceId);
        dor =(EditText) findViewById(R.id.dorId);
        dam =(EditText) findViewById(R.id.damId);
        smt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dr,dm;
                if(!dor.getText().toString().isEmpty()){
                     dr= Double.parseDouble(dor.getText().toString());
                }else {
                     dr = 0.0;
                }
                if(!dam.getText().toString().isEmpty()){
                     dm= Double.parseDouble(dam.getText().toString());
                }else {
                     dm=0.0;
                }

                price.setText(String.format("%.2f",dr*dm)+" টাকা");

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
