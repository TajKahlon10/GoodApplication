package com.example.comp7082.comp7082photogallery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BullitenListActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bull_list);

        Context context = getApplicationContext();
        SharedPreferences prefs = getSharedPreferences("Bull_List", MODE_PRIVATE);
       // SharedPreferences.Editor editor = getSharedPreferences("Bull_List", MODE_PRIVATE).edit();
        prefs.edit().putString("count", prefs.getString("count", "0"));
        prefs.edit().apply();

        String name = prefs.getString("count", "No name defined");
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    public void onClickBulliten(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),EditBullitenActivity.class);
        startActivity(i);
    }


    public void onClickPictures(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),Pictures_BullitenListActivity.class);
        startActivity(i);
    }

    @Override
    public void onResume(){
        super.onResume();
        //get count
        //cast to int
        TextView tv =  findViewById(R.id.myList);
        String content = "";
        SharedPreferences prefs = getSharedPreferences("Bull_List", MODE_PRIVATE);
        int n = Integer.parseInt(prefs.getString("count", "0"));
        for(int i=1; i<=n; i++){
            String temp = prefs.getString(""+i, "");
            if(temp.length() > 10){
                temp= temp.substring(0,10);
            }
            content +=  temp;
            content += "\t\t";
            content += prefs.getString(""+i+"currentTime", "?-?-?");
            content += "\n\n";
        }
        tv.setText(content);
    }

}
