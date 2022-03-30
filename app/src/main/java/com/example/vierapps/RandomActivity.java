package com.example.vierapps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_activity);
    }

    public void random_create(View view) {
        EditText min_num = (EditText) findViewById(R.id.min_num);
        String min = min_num.getText().toString();
        int int_min = Integer.parseInt(min);

        EditText max_num = (EditText) findViewById(R.id.max_num);
        String max = max_num.getText().toString();
        int int_max = Integer.parseInt(max);

        Random number = new Random();
        int random_num = number.nextInt(int_max + 1 - int_min) + int_min;

        TextView counter = (TextView) findViewById(R.id.show_random);
        counter.setText(String.valueOf(random_num));
    }
}