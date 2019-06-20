package com.example.course_evaluation.teacher;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.course_evaluation.R;
import com.example.course_evaluation.others.StringDataCollections;

public class Create_course_fragment extends DialogFragment {
    Context mContext;
    AutoCompleteTextView cname,ccode,csection;
    ArrayAdapter <String > coursenameadapter;
    ArrayAdapter <String > yearadapter;
    ArrayAdapter <String > semesteradapter;

    @SuppressLint("ValidFragment")
    public Create_course_fragment(Context mContext) {
        this.mContext = mContext;
    }

    public Create_course_fragment() { }
    public static Create_course_fragment newInstance(Context context){
        return new Create_course_fragment(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setGravity(Gravity.TOP | Gravity.LEFT | Gravity.RIGHT);
        View view=LayoutInflater.from(mContext).inflate(R.layout.fragment_create_course_layout,container,false);
        cname=view.findViewById(R.id.create_course_coursename);
        cname.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        ccode=view.findViewById(R.id.create_course_code);
        csection=view.findViewById(R.id.create_course_section);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.Createcoursedialog);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //getDialog().getWindow().getAttributes().windowAnimations=R.style.top_down_dialog_animation;
        initializeadapters(getActivity());
    }

    @Override
    public int getTheme() {
        return R.style.Createcoursedialog;
    }

    private void initializeadapters(Context context) {
        coursenameadapter=new ArrayAdapter<>(context,android.R.layout.simple_dropdown_item_1line);
        coursenameadapter.addAll(StringDataCollections.getCoursenames());
        cname.setAdapter(coursenameadapter);
    }
}
