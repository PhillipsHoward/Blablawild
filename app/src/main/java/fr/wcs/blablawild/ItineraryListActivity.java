package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        ListView listTrip = findViewById(R.id.list_view);
        ArrayList<TripModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat(getResources().getString(R.string.date_pattern));



        try {
            results.add(new TripModel(getString(R.string.name_eric), getString(R.string.lastaname_eric), sdf.parse(getString(R.string.date_cartman)), 15));
            results.add(new TripModel(getString(R.string.name_stan), getString(R.string.lastname_marsh), sdf.parse(getString(R.string.date_stan)), 20));
            results.add(new TripModel(getString(R.string.name_kenny), getString(R.string.lastname_broflovski), sdf.parse(getString(R.string.date_kenny)), 16));
            results.add(new TripModel(getString(R.string.name_kyle), getString(R.string.lastname_mccormick), sdf.parse(getString(R.string.date_kyle)), 40));
            results.add(new TripModel(getString(R.string.name_wendy), getString(R.string.lastname_testaburger), sdf.parse(getString(R.string.date_wendy)), 20));
        } catch (ParseException e) {
        }
        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);


    }
}
