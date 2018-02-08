package com.example.android.coloradotourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JesseRawlings on 11/7/17.
 */

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        //Retrieve imageID, description and name from intent
        Intent intent = getIntent();
        int imageID = intent.getIntExtra(getString(R.string.intentplaceimage), 0);
        String description = intent.getStringExtra(getString(R.string.intentplacedescription));
        String name = intent.getStringExtra(getString(R.string.intentplacename));

        //Set info image to correct image from intent
        ImageView infoImage = (ImageView) findViewById(R.id.info_image);
        infoImage.setImageResource(imageID);

        //Set info description to correct description from intent
        TextView infoDescription = (TextView) findViewById(R.id.info_description);
        infoDescription.setText(description);

        //Set info name to correct name from intent
        TextView infoName = (TextView) findViewById(R.id.info_name);
        infoName.setText(name);


    }
}
