package com.example.comp7082.comp7082photogallery;

import java.io.File;

public class PictureFile extends File{

    private String dm;

    PictureFile(String filename){
        super(filename);
        dm = filename;
    }

    public String getCaptionText(){
        return ExifUtility.getExifTagString(this, ExifUtility.EXIF_CAPTION_TAG);

    }

    public void setCaptionText(String comment){
        ExifUtility.setExifTagString(this, ExifUtility.EXIF_CAPTION_TAG, comment);
    }

}
