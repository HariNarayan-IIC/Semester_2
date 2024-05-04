package com.example.stopwatch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Boolean running = false;
    Integer seconds = 0;
    TextView timerTextView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        timerTextView = findViewById(R.id.timerTextView);
    }

    public void onButtonStartClick(View view) {
        if (running) {
            return;
        }
        running = true;
        runTimer();
    }

    public void onButtonStopClick(View view) {
        if (!running) {
            return;
        }
        running = false;
        handler.removeCallbacksAndMessages(null); // Stop the handler
    }

    public void onButtonResetClick(View view) {
        seconds = 0;
        updateTimer(); // Update the timer display
    }

    private void runTimer() {
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                    updateTimer();
                    handler.postDelayed(this, 1000); // Run this runnable again after 1 second
                }
            }
        });
    }

    private void updateTimer() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        // Format the time as a string
        @SuppressLint("DefaultLocale") String time = String.format("%02d:%02d:%02d", hours, minutes, secs);

        // Update the TextView with the formatted time
        timerTextView.setText(time);
    }
}