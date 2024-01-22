package com.example.recivers_exercise.recivers_list;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Device_turned_on_reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        SharedPreferences settings=context.getSharedPreferences("BOOT_PREFS",MODE_PRIVATE);
        int TurnedOnTimes = settings.getInt("TurnedOn",0);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("TurnedOn",TurnedOnTimes+1);
        editor.commit();
    }
}