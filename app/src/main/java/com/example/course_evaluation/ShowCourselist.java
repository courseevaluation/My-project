package com.example.course_evaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.example.course_evaluation.adapters.CourseListAdapter;
import com.example.course_evaluation.util.Constants;

public class ShowCourselist extends AppCompatActivity {
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_show_courselist);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        recyclerView=findViewById(R.id.showcourselist_recyclerview);
        CourseListAdapter adapter= new CourseListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
