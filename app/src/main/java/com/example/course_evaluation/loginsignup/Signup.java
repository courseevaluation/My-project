package com.example.course_evaluation.loginsignup;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.course_evaluation.R;
import com.example.course_evaluation.customcomponent.CircleImageView;
import com.example.course_evaluation.util.Constants;
public class Signup extends AppCompatActivity implements View.OnClickListener {
    CircleImageView profilepic;
    TabItem stdtab,teachertab;
    TextView gologin;
    TabLayout tabLayout;
    LinearLayout student_template,teachertemplate;
    public static final int PICK_IMAGE=31,PIC_CROP=32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        setContentView(R.layout.loginsignup_activity_registration);
        profilepic=findViewById(R.id.signup_profile_picture);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickprofilepicfromgallery();
            }
        });
        gologin=findViewById(R.id.signup_loginbtn);
        gologin.setOnClickListener(this);
        student_template=findViewById(R.id.signup_student_templates);
        teachertemplate=findViewById(R.id.signup_teacher_templates);
        tabLayout=findViewById(R.id.signup_tablayout);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    if(student_template.getVisibility()== View.GONE){
                        student_template.setVisibility(View.VISIBLE);
                        teachertemplate.setVisibility(View.GONE);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        student_template.startAnimation(animation);
                    }
                }
                else{
                    if(teachertemplate.getVisibility()==View.GONE){
                        teachertemplate.setVisibility(View.VISIBLE);
                        student_template.setVisibility(View.GONE);
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        teachertemplate.startAnimation(animation);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
        student_template.startAnimation(animation);
    }

    private void pickprofilepicfromgallery() {

    }

    public void animatestdtab(){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        stdtab.startAnimation(animation);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup_loginbtn:
                onBackPressed();
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK && requestCode == PICK_IMAGE && data!=null) {

        }
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
