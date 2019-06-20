package com.example.course_evaluation.teacher;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.course_evaluation.R;
import com.example.course_evaluation.util.Constants;

public class Search_teacher extends AppCompatActivity {
    public static Teacher_search_adapter adapter;
    public  static ProgressBar progressBar;
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        setContentView(R.layout.teacher_activity_search_teacher);
        progressBar=findViewById(R.id.search_techer_progressbar);
        recyclerView=findViewById(R.id.recyclerview_search_teacher);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Teacher_search_adapter(this);
        getSupportActionBar().setTitle("Search Teacher info");
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchbar_only,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        search(searchView);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;


        }
        return  true;
    }
    public  void search(SearchView searchView){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()){
                    adapter.getFilter().filter("");
                }
                return true;
            }
        });
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
