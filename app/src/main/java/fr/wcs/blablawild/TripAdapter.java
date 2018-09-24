package fr.wcs.blablawild;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView date = convertView.findViewById(R.id.textDate);
        TextView firstname = convertView.findViewById(R.id.textFirstname);
        TextView lastname = convertView.findViewById(R.id.textLastname);
        TextView price = convertView.findViewById(R.id.textPrice);

        //Creating dateformat
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy kk:mm");

        // Populate the data into the template view using the data object
        date.setText(dateFormat.format(trip.getDateModel()));
        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        price.setText(String.valueOf(trip.getPrice()));



        // Return the completed view to render on screen
        return convertView;
    }


}