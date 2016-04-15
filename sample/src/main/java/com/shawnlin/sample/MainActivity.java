package com.shawnlin.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shawnlin.preferencesmanager.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INT = "int";
    private static final String KEY_OBJECT = "object";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new PreferencesManager(this)
            .setName("prefs")
            .init();


        Button intButton = (Button) findViewById(R.id.int_button);
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                PreferencesManager.putInt(KEY_INT, (int) (Math.random() * 10 + 10));
                makeToast(String.valueOf(PreferencesManager.getInt(KEY_INT)));
            }
        });

        Button objectButton = (Button) findViewById(R.id.object_button);
        objectButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                PreferencesManager.putObject(KEY_OBJECT, new Person(getString(R.string.app_name)));
                makeToast(PreferencesManager.getObject(KEY_OBJECT, Person.class).name);
            }
        });
    }

    private void makeToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    class Person {

        public String name;

        public Person(String name) {
            this.name = name;
        }

    }

}
