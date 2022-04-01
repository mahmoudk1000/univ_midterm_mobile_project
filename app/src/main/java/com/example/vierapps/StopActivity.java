package com.example.vierapps;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class StopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_activity);
    }

    public void countDown(View view) {
        EditText count_down_value = (EditText) findViewById(R.id.count_down_value);
        String count_down_in_minutes = count_down_value.getText().toString();
        int final_count_down_in_minutes = Integer.parseInt(count_down_in_minutes);
        
        TextView show_count_down = (TextView) findViewById(R.id.show_count_down);
        int milliseconds = final_count_down_in_minutes * 60 * 1000;

        CountDownTimer countDownTimer = new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                show_count_down.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            @Override
            public void onFinish() {
                show_count_down.setText(R.string.time_up);
            }
        };
        if(view.getId() == R.id.count_down)
            countDownTimer.start();
        else if(view.getId() == R.id.count_down)
            countDownTimer.cancel();
    }
}