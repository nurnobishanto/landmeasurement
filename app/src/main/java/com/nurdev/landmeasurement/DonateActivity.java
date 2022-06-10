package com.nurdev.landmeasurement;



import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


public class DonateActivity extends AppCompatActivity {
    //private AdView mAdView;
    ListView listView;
    private RequestQueue requestQueue;
    CustomAdapter adapter;
    List<ItemsModel> itemsModelList = new ArrayList<>();
    ProgressBar pb;
    TextView notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("কিভাবে পরিমাপ করবেন ?");
        setContentView(R.layout.activity_donate);

        pb= findViewById(R.id.pbar);
        notice= findViewById(R.id.notice);
        notice.setVisibility(View.GONE);
        listView= findViewById(R.id.lisId);
        requestQueue = Volley.newRequestQueue(this);
        deleteCache(DonateActivity.this);
        getJSONandLoad("https://app.techzweb.com/api.php?bnmeasurementappusermannual");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
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
                        name[i] = obj.getString("title");
                        version[i] = "";
                        icon[i] = obj.getString("image");
                        pid[i] = obj.getString("app_name");
                        url[i] = obj.getString("url");

                        ItemsModel itemsModel = new ItemsModel(name[i],icon[i],url[i],version[i],pid[i]);
                        itemsModelList.add(itemsModel);
                    }
                    adapter = new CustomAdapter(itemsModelList,DonateActivity.this);
                    listView.setAdapter(adapter);
                    pb.setVisibility(View.GONE);
                    if(jsonArray.length()==0){
                        notice.setVisibility(View.VISIBLE);
                    }else {
                        notice.setVisibility(View.GONE);

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    pb.setVisibility(View.GONE);
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
}
