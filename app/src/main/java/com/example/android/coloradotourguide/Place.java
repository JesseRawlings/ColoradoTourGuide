package com.example.android.coloradotourguide;

/**
 * Created by JesseRawlings on 11/7/17.
 */

public class Place {

    //Name of location
    private String mName;
    //Description of location
    private String mDescription;
    //Image associated with location
    private int mImageResourseId;


    //Constructor to initialize a new place object. Requires name, description and image ID
    public Place(String name, String description, int imageResourseId) {
        mName = name;
        mDescription = description;
        mImageResourseId = imageResourseId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImageResourseId() {
        return mImageResourseId;
    }

    public String getDescription() {
        return mDescription;
    }

}
