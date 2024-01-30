package com.example.recivers_exercise.recivers_list;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import com.example.recivers_exercise.MainActivity;
import com.example.recivers_exercise.R;

public class Headphones_reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int n = intent.getIntExtra("state",0);
        if(n == 1&&intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            SharedPreferences settings = context.getSharedPreferences("Headphones_Prefs", MODE_PRIVATE);
            int plugged_in = settings.getInt("PluggedIn", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("PluggedIn", plugged_in + 1);
            editor.commit();
            MainActivity.getInstace().updateTheTextView(Integer.toString(plugged_in));
        }
    }
}