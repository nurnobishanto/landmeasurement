package com.nurdev.landmeasurement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MoreApps extends AppCompatActivity {
    GridView gridView;
   // private AdView mAdView;
    private ProgressDialog pd;
    String catname,catid;
    CustomAdapter adapter;
    List<ItemsModel> itemsModelList = new ArrayList<>();
    ProgressBar pb;
    TextView notice;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_more_apps);
    /*    MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });*/
/*
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        gridView= findViewById(R.id.gridview1);
        requestQueue = Volley.newRequestQueue(this);
        pb= findViewById(R.id.pbar);
        notice= findViewById(R.id.notice);
        notice.setVisibility(View.GONE);
        deleteCache(MoreApps.this);
        getJSONandLoad("https://app.techzweb.com/api.php?moreapps");


    }
    private void getJSONandLoad(String url) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("TechZwebApp");
                    String[] name, version,icon,pid,url;
                    name = new String[jsonArray.length()];
                    version = new String[jsonArray.length()];
                    icon = new String[jsonArray.length()];
                    pid = new String[jsonArray.length()];
                    url = new String[jsonArray.length()];

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        name[i] = obj.getString("name");
                        version[i] = obj.getString("version");
                        icon[i] = obj.getString("icon");
                        pid[i] = obj.getString("package");
                        url[i] = obj.getString("link");

                        ItemsModel itemsModel = new ItemsModel(name[i],icon[i],url[i],version[i],pid[i]);
                        itemsModelList.add(itemsModel);
                    }
                    adapter = new CustomAdapter(itemsModelList,MoreApps.this);
                    gridView.setAdapter(adapter);
                    pb.setVisibility(View.GONE);
                    if(jsonArray.length()==0){
                        notice.setVisibility(View.VISIBLE);
                    }else {
                        notice.setVisibility(View.GONE);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                pb.setVisibility(View.GONE);
                notice.setVisibility(View.VISIBLE);
                notice.setText("No Internet Connection !");
            }
        });

        requestQueue.add(request);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Toast.makeText(this,String.valueOf(item.getItemId()),Toast.LENGTH_LONG).show();
        if(item.getItemId()==16908332){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

}