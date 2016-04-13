package com.shawnlin.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.shawnlin.preferencesmanager.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new PreferencesManager(this)
            .setName("prefs")
            .init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                PreferencesManager.putInt("test", (int) (Math.random() * 10 + 10));
                Toast.makeText(MainActivity.this, String.valueOf(PreferencesManager.getInt("test")),
                    Toast.LENGTH_SHORT).show();
            }
        });
    }

}
