package com.example.course_evaluation.others;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_evaluation.R;
import com.example.course_evaluation.loginsignup.LoginNew;
import com.example.course_evaluation.util.Constants;

import java.util.Locale;

public class Startup extends AppCompatActivity {

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 1500;
    TextView appname;
    String app_name="COURSE EVALUATION";
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_startup);
        appname=findViewById(R.id.startup_appname_textview);
        loadsettings();
        showname("COURSE EVALUATION",appname);
        hideNavigationBar();
        // setLocale("bn");
    }
    void loadsettings() {
        SharedPreferences prefs = getSharedPreferences(Constants.getMyPrefsName(), MODE_PRIVATE);
        Constants.setUiMode(prefs.getInt("uimode", R.style.mydarktheme));
    }
    public void setLocale(String localeName) {
        if (!localeName.equals(Constants.getCurrentlanguage())) {
            Locale locale = new Locale(localeName);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getResources().updateConfiguration(config,getResources().getDisplayMetrics());
            Constants.setCurrentlanguage(localeName);
        } else {
            Toast.makeText(Startup.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
    public void showname(final String text, final TextView textView) {
        Thread thread = new Thread() {
            int i;

            @Override
            public void run() {
                try {
                    for (i = 0; i <= text.length(); i++) {
                        if(i==text.length())
                            Thread.sleep(500);
                        else
                            Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(i<=text.length())
                                    textView.setText(text.substring(0, i));
                                else{
                                    Intent mainIntent = new Intent(Startup.this, LoginNew.class);
                                    Startup.this.startActivity(mainIntent);
                                    overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
                                    Startup.this.finish();

                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();

    }

    private void hideNavigationBar() {

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
                .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View
                .SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View
                    .OnSystemUiVisibilityChangeListener() {

                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
        }

    }
}
