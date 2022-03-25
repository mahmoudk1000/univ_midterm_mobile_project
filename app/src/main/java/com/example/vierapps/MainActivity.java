package com.example.vierapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout counter_launcher = (LinearLayout )findViewById(R.id.one_app);
        counter_launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counter_intent = new Intent(MainActivity.this, CounterActivity.class);
                startActivity(counter_intent);
            }
        });
        LinearLayout random_launcher = (LinearLayout )findViewById(R.id.two_app);
        random_launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counter_intent = new Intent(MainActivity.this, RandomActivity.class);
                startActivity(counter_intent);
            }
        });
        LinearLayout stop_launcher = (LinearLayout )findViewById(R.id.three_app);
        stop_launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counter_intent = new Intent(MainActivity.this, StopActivity.class);
                startActivity(counter_intent);
            }
        });
        LinearLayout date_launcher = (LinearLayout )findViewById(R.id.four_app);
        date_launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent counter_intent = new Intent(MainActivity.this, DateActivity.class);
                startActivity(counter_intent);
            }
        });
    }
}
