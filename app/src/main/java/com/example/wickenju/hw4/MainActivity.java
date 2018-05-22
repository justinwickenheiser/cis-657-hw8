package com.example.wickenju.hw4;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String distanceUnits = "Kilometers";
    String degreeUnits = "Degrees";

    EditText latP1;
    EditText longP1;
    EditText latP2;
    EditText longP2;
    TextView distLabel;
    TextView bearingLabel;

    static int SETTINGS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latP1 = (EditText) findViewById(R.id.latP1);
        longP1 = (EditText) findViewById(R.id.longP1);
        latP2 = (EditText) findViewById(R.id.latP2);
        longP2 = (EditText) findViewById(R.id.longP2);

        latP1.setText("43.077366");
        longP1.setText("-85.994053");
        latP2.setText("43.077303");
        longP2.setText("-85.993860");

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        distLabel = (TextView) findViewById(R.id.distLabel);
        bearingLabel = (TextView) findViewById(R.id.bearingLabel);

        clearBtn.setOnClickListener((View v) -> {
            latP1.setText("");
            longP1.setText("");
            latP2.setText("");
            longP2.setText("");
            distLabel.setText("Distance: ");
            bearingLabel.setText("Bearing: ");
        });

        calcBtn.setOnClickListener((View v) -> {
            calculate();
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra("distance", distanceUnits);
                intent.putExtra("degree", degreeUnits);
                startActivityForResult(intent, MainActivity.SETTINGS_REQUEST_CODE);
        }

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == SETTINGS_REQUEST_CODE) {
                distanceUnits = data.getStringExtra("distance");
                degreeUnits = data.getStringExtra("degree");
                calculate();
            }
        }
    }

    void calculate() {
        if (!(latP1.getText().toString().equals("") || latP2.getText().toString().equals("") || longP1.getText().toString().equals("") || longP2.getText().toString().equals(""))) {

            Location loc1 = new Location("");
            loc1.setLatitude(Double.parseDouble(latP1.getText().toString()));
            loc1.setLongitude(Double.parseDouble(longP1.getText().toString()));

            Location loc2 = new Location("");
            loc2.setLatitude(Double.parseDouble(latP2.getText().toString()));
            loc2.setLongitude(Double.parseDouble(longP2.getText().toString()));

            // Distance
            float distInMeters = loc1.distanceTo(loc2);
            float distInKm = distInMeters / 1000;
            if (distanceUnits.equals("Kilometers")) {
                distLabel.setText("Distance: " + String.format("%.02f", distInKm) + " " + distanceUnits);
            } else {
                float distInMiles = distInKm * new Float(0.621371);
                distLabel.setText("Distance: " + String.format("%.02f", distInMiles) + " " + distanceUnits);
            }

            // Bearing
            float bearingInDegrees = loc1.bearingTo(loc2);
            if (degreeUnits.equals("Degrees")) {
                bearingLabel.setText("Bearing: " + String.format("%.02f", bearingInDegrees) + " " + degreeUnits);
            } else {
                float bearingInMils = bearingInDegrees * new Float(17.777777777778);
                bearingLabel.setText("Bearing: " + String.format("%.02f", bearingInMils) + " " + degreeUnits);
            }
        }
    }
}
