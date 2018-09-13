package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    //Création des variables

    Button buttonSearchSecond;
    EditText departureInput;
    EditText destinationInput;
    EditText dateInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        departureInput = (EditText) findViewById(R.id.departure_input);
        destinationInput = (EditText) findViewById(R.id.destination_input);
        dateInput = (EditText) findViewById(R.id.date_input);


        addListenerOnButtonSearchSecond();
    }


    public void addListenerOnButtonSearchSecond() {

        buttonSearchSecond = (Button) findViewById(R.id.button_search_2);

        buttonSearchSecond.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(departureInput.getText().toString().isEmpty() || destinationInput.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            getString(R.string.please_fill),
                            Toast.LENGTH_LONG);

                    toast.show();
                }
                else {
                    Intent i = new Intent (getApplicationContext(), ItineraryListActivity.class);
                    i.putExtra("key_departure", departureInput.getText().toString());
                    i.putExtra("key_destination", destinationInput.getText().toString());
                    startActivity(i);

                }

            }
        });

    }





}
