package com.example.course_evaluation;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

public class Course_request_page extends Dialog {
    public Course_request_page(Context context) {
        super(context);
    }

    public Course_request_page(Context context, int themeResId) {
        super(context, themeResId);
    }

    public Course_request_page(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.course_request_page);
    }
}
