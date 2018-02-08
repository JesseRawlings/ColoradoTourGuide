package com.example.android.coloradotourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by JesseRawlings on 11/6/17.
 */

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //create new list of restaurants
        final ArrayList<Place> restaurants = new ArrayList<Place>();
        restaurants.add(new Place(getString(R.string.rootdownrestaurantname), getString(R.string.rootdownrestaurantdescription), R.drawable.rootdownrestaurant));
        restaurants.add(new Place(getString(R.string.sushidenrestaurantname), getString(R.string.sushidenrestaurantdescription), R.drawable.sushidenrestaurant));
        restaurants.add(new Place(getString(R.string.snoozerestaurantname), getString(R.string.snoozerestaurantdescription), R.drawable.snoozerestaurant));
        restaurants.add(new Place(getString(R.string.lingerrestaurantname), getString(R.string.lingerrestaurantdescription), R.drawable.lingerrestaurant));
        restaurants.add(new Place(getString(R.string.amblirestaurantname), getString(R.string.amblirestaurantdescription), R.drawable.amblirestaurant));
        restaurants.add(new Place(getString(R.string.riojarestaurantname), getString(R.string.riojarestaurantdescription), R.drawable.riojarestaurant));
        restaurants.add(new Place(getString(R.string.oceanprimerestaurantname), getString(R.string.oceanprimerestaurantdescription), R.drawable.oceanprimerestaurant));

        //create an adapter for the restaurant list
        PlaceAdapter placeAdapter = new PlaceAdapter(RestaurantsActivity.this, restaurants);

        ListView listView = (ListView) findViewById(R.id.list);

        //hook up the adapter and listView
        listView.setAdapter(placeAdapter);

        //Make each restaurant clickable to start the info activity. send correct data with intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = restaurants.get(position);
                Intent intent = new Intent(RestaurantsActivity.this,Information.class);
                intent.putExtra(getString(R.string.intentplaceimage), place.getImageResourseId());
                intent.putExtra(getString(R.string.intentplacedescription), place.getDescription());
                intent.putExtra(getString(R.string.intentplacename), place.getName());
                startActivity(intent);
            }
        });
    }

}
