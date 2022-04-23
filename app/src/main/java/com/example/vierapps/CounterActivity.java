package com.example.vierapps;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CounterActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.vierapps";
    private int increment_Counter = 0;
    private final String COUNT_KEY = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);

        TextView counter = (TextView) findViewById(R.id.show_count);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        increment_Counter = mPreferences.getInt(COUNT_KEY, 0);
        counter.setText(String.format("%s", increment_Counter));
    }
    public void raise_clicked(View view) {
        TextView counter = (TextView) findViewById(R.id.show_count);
        increment_Counter++;
        counter.setText(String.valueOf(increment_Counter));
    }

    public void reset_count(View view) {
        TextView counter = (TextView) findViewById(R.id.show_count);
        increment_Counter = 0;
        counter.setText(String.valueOf(increment_Counter));

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }

    public void print_toast(View view) {
        TextView counter = (TextView) findViewById(R.id.show_count);
        Toast
                .makeText(CounterActivity.this,
                        "Current Value: " + counter.getText(),
                        Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, increment_Counter);
        preferencesEditor.apply();
    }
}