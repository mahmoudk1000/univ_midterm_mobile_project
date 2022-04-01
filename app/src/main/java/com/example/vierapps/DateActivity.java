package com.example.vierapps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity);
    }

    public void birthday(View view) {
        int year = Calendar.getInstance().get(Calendar.YEAR);

        EditText input_year = findViewById(R.id.year_date);
        String year_value = input_year.getText().toString();
        int final_year_value = Integer.parseInt(year_value);

        EditText input_month = findViewById(R.id.month_date);
        String month_value = input_month.getText().toString();
        int final_month_value = Integer.parseInt(month_value);

        EditText input_day = findViewById(R.id.day_date);
        String day_value = input_day.getText().toString();
        int final_day_value = Integer.parseInt(day_value);

        TextView show_year = findViewById(R.id.show_year);
        int years_num = year - final_year_value;
        show_year.setText(String.valueOf(years_num + "Y,"));

        TextView show_month = findViewById(R.id.show_month);
        int months_num = years_num  * 12;
        show_month.setText(String.valueOf(months_num + "M,"));

        TextView show_day = findViewById(R.id.show_day);
        int days_num = years_num * 365;
        show_day.setText(String.valueOf(days_num + "D"));
    }
}