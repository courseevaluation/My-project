package com.example.course_evaluation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.course_evaluation.R;
import com.example.course_evaluation.adapters.ApprovestudentListAdapter;

public class Course_student_list_fragment extends Fragment {
    RecyclerView student_list_recycler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ContextThemeWrapper wrapper=new ContextThemeWrapper(getActivity(), R.style.mydarktheme);
        LayoutInflater minflater=inflater.cloneInContext(wrapper);
        View view=minflater.inflate(R.layout.course_student_list,container,false);
        student_list_recycler=view.findViewById(R.id.recyclerview_approved_student_list);
        ApprovestudentListAdapter adapter=new ApprovestudentListAdapter(getActivity());
        student_list_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        student_list_recycler.setAdapter(adapter);
        return view;
    }
}
