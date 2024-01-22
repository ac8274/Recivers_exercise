package com.example.recivers_exercise.recivers_list;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Headphones_reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        SharedPreferences settings=context.getSharedPreferences("Headphones_Prefs",MODE_PRIVATE);
        int plugged_in = settings.getInt("PluggedIn",0);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("PluggedIn",plugged_in+1);
        editor.commit();
    }
}