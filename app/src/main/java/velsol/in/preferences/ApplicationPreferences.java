package velsol.in.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferences
{
    private static ApplicationPreferences mInstance;
    private static Context mCtx;
    public static final String SHARED_PREF_NAME = "vel_visit";
    public  static final String USER_NAME="user_name";
    public static final String PASSWORD="password";

    public static final String APPOINTMENT_NAME="appointment_name";
    public static final String APPOINTMENT_EMAIL="appointment_email";
    public static final String APPOINTMENT_MOBILE="appointment_mobile";
    public static final String APPOINTMENT_PURPOSE="appointment_purpose";

    public ApplicationPreferences(Context context) {
        mCtx = context;
    }

    public static synchronized ApplicationPreferences getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new ApplicationPreferences(context);
        }
        return mInstance;
    }


    public boolean saveUserName(String userName)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
        return true;
    }
    public String getUserName()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(USER_NAME, "");
    }
    public boolean savePassord(String password)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PASSWORD, password);
        editor.apply();
        return true;
    }
    public String getPassword()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(PASSWORD, "");
    }



}
