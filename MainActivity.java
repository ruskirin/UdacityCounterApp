package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int healthBlue = 100,
            healthRed = 100;

    int scoreRed = 0,
            scoreBlue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scorePlusOne() {
        if(healthBlue <= 0) { ++scoreRed; healthBlue = 100; displayScoreRed(scoreRed); }
        if(healthRed <= 0) { ++scoreBlue; healthRed = 100; displayScoreBlue(scoreBlue); }
    }

    public void hitHeadBlue(View v) {
        healthBlue -= 5;
        scorePlusOne();
        displayHealthBlue(healthBlue);
    }

    public void hitHeadRed(View v) {
        healthRed -= 5;
        scorePlusOne();
        displayHealthRed(healthRed);
    }

    public void hitBodyBlue(View v) {
        healthBlue -= 3;
        scorePlusOne();
        displayHealthBlue(healthBlue);
    }

    public void hitBodyRed(View v) {
        healthRed -= 3;
        scorePlusOne();
        displayHealthRed(healthRed);
    }

    public void legPenaltyBlue(View v) {
        healthBlue -= 8;
        scorePlusOne();
        --scoreRed;
        displayHealthBlue(healthBlue);
        displayScoreRed(scoreRed);
    }

    public void legPenaltyRed(View v) {
        healthRed -= 8;
        scorePlusOne();
        --scoreBlue;
        displayHealthRed(healthRed);
        displayScoreBlue(scoreBlue);
    }

    public void resetScore(View v) {
        healthBlue = 100; healthRed = 100;
        scoreBlue = 0; scoreRed = 0;
        displayHealthBlue(100);
        displayHealthRed(100);
        displayScoreBlue(0);
        displayScoreRed(0);
    }

    public void displayHealthBlue(int health) {
        TextView scoreView = (TextView) findViewById(R.id.health_blue);
        scoreView.setText(String.valueOf(healthBlue));
    }

    public void displayHealthRed(int health) {
        TextView scoreView = (TextView) findViewById(R.id.health_red);
        scoreView.setText(String.valueOf(healthRed));
    }

    public void displayScoreBlue(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_blue);
        scoreView.setText(String.valueOf(scoreBlue));
    }

    public void displayScoreRed(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_red);
        scoreView.setText(String.valueOf(scoreRed));
    }
}