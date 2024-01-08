package com.JannatiSobdo.nur_e_quran.App.Ramadan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.JannatiSobdo.nur_e_quran.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Ramadan extends AppCompatActivity {
    private TextView Textcountdown;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan);
        Textcountdown = findViewById(R.id.countdown);

        // Calculate the time difference between now and February 8, 2024, 8:30 AM
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String targetDateTime = "2024-03-10 00:00:00";
        long targetMillis = 0;

        try {
            Date targetDate = dateFormat.parse(targetDateTime);
            targetMillis = targetDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a countdown timer
        long currentTimeMillis = System.currentTimeMillis();
        long timeDifference = targetMillis - currentTimeMillis;

        countDownTimer = new CountDownTimer(timeDifference, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateCountdownText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                // Countdown finished, you can perform any specific actions here
            }
        };

        countDownTimer.start();
    }
    private void updateCountdownText(long millisUntilFinished) {
        long days = millisUntilFinished / (24 * 60 * 60 * 1000);
        long hours = (millisUntilFinished % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
        long minutes = (millisUntilFinished % (60 * 60 * 1000)) / (60 * 1000);
        long seconds = (millisUntilFinished % (60 * 1000)) / 1000;

        String countdownText = String.format(Locale.getDefault(),
                "%02d days %02d hours %02d minutes %02d seconds",
                days, hours, minutes, seconds);

        Textcountdown.setText(countdownText);
    }
}