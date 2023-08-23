package com.sattakhelo.mtk;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {

    private Context context;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String PREFS_NAME = "boss777";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public SharedPreferenceManager(Context context) {
        this.context = context;
        connectDB();
        //prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        //editor = prefs.edit();
    }

    public void connectDB() {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void closeDB() {
        editor.commit();
    }

    public void clear() {
        editor.clear();
    }

    public void setInt(String key, int value) {
        editor.putInt(key, value);
    }

    public int getInt(String key) {
        return prefs.getInt(key, 1);
    }

    public void setFloat(String key, float value) {
        editor.putFloat(key, value);
    }

    public float getFloat(String key) {
        return prefs.getFloat(key, 0);
    }

    public void setBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
    }

    public boolean getBoolean(String key) {
        return prefs.getBoolean(key, false);
    }

    public String setString(String key, String value) {
        editor.putString(key, value);
        return key;
    }

    public String getString(String key) {
        return prefs.getString(key, "");
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {

        return prefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
