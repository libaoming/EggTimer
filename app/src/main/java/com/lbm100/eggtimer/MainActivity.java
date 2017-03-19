package com.lbm100.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int countTime;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTime = 1000 ;
        button = (Button) findViewById(R.id.button);
        textView  = (TextView) findViewById(R.id.textView);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(20);
        seekBar.setProgress(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                countTime = progress ;

                Log.i("CountTime",String.valueOf(countTime));

                textView.setText("00:" + String.valueOf(countTime) + "0");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void  onClick(View view){

        countTime = countTime * 10 ;

        new CountDownTimer(countTime * 10000,1000){


            public void onTick(long millisUntilFinished) {

                countTime = countTime -1;

                Log.i("Timer", String.valueOf(countTime));
                textView.setText("00:"+ String.valueOf(countTime));

            }

            public void onFinish() {
                textView.setText("00:00");
            }

        }.start();


    }
}
