package ru.bonepolk.ctf.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
    public static SharedPreferences getSharedPreference(Context ctx, String name){
        return ctx.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static void writePrefInt(SharedPreferences prefs, String name, int value){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(name, value);
        editor.apply();
    }

    public static int readPrefInt(SharedPreferences prefs, String name, int defaultValue){
        return prefs.getInt(name, defaultValue);
    }

    public static int readPrefInt(SharedPreferences prefs, String name){
        return readPrefInt(prefs, name, 0);
    }
}
