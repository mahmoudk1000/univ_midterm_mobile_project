package com.example.vierapps;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class StopActivity extends AppCompatActivity {
    public CountDownTimer meinCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_activity);
    }

    public void countDownTimerFun(boolean decide) {
        EditText count_down_value = findViewById(R.id.count_down_value);
        String count_down_in_minutes = count_down_value.getText().toString();
        int final_count_down_in_minutes = Integer.parseInt(count_down_in_minutes);
        TextView show_count_down = findViewById(R.id.show_count_down);

        int milliseconds;
        if (decide){
            milliseconds = final_count_down_in_minutes * 60 * 1000;
        }else{
            milliseconds = 0;
        }

        meinCountDownTimer = new CountDownTimer(milliseconds, 1000) {
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
    }
    public void start_countDown(View view) {
        if(view.getId() == R.id.start_count_down) {
            countDownTimerFun(true);
            meinCountDownTimer.start();
        }
    }

    public void stop_countDown(View view) {
        if(view.getId() == R.id.stop_count_down) {
            TextView show_count_down = findViewById(R.id.show_count_down);
            meinCountDownTimer.cancel();
            countDownTimerFun(false);
            show_count_down.setText("00:00");
        }
    }
}