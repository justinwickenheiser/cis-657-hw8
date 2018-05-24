// Nathan Hull
// Justin Wickenheiser
// HW 6
package com.example.wickenju.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    String distanceSelection = "";
    String degreeSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spnDistance = (Spinner)findViewById(R.id.spnDistance);
        Spinner spnDegree = findViewById(R.id.spnDegree);

        Intent payload = getIntent();
        if (payload.hasExtra("distance")) {
            distanceSelection = payload.getStringExtra("distance");
        }
        if (payload.hasExtra("degree")) {
            degreeSelection = payload.getStringExtra("degree");
        }

        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(this, R.array.distanceUnits, android.R.layout.simple_spinner_dropdown_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDistance.setAdapter(distanceAdapter);
        if (distanceSelection != null) {
            int spinnerPosition = distanceAdapter.getPosition(distanceSelection);
            spnDistance.setSelection(spinnerPosition);
        }
        spnDistance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                distanceSelection = (String)adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> degreeAdapter = ArrayAdapter.createFromResource(this, R.array.degreeUnits, android.R.layout.simple_spinner_dropdown_item);
        degreeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDegree.setAdapter(degreeAdapter);
        if (degreeSelection != null) {
            int spinnerPosition = degreeAdapter.getPosition(degreeSelection);
            spnDegree.setSelection(spinnerPosition);
        }
        spnDegree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                degreeSelection = (String)adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        FloatingActionButton btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener((View v) -> {
            Intent intent = new Intent();
            intent.putExtra("distance", distanceSelection);
            intent.putExtra("degree", degreeSelection);
            setResult(MainActivity.SETTINGS_REQUEST_CODE, intent);
            finish();
        });
    }

}
