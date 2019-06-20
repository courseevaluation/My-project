package com.example.course_evaluation.student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.course_evaluation.R;
import com.example.course_evaluation.util.Constants;

public class Search_student extends AppCompatActivity {
    RecyclerView recyclerView;Student_search_adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.student_search_student);
        recyclerView=findViewById(R.id.recyclerview_search_student);
        adapter =new Student_search_adapter(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Search Student info");
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
    private void search(SearchView searchView) {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
