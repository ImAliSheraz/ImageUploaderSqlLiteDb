package com.hybird.imageuplodersqllitedb.RecylcerPackage;

import android.graphics.Bitmap;

public class DBModelClass {
    String imageDes;
    Bitmap OurImage;

    public DBModelClass(String imageDes, Bitmap ourImage) {
        this.imageDes = imageDes;
        OurImage = ourImage;
    }

    public void setImageDes(String imageDes) {
        this.imageDes = imageDes;
    }

    public void setOurImage(Bitmap ourImage) {
        OurImage = ourImage;
    }

    public String getImageDes() {
        return imageDes;
    }

    public Bitmap getOurImage() {
        return OurImage;
    }
}












