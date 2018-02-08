package com.example.android.coloradotourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by JesseRawlings on 11/6/17.
 */

public class LakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Create an arraylist of lakes using type "Place"
        final ArrayList<Place> lakes = new ArrayList<Place>();
        lakes.add(new Place(getString(R.string.bluemesalakename), getString(R.string.bluemesalakedescription), R.drawable.bluemesalake));
        lakes.add(new Place(getString(R.string.dillonreservoirname), getString(R.string.dillonreservoirdescription), R.drawable.dillonlake));
        lakes.add(new Place(getString(R.string.hanginglakename), getString(R.string.hanginglakedescription), R.drawable.hanginglake));
        lakes.add(new Place(getString(R.string.grandlakename), getString(R.string.grandlakedescription), R.drawable.grandlake));
        lakes.add(new Place(getString(R.string.echolakename), getString(R.string.echolakedescription), R.drawable.echolake));
        lakes.add(new Place(getString(R.string.craterlakename), getString(R.string.craterlakedescription), R.drawable.craterlake));
        lakes.add(new Place(getString(R.string.dreamlakename), getString(R.string.dreamlakedescription), R.drawable.dreamlake));

        //Create a place adapter using the lakes list
        PlaceAdapter placeAdapter = new PlaceAdapter(LakesActivity.this, lakes);

        ListView listView = (ListView) findViewById(R.id.list);

        //Hook up the listview and adapter
        listView.setAdapter(placeAdapter);

        //Setup each listview item as a clickable object that will launch the info activity sending the correct data with the intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = lakes.get(position);
                Intent intent = new Intent(LakesActivity.this, Information.class);
                intent.putExtra(getString(R.string.intentplaceimage), place.getImageResourseId());
                intent.putExtra(getString(R.string.intentplacedescription), place.getDescription());
                intent.putExtra(getString(R.string.intentplacename), place.getName());
                startActivity(intent);
            }
        });
    }

}
