package com.example.course_evaluation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.course_evaluation.customcomponent.SquareImageView;
import com.example.course_evaluation.util.Constants;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class My_profile_activity extends AppCompatActivity {
    Toolbar toolbar;
    Button changepass;
    LinearLayout changepasspanel;
    SquareImageView profilepic;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        setContentView(R.layout.activity_profile);
        profilepic=findViewById(R.id.profile_image);
        toolbar=findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Ashraful Islam");
            actionBar.setSubtitle("student");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Glide.with(this)
                .load(R.drawable.sample_pp3)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(30,5)))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        profilepic.setBackground(resource);
                        // profilepic.setForeground(getDrawable(R.drawable.sample_pp3));
                    }
                });
        changepasspanel=findViewById(R.id.profile_changepass_panel);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchbar_only,menu);
        return true;
    }

    public void toggle_change_pass_panel(View view) {
        if(changepasspanel.getVisibility()==View.GONE){
            changepasspanel.setVisibility(View.VISIBLE);
        }else{
            changepasspanel.setVisibility(View.GONE);
        }
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
