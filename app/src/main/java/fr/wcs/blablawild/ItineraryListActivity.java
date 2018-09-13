package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);


        Intent intent = getIntent();
        String departure = intent.getStringExtra("key_departure");
        String destination = intent.getStringExtra("key_destination");

        setTitle(departure + " >> " + destination);

        Toast toast = Toast.makeText(getApplicationContext(),
                getString(R.string.bienvenue),
                Toast.LENGTH_LONG);

        toast.show();


    }
}
