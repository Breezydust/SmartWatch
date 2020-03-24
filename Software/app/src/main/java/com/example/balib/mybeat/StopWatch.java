package com.example.balib.mybeat;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;

public class StopWatch extends AppCompatActivity implements View.OnClickListener {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        chronometer = findViewById(R.id.chronometer);
    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                Intent intent1 = new Intent(this, About.class);
                this.startActivity(intent1);
                return true;
            case R.id.Setting:
                Intent intent2 = new Intent(this, settings.class);
                this.startActivity(intent2);
                return true;
            case R.id.SignOut:
                Intent intent3 = new Intent(this, MainActivity.class);
                this.startActivity(intent3);
                return true;
            case R.id.Quit:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    public void onClick(View v) {
        Intent intent = new Intent(StopWatch.this, home.class);
        startActivity(intent);
    }

    public void timer(View v) {
        Intent intent = new Intent(StopWatch.this, timer.class);
        startActivity(intent);

    }
}



