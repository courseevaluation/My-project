package com.example.course_evaluation.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.course_evaluation.R;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class Constants {
    public static final String MY_PREFS_NAME = "pref_name_1142";
    public static int UI_MODE = 1;
    public static String currentlanguage="en";
    public  static  String currentusername="Md Ahmed Hussain",userId="83fd7d53823";
    public static ArrayList<String> CourseNames=new ArrayList<>();
    public static boolean IsConnected(){
        try{
            return (Runtime.getRuntime().exec("ping -c 1 google.com").waitFor()==0);

        }catch (Exception e){
            return false;
        }
    }

    public static String getMyPrefsName() {
        return MY_PREFS_NAME;
    }

    public static int getUiMode() {
        return UI_MODE;
    }

    public static void setUiMode(int uiMode) {
        UI_MODE = uiMode;
    }

    public static String getCurrentlanguage() {
        return currentlanguage;
    }

    public static void setCurrentlanguage(String currentlanguage) {
        Constants.currentlanguage = currentlanguage;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        Constants.userId = userId;
    }


    public static ArrayList<String> getsubname(){
        CourseNames.add("Algorithm and data structure");
        CourseNames.add("Linear Algebra");
        CourseNames.add("Discrete mathmatics");
        CourseNames.add("Object oriented programming");
        return CourseNames;
    }

    public static String getCurrentusername() {
        return currentusername;
    }

    public static void setCurrentusername(String currentusername) {
        Constants.currentusername = currentusername;
    }

    public static ArrayList<String> getCourseNames() {
        return CourseNames;
    }

    public static void setCourseNames(ArrayList<String> courseNames) {
        CourseNames = courseNames;
    }

    public static int getthemepref(){
        return R.style.Theme_AppCompat;
    }
    public static void putpref( Context context,String key,String val){
        SharedPreferences preferences=context.getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("theme",true);
        editor.commit();

    }
}
