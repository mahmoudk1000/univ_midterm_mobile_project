package com.example.vierapps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter_activity);
    }
    public void raise_clicked(View view) {
        // Get the Counter text which would be changed later
        TextView counter = (TextView) findViewById(R.id.show_count);
        // Increment Counter text
        int increment_Counter = Integer.parseInt(counter.getText().toString());
        increment_Counter++;
        counter.setText(String.valueOf(increment_Counter));
    }

    public void reset_count(View view) {
        // Get the Counter text which would be changed later
        TextView counter = (TextView) findViewById(R.id.show_count);
        counter.setText(String.valueOf(0));
    }

    public void print_toast(View view) {
        // Get the Counter text which would be changed later
        TextView counter = (TextView) findViewById(R.id.show_count);
        // Displaying Toast message
        Toast
                .makeText(CounterActivity.this,
                        "Current Value: " + counter.getText(),
                        Toast.LENGTH_SHORT)
                .show();
    }
}