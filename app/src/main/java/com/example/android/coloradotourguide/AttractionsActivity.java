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

public class AttractionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //create a new arraylist for attractions
        final ArrayList<Place> attractions = new ArrayList<Place>();
        attractions.add(new Place(getString(R.string.blackcanyonname), getString(R.string.blackcanyonattractiondescription), R.drawable.blackcanyonattraction));
        attractions.add(new Place(getString(R.string.gardenofthegodsname), getString(R.string.gardenofthegodsattractiondescription), R.drawable.gardenofthegodsattraction));
        attractions.add(new Place(getString(R.string.redrocksamphitheatername), getString(R.string.redrocksattractiondescription), R.drawable.redrocksattraction));
        attractions.add(new Place(getString(R.string.denverartmuseumname), getString(R.string.denverartmuseumattractiondescription), R.drawable.denverartmuseumattraction));
        attractions.add(new Place(getString(R.string.cheyennemtzooname), getString(R.string.cheyennemtattractiondescription), R.drawable.cheyennemountainzooattraction));
        attractions.add(new Place(getString(R.string.sevenfallsname), getString(R.string.sevenfallsattractiondescription), R.drawable.sevenfallsattraction));
        attractions.add(new Place(getString(R.string.denveraquariumname), getString(R.string.denveraquariumattractiondescription), R.drawable.denveraquariumattraction));

        //create an adapter for the attractions list
        PlaceAdapter placeAdapter = new PlaceAdapter(AttractionsActivity.this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        //hook up adapter and listview
        listView.setAdapter(placeAdapter);

        //make each attraction in the list clickable. start info activity. send correct info with intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = attractions.get(position);
                Intent intent = new Intent(AttractionsActivity.this,Information.class);
                intent.putExtra(getString(R.string.intentplaceimage), place.getImageResourseId());
                intent.putExtra(getString(R.string.intentplacedescription), place.getDescription());
                intent.putExtra(getString(R.string.intentplacename), place.getName());
                startActivity(intent);
            }
        });
    }

}
