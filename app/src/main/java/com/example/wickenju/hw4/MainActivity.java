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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText latP1 = (EditText) findViewById(R.id.latP1);
        EditText longP1 = (EditText) findViewById(R.id.longP1);
        EditText latP2 = (EditText) findViewById(R.id.latP2);
        EditText longP2 = (EditText) findViewById(R.id.longP2);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        TextView distLabel = (TextView) findViewById(R.id.distLabel);
        TextView bearingLabel = (TextView) findViewById(R.id.bearingLabel);


        clearBtn.setOnClickListener((View v) -> {
            latP1.setText("");
            longP1.setText("");
            latP2.setText("");
            longP2.setText("");
            distLabel.setText("Distance: ");
            bearingLabel.setText("Bearing: ");
        });

        calcBtn.setOnClickListener((View v) -> {
            Location loc1 = new Location("");
            loc1.setLatitude(Double.parseDouble(latP1.getText().toString()));
            loc1.setLongitude(Double.parseDouble(longP1.getText().toString()));

            Location loc2 = new Location("");
            loc2.setLatitude(Double.parseDouble(latP2.getText().toString()));
            loc2.setLongitude(Double.parseDouble(longP2.getText().toString()));

            
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
                intent.putExtra();
                intent.putExtra();
        }

        return true;
    }
}
