package com.example.vierapps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.Period;

public class DateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity);
    }

    public void birthday(View view) {
        EditText input_year = findViewById(R.id.year_date);
        String year_value = input_year.getText().toString();
        int final_year_value = Integer.parseInt(year_value);

        EditText input_month = findViewById(R.id.month_date);
        String month_value = input_month.getText().toString();
        int final_month_value = Integer.parseInt(month_value);

        EditText input_day = findViewById(R.id.day_date);
        String day_value = input_day.getText().toString();
        int final_day_value = Integer.parseInt(day_value);

        LocalDate birthday = LocalDate.of(final_year_value, final_month_value, final_day_value);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthday, now);

        TextView show_year = findViewById(R.id.show_year);
        show_year.setText(String.valueOf(diff.getYears() + "Y,"));

        TextView show_month = findViewById(R.id.show_month);
        show_month.setText(String.valueOf(diff.getMonths() + "M,"));

        TextView show_day = findViewById(R.id.show_day);
        show_day.setText(String.valueOf(diff.getDays() + "D"));
    }
}