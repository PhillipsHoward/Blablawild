package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    //Création des variables

    Button buttonSearchSecond;
    EditText departureInput;
    EditText destinationInput;
    EditText dateInput;
    Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        departureInput = (EditText) findViewById(R.id.departure_input);
        destinationInput = (EditText) findViewById(R.id.destination_input);
        dateInput = (EditText) findViewById(R.id.date_input);
        addListenerOnButtonSearchSecond();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateInput.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateInput.setText(sdf.format(myCalendar.getTime()));
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
