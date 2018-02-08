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

public class BreweriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Create a new list of breweries
        final ArrayList<Place> breweries = new ArrayList<Place>();
        breweries.add(new Place(getString(R.string.tenbarrelbrewername), getString(R.string.tenbarrelbrewerydescription), R.drawable.tenbarrelbrewery));
        breweries.add(new Place(getString(R.string.avalanchebreweryname), getString(R.string.avalanchebrewerydescription), R.drawable.avalanchebrewery));
        breweries.add(new Place(getString(R.string.averybrewereryname), getString(R.string.averybrewererydescription), R.drawable.averybrewery));
        breweries.add(new Place(getString(R.string.bluemoonbreweryname), getString(R.string.bluemoonbrewerydescription), R.drawable.bluemoonbrewery));
        breweries.add(new Place(getString(R.string.breckenridgebreweryname), getString(R.string.breckenridgebrewerydescription), R.drawable.breckenridgebrewery));
        breweries.add(new Place(getString(R.string.boulderbeerbreweryname), getString(R.string.boulderbeerbrewerydescription), R.drawable.boulderbeerbrewery));
        breweries.add(new Place(getString(R.string.drydockbreweryname), getString(R.string.drydockbrewerydescription), R.drawable.drydockbrewery));

        //create new adapter using the breweries list
        PlaceAdapter placeAdapter = new PlaceAdapter(BreweriesActivity.this, breweries);

        ListView listView = (ListView) findViewById(R.id.list);

        //Hook up the adapter to the listView
        listView.setAdapter(placeAdapter);

        //Make each brewery in the list to be clickable and to start the info activity. send correct data in intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = breweries.get(position);
                Intent intent = new Intent(BreweriesActivity.this, Information.class);
                intent.putExtra(getString(R.string.intentplaceimage), place.getImageResourseId());
                intent.putExtra(getString(R.string.intentplacedescription), place.getDescription());
                intent.putExtra(getString(R.string.intentplacename), place.getName());
                startActivity(intent);
            }
        });
    }

}
