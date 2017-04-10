package com.gjini.loris.bowlingscoreapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.gjini.loris.bowlingscoreapplication.R.id.FirstPlayer;
import static com.gjini.loris.bowlingscoreapplication.R.id.Player1;
import static com.gjini.loris.bowlingscoreapplication.R.id.playerid;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        String thewinner = getIntent().getStringExtra("winner");

        TextView youwon = (TextView) findViewById(playerid);
        youwon.setText(thewinner);
    }
}
