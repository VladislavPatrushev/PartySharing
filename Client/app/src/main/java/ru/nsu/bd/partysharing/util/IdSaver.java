package ru.nsu.bd.partysharing.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import ru.nsu.bd.partysharing.types.Constants;

public class IdSaver {

    public static void putId(Long id, Context context) {
        SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(Constants.ID_PREFERENSE, id);
        editor.apply();
    }

    public static Long getId(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getLong(Constants.ID_PREFERENSE, 0);
    }

}
