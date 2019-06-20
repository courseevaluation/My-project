package com.example.course_evaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.course_evaluation.util.Constants;

public class Course_detailss_teacher extends AppCompatActivity {
        TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        setContentView(R.layout.activity_course_detailss_teacher);
        back=findViewById(R.id.course_details_backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
