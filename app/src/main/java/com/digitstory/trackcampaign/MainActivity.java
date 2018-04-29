package com.digitstory.trackcampaign;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        String utmValues= "utm_source : "+getUtmValues(this,"utm_source")+"\n"+
                "utm_medium : "+getUtmValues(this,"utm_medium")+"\n"+
                "utm_term : "+getUtmValues(this,"utm_term")+"\n"+
                "utm_content : "+getUtmValues(this,"utm_content")+"\n"+
                "utm_campaign : "+getUtmValues(this,"utm_campaign")+"\n";
        textView.setText(utmValues);
    }

    //Get values by key
    public String getUtmValues(Context context,String key){
        String val=null;
        try {
            SharedPreferences preferences = context.getSharedPreferences("utm_campaign", Context.MODE_PRIVATE);
            val = preferences.getString(key, "null");
        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }
}


