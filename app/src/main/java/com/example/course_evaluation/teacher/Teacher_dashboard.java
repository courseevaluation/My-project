package com.example.course_evaluation.teacher;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_evaluation.My_profile_activity;
import com.example.course_evaluation.R;
import com.example.course_evaluation.Schedulemodel;
import com.example.course_evaluation.Setting;
import com.example.course_evaluation.ShowCourselist;
import com.example.course_evaluation.Teacher_schedule_adapter;
import com.example.course_evaluation.customcomponent.CircleImageView;
import com.example.course_evaluation.loginsignup.LoginNew;
import com.example.course_evaluation.util.Constants;
import com.example.course_evaluation.student.Search_student;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Locale;
public class Teacher_dashboard extends AppCompatActivity implements View.OnClickListener {
    SlidingPaneLayout mSlidingPanel;
    EditText search_btn;
    ListView schedulelist;
    CircleImageView profileimage;
    Locale myLocale;
    Toolbar toolbar;
    TextView createcourse,setting,profile,logout,showcourse,manage_schedule;
    Teacher_schedule_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_activity_teacher_dashboard);
        findviews();
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Dashboard");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_icon);
        }
        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.slidingpanel);
        mSlidingPanel.setParallaxDistance(100);
        mSlidingPanel.setPanelSlideListener(panelListener);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));
        schedulelist=findViewById(R.id.tdb_navigation_listview);
        adapter=new Teacher_schedule_adapter(this,additems());
        schedulelist.setAdapter(adapter);
    }
    private void findviews() {
        profileimage=findViewById(R.id.tdb_profile_image);
        profileimage.setOnClickListener(this);
        createcourse=findViewById(R.id.tdb_createcoursebtn);
        createcourse.setOnClickListener(this);
        search_btn=findViewById(R.id.td_search);
        search_btn.setOnClickListener(this);
        setting=findViewById(R.id.tdb_setting);
        setting.setOnClickListener(this);
        logout=findViewById(R.id.btnLogout);
        logout.setOnClickListener(this);
        showcourse=findViewById(R.id.tdb_showcoursebtn);
        showcourse.setOnClickListener(this);
        manage_schedule=findViewById(R.id.tdb_manage_schedule);
        manage_schedule.setOnClickListener(this);
    }
    ArrayList<Schedulemodel > additems(){
        ArrayList<Schedulemodel> schedulemodels=new ArrayList<>();
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D ","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D ","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D ","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D section","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D section","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D section","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D section","Department of CSE","309","Data Structure"));
        schedulemodels.add(new Schedulemodel("10:00 - 11:55","44 D section","Department of CSE","309","Data Structure"));
        return schedulemodels;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tdb_profile_image:
                startActivity(new Intent(Teacher_dashboard.this,My_profile_activity.class));
                overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                break;
            case R.id.tdb_setting:
                startActivity(new Intent(Teacher_dashboard.this, Setting.class));
                overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                break;
            case R.id.td_search:
                startActivity(new Intent(Teacher_dashboard.this, Search_student.class));
                overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                break;
            case R.id.tdb_createcoursebtn:
                new Create_course_fragment(Teacher_dashboard.this)
                        .show(getSupportFragmentManager(),"createcoursefragment");
                Toast.makeText(v.getContext(),"Create course ok",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut();
                finishAffinity();
                startActivity(new Intent(Teacher_dashboard.this, LoginNew.class));
                overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                finish();
                break;
            case R.id.tdb_showcoursebtn:
                startActivity(new Intent(Teacher_dashboard.this, ShowCourselist.class));
                overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                break;
            case R.id.tdb_manage_schedule:
                mSlidingPanel.openPane();
                break;
            default:
                Toast.makeText(v.getContext(),"clicklistenr callsed",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(mSlidingPanel.isOpen()){
                    mSlidingPanel.closePane();
                }else{
                    mSlidingPanel.openPane();
                }
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if(mSlidingPanel.isOpen()){
            mSlidingPanel.closePane();
        }else{
            super.onBackPressed();
        }
    }

    SlidingPaneLayout.PanelSlideListener panelListener = new SlidingPaneLayout.PanelSlideListener(){

        @Override
        public void onPanelClosed(View arg0) {
            // TODO Auto-genxxerated method stub

        }

        @Override
        public void onPanelOpened(View arg0) {

        }

        @Override
        public void onPanelSlide(View arg0, float arg1) {
            // TODO Auto-generated method stub

        }
    };
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
