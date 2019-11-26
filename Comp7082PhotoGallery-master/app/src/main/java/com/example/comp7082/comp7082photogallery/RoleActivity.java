package com.example.comp7082.comp7082photogallery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RoleActivity extends AppCompatActivity
{       @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        Context context = getApplicationContext();


        String filePath = Environment.getExternalStorageDirectory() + "/" + File.separator + "test.txt";
        File file = new File(filePath);
        if(file.exists())
            Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();

        SharedPreferences prefs = getSharedPreferences("Role", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");
        Toast.makeText(context, name, Toast.LENGTH_LONG).show();

        //if(name == "Elena"){
            //Intent i = new Intent(getApplicationContext(),MainActivity.class);
            //startActivity(i);
        //}

        }



    public void onClickTeacher(View v)
    {
        /*
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + File.separator + "test.txt");
            file.mkdirs();
            file.createNewFile();
            Context context = getApplicationContext();
            Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();
            byte[] data1 = {1, 1, 0, 0};
            //write the bytes in file
            if (file.exists()) {
                OutputStream fo = new FileOutputStream(file);
                fo.write(data1);
                fo.close();
                System.out.println("file created: " + file);
            }
        }catch  (IOException ioe)
        {

            Context context = getApplicationContext();
            Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
            ioe.printStackTrace();}
        */

        SharedPreferences.Editor editor = getSharedPreferences("Role", MODE_PRIVATE).edit();
        editor.putString("name", "Teacher");
        editor.apply();

        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }

    public void onClickParent(View v)
    {
        SharedPreferences.Editor editor = getSharedPreferences("Role", MODE_PRIVATE).edit();
        editor.putString("name", "Parent");
        editor.apply();
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),ParentActivity.class);
        startActivity(i);
    }
}
