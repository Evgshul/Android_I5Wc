package org.jtm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import org.jtm.android_test.R;

public class MainActivity extends AppCompatActivity {

    private int colorR, colorG, colorB; //colors as integer numbers from 0 to 255
    SeekBar seekBarR, seekBarG, seekBarB; // SeekBars for each color
    LinearLayout mainLayout; // Layout of the screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainScreen);

        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);

        // TODO#1 — set initial background color of mainLayout to black




        mainLayout.setBackgroundColor(Color.BLACK);


        seekBarR.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarG.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBarB.setOnSeekBarChangeListener(seekBarChangeListener);

        // TODO#2 — implement setOnSeekBarChangeListener(...) change listeners for seek bars
        // Call mainLayout.setBackgroundColor() to set background color of app according to the values of seek bars


    }



    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
             = new SeekBar.OnSeekBarChangeListener()
    {
                @Override
               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                         colorR = seekBarR.getProgress();
                         colorG = seekBarG.getProgress();
                         colorB = seekBarB.getProgress();
                         mainLayout.setBackgroundColor(getColor(getRedBar(), getGreenBar(), getBlueBar()));

                         updateBackground();
                     }
                 @Override
                 public void onStartTrackingTouch(SeekBar seekBar) {

                     }

                 @Override
                 public void onStopTrackingTouch(SeekBar seekBar) {

                     }
             };

    // TODO#3 — Implement public getters and setters for seek bars for JUnit test
    // int getRedBar(), int getGreenBar(), int getBlueBar()
    // void setRedBar(int color), void setGreenBar(int color), setBlueBar(int color)


    public int getRedBar() {
        return colorR;
    }

    public void setRedBar(int colorR) {
        this.colorR = colorR;
    }

    public int getGreenBar() {
        return colorG;
    }

    public void setGreenBar(int colorG) {
        this.colorG = colorG;
    }

    public int getBlueBar() {
        return colorB;
    }

    public void setBlueBar(int colorB) {
        this.colorB = colorB;
    }

    /**
     * TODO — Use this method to set background color
     *
     * @param R — red   color 0..255
     * @param G — green color 0..255
     * @param B — blue  color 0..255
     * @return — full color as integer with bytes: FFRRGGBB
     */
    private void updateBackground() {
        colorR = seekBarR.getProgress();
        colorG = seekBarG.getProgress();
        colorB = seekBarB.getProgress();
        mainLayout.setBackgroundColor(
                0xff000000
                        + colorR * 0x10000
                        + colorG * 0x100
                        + colorB
        );

    }

    static int getColor(int R, int G, int B) {
        return 0xff000000 + R * 0x10000 + G * 0x100 + B;
    }




}
