package com.android.analucia.app_followme;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;


public class SplashScreen extends ActionBarActivity {

    public static final int secondi = 8;
    public static final int millisecondi = secondi*1000;
    public static final int delay = 2;
    private ProgressBar pbprogreso;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        pbprogreso = (ProgressBar)findViewById(R.id.pbprogreso);
        pbprogreso.setMax(max_progress());
        start_Splash();
    }

    public void start_Splash(){

        new CountDownTimer(millisecondi, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

                pbprogreso.setProgress(stablish_progress(millisUntilFinished));

            }

            @Override
            public void onFinish() {

                Intent newForm = new Intent(SplashScreen.this, MapsActivity.class);
                startActivity(newForm);
                finish();

            }
        }.start();

    }

    public int stablish_progress(long miliseconds){

        return (int)(millisecondi-miliseconds)/1000;

    }

    public int max_progress(){

        return secondi- delay;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
