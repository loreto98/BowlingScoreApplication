package com.gjini.loris.bowlingscoreapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void goToPointActivity(View view) {
        EditText FirstPlayer = (EditText) findViewById(R.id.FirstPlayer);
        EditText SecondPlayer = (EditText) findViewById(R.id.SecondPlayer);
        String FirstPlayerString = FirstPlayer.getText().toString();
        String SecondPlayerString = SecondPlayer.getText().toString();

        if (FirstPlayerString.matches("")) {
            Toast.makeText(this, R.string.nofirstplayername, Toast.LENGTH_SHORT).show();
            return;
        }

        if (SecondPlayerString.matches("")) {
            Toast.makeText(this, R.string.nosecondplayername, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent pointactivity = new Intent(this, PointActivity.class);
        pointactivity.putExtra("firstplayername", FirstPlayerString);
        pointactivity.putExtra("secondplayername", SecondPlayerString);
        startActivity(pointactivity);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
