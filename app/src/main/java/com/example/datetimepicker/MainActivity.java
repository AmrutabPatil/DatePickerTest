package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.MessageFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button mDatebtn , mTimebtn;
    private TextView mDateText , mTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatebtn = findViewById(R.id.datebtn);
        mTimebtn = findViewById(R.id.timebtn);
        mDateText = findViewById(R.id.datetext);
        mTimeText = findViewById(R.id.textView2);

        mDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
        mTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePicker();
            }
        });
    }

    private void openTimePicker() {

        Calendar calendar = Calendar.getInstance();

        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mTimeText.setText(hourOfDay + ":" + minute);
            }
        } ,  HOUR , MINUTE , false);
        timePickerDialog.show();
    }

    private void openDatePicker() {
        Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                mDateText.setText(MessageFormat.format("{0}/{1}/{2}", dayOfMonth, month, year));
            }
        } , YEAR , MONTH , DATE);
        datePickerDialog.show();
    }
}

