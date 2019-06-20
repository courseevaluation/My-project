package com.example.course_evaluation;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Switch;

import com.example.course_evaluation.util.Constants;

public class Setting extends AppCompatActivity {
    Switch darktoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_setting);
        setSupportActionBar(((Toolbar)findViewById(R.id.toolbar)));
        darktoggle=findViewById(R.id.setting_darktoggle);
        if(Constants.getUiMode()==0)darktoggle.setChecked(false);
        else darktoggle.setChecked(true);
        darktoggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(Constants.getMyPrefsName(), MODE_PRIVATE).edit();
                if(darktoggle.isChecked()) {
                    editor.putInt("uimode", R.style.mydarktheme);
                    Constants.setUiMode(R.style.mydarktheme);
                }
                else {
                    editor.putInt("uimode", R.style.mylighttheme);
                    Constants.setUiMode(R.style.mylighttheme);
                }
                editor.apply();
            }
        });

    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.fast_zoom_out,R.anim.no_anim);
    }

}
