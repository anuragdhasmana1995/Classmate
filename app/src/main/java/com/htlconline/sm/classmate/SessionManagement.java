package com.htlconline.sm.classmate;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shikhar Garg on 26-12-2016.
 */
public class SessionManagement {
    static SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public SessionManagement (Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(Config.PREF_NAME,Config.PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }

    public void set_login(boolean status){
        editor.putBoolean(Config.IS_LOG_IN,status);
        editor.commit();
    }
    public void set_otp(boolean status){
        editor.putBoolean(Config.IS_OTP_DONE,status);
        editor.commit();
    }
    public void set_kyc(boolean status){
        editor.putBoolean(Config.IS_KYC_DONE,status);
        editor.commit();
    }
    public void set_is_student(boolean status){
        editor.putBoolean(Config.IS_STUDENT,status);
        editor.commit();
    }
    public void setcookie(String cookie){
        editor.putString(Config.SET_COOKIE_KEY, cookie);
        editor.commit();
    }
    public static boolean get_login(){
        return sharedPreferences.getBoolean(Config.IS_LOG_IN,false);
    }
    public static boolean get_otp(){
        return sharedPreferences.getBoolean(Config.IS_OTP_DONE,false);
    }
    public static boolean get_kyc(){
        return sharedPreferences.getBoolean(Config.IS_KYC_DONE,false);
    }
    public static boolean get_is_student(){return sharedPreferences.getBoolean(Config.IS_STUDENT,false);}
    public static String get_cookie(){return sharedPreferences.getString(Config.SET_COOKIE_KEY,"");}
}
