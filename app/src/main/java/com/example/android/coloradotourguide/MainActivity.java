package com.example.android.coloradotourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set each Relative layout as a listener that will launch the corresponding activity

        RelativeLayout lakesActivity = (RelativeLayout) findViewById(R.id.lakes_activity);
        lakesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LakesActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout breweriesActivity = (RelativeLayout) findViewById(R.id.breweries_activity);
        breweriesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BreweriesActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout restaurantsActivity = (RelativeLayout) findViewById(R.id.restaurants_activity);
        restaurantsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout attractionsActivity = (RelativeLayout) findViewById(R.id.attractions_activity);
        attractionsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AttractionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
