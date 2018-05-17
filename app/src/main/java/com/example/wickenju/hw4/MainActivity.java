package com.example.wickenju.hw4;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            Location loc1 = new Location();
            loc1.setLatitude(new Double(latP1.getText()));
            loc1.setLongitude(new Double(longP1.getText()));

            Location loc2 = new Location();
            loc2.setLatitude(new Double(latP2.getText()));
            loc2.setLongitude(new Double(longP2.getText()));
        });
    }
}
