package com.gjini.loris.bowlingscoreapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.gjini.loris.bowlingscoreapplication.R.id.Player1;
import static com.gjini.loris.bowlingscoreapplication.R.id.Player2;

public class PointActivity extends AppCompatActivity {

    int[] pointsALaunch = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] pointsBLaunch = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int roundA, roundB = 0;
    int tempSumRoundA, tempSumRoundB = 0;
    int strikeOnA, strikeOnB = 0;
    int spareA, spareB = 0;
    int totalSumA, totalSumB = 0;
    int launchA = 1;
    int launchB = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        String FirstPlayer = getIntent().getStringExtra("firstplayername");
        String SecondPlayer = getIntent().getStringExtra("secondplayername");

        TextView firstplayer = (TextView) findViewById(Player1);
        firstplayer.setText(FirstPlayer);

        TextView secondplayer = (TextView) findViewById(Player2);
        secondplayer.setText(SecondPlayer);


        WizardPagerAdapter adapter = new WizardPagerAdapter();
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
    }


    public void allpinA(View view) {
        int pinsdown = 10;
        if (strikeOnA == 2) {
            pointsALaunch[roundA - 1] += pinsdown;
            strikeOnA = 1;
        }
        if (strikeOnA == 1) {
            pointsALaunch[roundA - 3] = pinsdown;
            strikeOnA = 0;
        }
        if (roundA == roundB) {
            firstMessageStrike();
            pointsALaunch[roundA] = pinsdown;
            roundA += 2;
            strikeOnA = 2;
        } else {
            secondMessageStrike();
        }
    }

    public void allpinB(View view) {
        int pinsdown = 10;
        if (strikeOnB == 2) {
            pointsBLaunch[roundB - 1] += pinsdown;
            strikeOnB = 1;
        }
        if (strikeOnB == 1) {
            pointsBLaunch[roundB - 3] = pinsdown;
            strikeOnB = 0;
        }
        if (roundB < roundA) {
            firstMessageStrike();
            pointsBLaunch[roundB] = pinsdown;
            roundB += 2;
            strikeOnB = 2;
        } else {
            secondMessageStrike();
        }
    }


    public void zeropinA(View view) {
        int pinsdown = 0;
        calculationPointsA(pinsdown);
    }

    public void zeropinB(View view) {
        int pinsdown = 0;
        calculationPointsB(pinsdown);
    }


    public void onepinA(View view) {
        int pinsdown = 1;
        calculationPointsA(pinsdown);
    }

    public void onepinB(View view) {
        int pinsdown = 1;
        calculationPointsB(pinsdown);
    }


    public void twopinA(View view) {
        int pinsdown = 2;
        calculationPointsA(pinsdown);
    }

    public void twopinB(View view) {
        int pinsdown = 2;
        calculationPointsB(pinsdown);
    }


    public void threepinA(View view) {
        int pinsdown = 3;
        calculationPointsA(pinsdown);
    }

    public void threepinB(View view) {
        int pinsdown = 3;
        calculationPointsB(pinsdown);
    }


    public void fourpinA(View view) {
        int pinsdown = 4;
        calculationPointsA(pinsdown);
    }

    public void fourpinB(View view) {
        int pinsdown = 4;
        calculationPointsB(pinsdown);
    }


    public void fivepinA(View view) {
        int pinsdown = 5;
        calculationPointsA(pinsdown);
    }

    public void fivepinB(View view) {
        int pinsdown = 5;
        calculationPointsB(pinsdown);
    }


    public void sixpinA(View view) {
        int pinsdown = 6;
        calculationPointsA(pinsdown);
    }

    public void sixpinB(View view) {
        int pinsdown = 6;
        calculationPointsB(pinsdown);
    }


    public void sevenpinA(View view) {
        int pinsdown = 7;
        calculationPointsA(pinsdown);
    }

    public void sevenpinB(View view) {
        int pinsdown = 7;
        calculationPointsB(pinsdown);
    }


    public void eightpinA(View view) {
        int pinsdown = 8;
        calculationPointsA(pinsdown);
    }

    public void eightpinB(View view) {
        int pinsdown = 8;
        calculationPointsB(pinsdown);
    }


    public void ninepinA(View view) {
        int pinsdown = 9;
        calculationPointsA(pinsdown);

    }

    public void ninepinB(View view) {
        int pinsdown = 9;
        calculationPointsB(pinsdown);
    }


    private void booleanRoundA() {
        if (roundA % 2 == 0)
            tempSumRoundA = 0;
    }

    private void booleanRoundB() {
        if (roundB % 2 == 0)
            tempSumRoundB = 0;
    }


    private void twoStrikeOnA(int pinsdown) {
        pointsALaunch[roundA - 2] = pinsdown;
        strikeOnA = 1;
    }

    private void twoStrikeOnB(int pinsdown) {
        pointsBLaunch[roundB - 2] = pinsdown;
        strikeOnB = 1;
    }

    private void oneStrikeOnA(int pinsdown) {
        pointsALaunch[roundA - 3] += pinsdown;
        strikeOnA = 0;
    }

    private void oneStrikeOnB(int pinsdown) {
        pointsBLaunch[roundB - 3] += pinsdown;
        strikeOnB = 0;
    }


    private void spareOnA(int pinsdown) {
        pointsALaunch[roundA - 1] += pinsdown;
        spareA = 0;
    }

    private void spareOnB(int pinsdown) {
        pointsBLaunch[roundB - 1] += pinsdown;
        spareB = 0;
    }


    private void calculationPointsA(int pinsdown) {
        launchA = launchA + 1;
        launchB = 1;
        booleanRoundA();
        tempSumRoundA += pinsdown;
        displayLaunchA();
        if (tempSumRoundA <= 10) {
            if (roundA == roundB || roundA == (roundB + 1)) {
                pointsALaunch[roundA] = pinsdown;
                roundA++;
                if (spareA == 1) {
                    spareOnA(pinsdown);
                }
                if (strikeOnA == 0) {
                    firstMessage();
                    TotalPointA();
                } else if (strikeOnA == 2)
                    twoStrikeOnA(pinsdown);
                else {
                    oneStrikeOnA(pinsdown);
                    TotalPointA();
                }
            } else {
                secondMessage();
            }
            if (tempSumRoundA == 10) {
                spareA = 1;
            }
        } else {
            lessPinsMessage();
            tempSumRoundA -= pinsdown;
        }
        displayRoundB();
        displayLaunchB();
    }

    private void calculationPointsB(int pinsdown) {
        launchB = launchB + 1;
        launchA = 1;
        booleanRoundB();
        tempSumRoundB += pinsdown;
        displayLaunchB();
        if (tempSumRoundB <= 10) {
            if (roundB < roundA) {
                pointsBLaunch[roundB] = pinsdown;
                roundB++;
                if (spareB == 1) {
                    spareOnB(pinsdown);
                }
                if (strikeOnB == 0) {
                    firstMessage();
                    TotalPointB();
                } else if (strikeOnB == 2)
                    twoStrikeOnB(pinsdown);
                else {
                    oneStrikeOnB(pinsdown);
                    TotalPointB();
                }
            } else {
                secondMessage();
            }
            if (tempSumRoundB == 10) {
                spareB = 1;
            }
        } else {
            lessPinsMessage();
            tempSumRoundB -= pinsdown;
        }
        displayLaunchA();
        displayRoundA();
        if (roundB == 20) {
            winner();
        }
    }


    public void winner() {
        if (totalSumA > totalSumB) {
            TextView FirstPlayer = (TextView) findViewById(R.id.Player1);
            String FirstPlayerString = FirstPlayer.getText().toString();

            Intent pointactivity = new Intent(this, WinnerActivity.class);
            pointactivity.putExtra("winner", FirstPlayerString);
            startActivity(pointactivity);

            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (totalSumB > totalSumA) {
            TextView SecondPlayer = (TextView) findViewById(R.id.Player2);
            String SecondPlayerString = SecondPlayer.getText().toString();

            Intent pointactivity = new Intent(this, WinnerActivity.class);
            pointactivity.putExtra("winner", SecondPlayerString);
            startActivity(pointactivity);

            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else {
            String SecondPlayerString = getString(R.string.drawfinal);

            Intent pointactivity = new Intent(this, WinnerActivity.class);
            pointactivity.putExtra("winner", SecondPlayerString);
            startActivity(pointactivity);

            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    private void TotalPointA() {
        int sum = 0;
        for (int i = 0; i < roundA; i++) {
            sum = sum + pointsALaunch[i];
        }
        totalSumA = sum;
        displayPointsA(sum);
    }

    private void TotalPointB() {
        int sum = 0;
        for (int i = 0; i < roundB; i++) {
            sum = sum + pointsBLaunch[i];
        }
        totalSumB = sum;
        displayPointsB(sum);
    }


    private void displayPointsA(int number) {
        TextView pointsA = (TextView) findViewById(R.id.team_a_score);
        pointsA.setText("" + number);
    }

    private void displayPointsB(int number) {
        TextView pointsB = (TextView) findViewById(R.id.team_b_score);
        pointsB.setText("" + number);
    }

    private void displayRoundA() {
        int round = (roundA / 2) + 1;
        TextView roundA = (TextView) findViewById(R.id.roundNumberA);
        roundA.setText("" + round);
    }

    private void displayRoundB() {
        int round = (roundB / 2) + 1;
        TextView roundB = (TextView) findViewById(R.id.roundNumberB);
        roundB.setText("" + round);
    }

    private void displayLaunchA() {
        TextView launchnumberA = (TextView) findViewById(R.id.launchNumberA);
        if (launchA <= 2) {
            launchnumberA.setText("" + launchA);
        } else {
            launchnumberA.setText("Next Player");
        }
    }

    private void displayLaunchB() {
        TextView launchnumberB = (TextView) findViewById(R.id.launchNumberB);
        if (launchB <= 2) {
            launchnumberB.setText("" + launchB);
        } else {
            launchnumberB.setText("Next Player");
        }
    }


    private void lessPinsMessage() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.morepins);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void firstMessageStrike() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.alldown);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void secondMessageStrike() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.otherplayerround);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void firstMessage() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.anotherattempt);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void secondMessage() {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.otherplayerround);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    public void resetScore(View view) {
        displayPointsA(0);
        displayPointsB(0);
        for (int i = 0; i < 20; i++) {
            pointsALaunch[i] = 0;
            pointsBLaunch[i] = 0;
        }
        roundA = 0;
        roundB = 0;
        tempSumRoundA = 0;
        tempSumRoundB = 0;
        strikeOnA = 0;
        strikeOnB = 0;
        spareA = 0;
        spareB = 0;
        totalSumA = 0;
        totalSumB = 0;
        launchA = 1;
        launchB = 1;

        TextView launchnumberB = (TextView) findViewById(R.id.launchNumberB);
        launchnumberB.setText("1");

        TextView launchnumberA = (TextView) findViewById(R.id.launchNumberA);
        launchnumberA.setText("1");

        TextView roundB = (TextView) findViewById(R.id.roundNumberB);
        roundB.setText("1");

        TextView roundA = (TextView) findViewById(R.id.roundNumberA);
        roundA.setText("1");

        TextView pointsA = (TextView) findViewById(R.id.team_a_score);
        pointsA.setText("0");

        TextView pointsB = (TextView) findViewById(R.id.team_a_score);
        pointsB.setText("0");


        Context context = getApplicationContext();
        CharSequence text = getString(R.string.resettext);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    class WizardPagerAdapter extends PagerAdapter {

        public Object instantiateItem(ViewGroup collection, int position) {

            int resId = 0;
            switch (position) {
                case 0:
                    resId = R.id.page_one;
                    break;
                case 1:
                    resId = R.id.page_two;
                    break;
            }
            return findViewById(resId);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}