package com.example.comp7082.comp7082photogallery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.comp7082.comp7082photogallery.MainActivity.REQUEST_TAKE_PHOTO;


public class EditBullitenActivity extends AppCompatActivity{

    public String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bulliten);
        Date currentTime = Calendar.getInstance().getTime();
        setDate((TextView)findViewById(R.id.textView6));
    }

    public void onSnapClicked(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        toggleCaptionEditVisibility(View.INVISIBLE);
        //enableLocationUpdates();    // begin scanning for location upon taking a photo
        Log.d("onSnapClicked", "Begin capturing a photo");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this,
                        "Photo file can't be created, please try again",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.comp7082.comp7082photogallery.provider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private void toggleCaptionEditVisibility(int viewVisibility) {
        Button saveButton = (Button)findViewById(R.id.button_save_id);
        saveButton.setVisibility(viewVisibility);
        EditText text1 = (EditText)findViewById(R.id.edit_text1);
        text1.setVisibility(viewVisibility);
        if (viewVisibility != View.VISIBLE) {
            text1.setText("");  // ensure to clear it out
        }
    }

    public int toggleBullyItems(int viewVisibility) {
        if(viewVisibility != 303){
        //Button saveButton = (Button)findViewById(R.id.button_save_id);
       // saveButton.setVisibility(viewVisibility);
        //EditText text1 = (EditText)findViewById(R.id.edit_text1);
       //text1.setVisibility(viewVisibility);
        if (viewVisibility != View.VISIBLE) {
        //    text1.setText("");  // ensure to clear it out
        }
        return 35;
        }
        else{ return 0;}
    }



    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/BullyBoard");
        Context context = getApplicationContext();
        Toast.makeText(context, storageDir.toString(), Toast.LENGTH_SHORT).show();
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }


    public void setDate (TextView view){
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }

    public void saveBullListItem(View v){
        String comment = ((EditText) findViewById(R.id.editText3)).getText().toString();
        SharedPreferences prefs = getSharedPreferences("Bull_List", MODE_PRIVATE);
        // SharedPreferences.Editor editor = getSharedPreferences("Bull_List", MODE_PRIVATE).edit();
        int index = Integer.parseInt(prefs.getString("count", "0")) + 1;

        Date currentTime = Calendar.getInstance().getTime();
        SharedPreferences.Editor editor = getSharedPreferences("Bull_List", MODE_PRIVATE).edit();
        editor.putString("" + index + "currentTime", currentTime.toString());
        editor.putString("" + index, comment);
        editor.putString("count", ""+index);
        editor.apply();

        Intent i = new Intent(getApplicationContext(),BullitenListActivity.class);
        startActivity(i);
    }

}
