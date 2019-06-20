package com.example.course_evaluation;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.course_evaluation.util.Constants;

public class Student_DashBoard extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        setContentView(R.layout.activity_student__dash_board);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            //actionBar.setTitle("Menu");
            actionBar.setDisplayHomeAsUpEnabled(true);
            if(Constants.getUiMode()==0)
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
            else
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_icon);
        }
        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.stddb_slidepanel);
        mSlidingPanel.setParallaxDistance(80);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchbar_only,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(mSlidingPanel.isOpen()){
                    mSlidingPanel.closePane();
                }else mSlidingPanel.openPane();
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {

        if(mSlidingPanel.isOpen())mSlidingPanel.closePane();
        else   super.onBackPressed();
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.fast_zoom_out,R.anim.no_anim);
    }
}
