package com.example.recivers_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.recivers_exercise.recivers_list.Headphones_reciver;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    private Headphones_reciver headphones_reciver;
    private static MainActivity ins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);

        headphones_reciver = new Headphones_reciver();

        SharedPreferences settings=getSharedPreferences("BOOT_PREFS",MODE_PRIVATE);
        int TurnedOnTimes = settings.getInt("TurnedOn",0);
        textView4.setText(Integer.toString(TurnedOnTimes));
        SharedPreferences settings2=getSharedPreferences("Headphones_Prefs",MODE_PRIVATE);
        int PlugedIn = settings2.getInt("PluggedIn",0);
        textView6.setText("\t"+Integer.toString(PlugedIn));
        ins = this;
    }

    protected  void onStart() {
        IntentFilter headphones_filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(headphones_reciver,headphones_filter);
        super.onStart();
    }

    protected  void onDestroy() {
        unregisterReceiver(headphones_reciver);
        super.onDestroy();
    }

    public static MainActivity  getInstace(){
        return ins;
    }

    public void updateTheTextView(final String t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = (TextView) findViewById(R.id.textView6);
                textV1.setText("\t"+t);
            }
        });
    }


}