package com.example.vierapps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_activity);
    }
    public void countDown(View view) {
        EditText counter_down = (EditText) findViewById(R.id.show_count_down);
        String count_down = counter_down.getText().toString();
        int count_down_value = Integer.parseInt(count_down);
        while( count_down_value > 0 ){
            count_down_value--;
            counter_down.setText(String.valueOf(count_down_value));
        }
    }
}