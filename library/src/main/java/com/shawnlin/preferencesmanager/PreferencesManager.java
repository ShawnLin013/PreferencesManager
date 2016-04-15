package com.shawnlin.preferencesmanager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

/**
 * The utility that is used to manage the preferences
 */
public class PreferencesManager {

    private static SharedPreferences mSharedPreferences;
    private static Gson mGson;

    private Context mContext;
    private String mName;

    /**
     * Initial the preferences manager.
     * @param context The context of the application.
     */
    public PreferencesManager(Context context) {
        mContext = context;
        mGson = new Gson();
    }

    /**
     * Set the name of the preferences.
     * @param name The name of the preferences.
     */
    public PreferencesManager setName(String name) {
        mName = name;
        return this;
    }

    /**
     * Initial the instance of the preferences manager.
     */
    public void init() {
        if (mContext == null) {
            return;
        }

        if (mName.isEmpty()) {
            mName = mContext.getPackageName();
        }

        mSharedPreferences = mContext.getSharedPreferences(mName, Activity.MODE_PRIVATE);
    }

    /**
     * Put a String value in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
	public static void putString(String key, String value) {
        if (mSharedPreferences == null) {
            return;
        }

        Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
	}

    /**
     * Retrieval a String value from the preferences.
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
	public static String getString(String key) {
        if (mSharedPreferences == null) {
            return "";
        }
		return mSharedPreferences.getString(key, "");
	}

    /**
     * Put an int value in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
	public static void putInt(String key, int value) {
        if (mSharedPreferences == null) {
            return;
        }

        Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
	}

    /**
     * Retrieval an int value from the preferences.
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
	public static int getInt(String key) {
        if (mSharedPreferences == null) {
            return 0;
        }
		return mSharedPreferences.getInt(key, 0);
	}

    /**
     * Put a float value in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
	public static void putFloat(String key, float value) {
        if (mSharedPreferences == null) {
            return;
        }

        Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Retrieval a float value from the preferences.
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static float getFloat(String key) {
        if (mSharedPreferences == null) {
            return 0;
        }
        return mSharedPreferences.getFloat(key, 0);
    }

    /**
     * Put a long value in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
	public static void putLong(String key, long value) {
        if (mSharedPreferences == null) {
            return;
        }

        Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
	}

    /**
     * Retrieval a long value from the preferences.
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
	public static long getLong(String key) {
        if (mSharedPreferences == null) {
            return 0;
        }
		return mSharedPreferences.getInt(key, 0);
	}

    /**
     * Put a boolean value in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
	public static void putBoolean(String key, boolean value) {
        if (mSharedPreferences == null) {
            return;
        }

        Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
	}

    /**
     * Retrieval a boolean value from the preferences.
     * @param key The name of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
	public static boolean getBoolean(String key) {
        if (mSharedPreferences == null) {
            return false;
        }
		return mSharedPreferences.getBoolean(key, false);
	}

    /**
     * Put a object in the preferences editor.
     * @param key The name of the preference to modify.
     * @param value The new value for the preference.
     */
    public static void putObject(String key, Object value) {
        if (mGson == null || value == null) {
            return;
        }

        putString(key, mGson.toJson(value));
    }

    /**
     * Retrieval a object from the preferences.
     * @param key The name of the preference to retrieve.
     * @param type The class of the preference to retrieve.
     * @return Returns the preference values if they exist, or defValues.
     */
    public static <T> T getObject(String key, Class<T> type) {
        if (mSharedPreferences == null || mGson == null) {
            return null;
        }
        return mGson.fromJson(getString(key), type);
    }

}
