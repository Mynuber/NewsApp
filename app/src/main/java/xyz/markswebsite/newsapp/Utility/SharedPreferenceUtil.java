package xyz.markswebsite.newsapp.Utility;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by Mark on 9/09/2017.
 */

public class SharedPreferenceUtil {

    private static Gson gson = new Gson();

    public static void saveObject(AppCompatActivity activity, String key, Object object) {
        writeStringToSharedPreferences(activity, key, gson.toJson(object));
    }

    public <T extends Object> T readObject(AppCompatActivity activity, String key, Object object, Class<T> type) {
        String value = readStringFromSharedPreferences(activity, key);
        return gson.fromJson(value, type);
    }

    private static String readStringFromSharedPreferences(AppCompatActivity activity, String key) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(key, null);
    }

    private static void writeStringToSharedPreferences(AppCompatActivity activity, String key, String value) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }


}