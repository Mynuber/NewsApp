package xyz.markswebsite.newsapp.Utility;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * Created by Mark on 9/09/2017.
 */

public class SharedPreferenceUtil {

    public static void saveObject(AppCompatActivity activity, String key, Object object) {
        Gson gson = new Gson();
        writeStringToSharedPreferences(activity, key, gson.toJson(object));
    }

    public <T extends Object> T readObject(AppCompatActivity activity, String key, Class<T> type) {
        Gson gson = new Gson();
        String value = readStringFromSharedPreferences(activity, key);
        if(value == null){
            return null;
        }
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
        editor.apply();     //.commit is the alternative if you want it asynchronously
    }


}
