package com.example.course_evaluation.customcomponent;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.course_evaluation.R;

public class MyprogressDialog extends Dialog {
    String messsage = "Loading Please wait";
    TextView msg;
    ProgressBar progressBar;
    Context mContext;
    boolean cancelable=true;

    public MyprogressDialog(Context context) {
        super(context);
        mContext = context;
    }
    public MyprogressDialog(Context context,String messsage) {
        super(context);
        mContext = context;
        this.messsage=messsage;
    }
    public MyprogressDialog(Context context,String messsage,boolean calcel) {
        super(context);
        mContext = context;
        this.messsage=messsage;
        this.cancelable=calcel;
    }

    public MyprogressDialog (Context context, int themeresid) {
        super(context, themeresid);
        mContext = context;
    }

    public MyprogressDialog(Context context, OnCancelListener onCancelListener, boolean cancellable) {
        super(context, cancellable, onCancelListener);
    }

    @Override
    public void onCreate(Bundle saveinstancestate) {
        super.onCreate(saveinstancestate);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customcomponent_progressdialog_view);
         msg = findViewById(R.id.progressdialog_message);
        msg.setText(Html.fromHtml(getMesssage()));
        progressBar = findViewById(R.id.progressdialog_progressbar);
        setCancelable(cancelable);
    }


    public void setLoading(boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
    }


    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.msg.setText(Html.fromHtml(messsage));
    }


}
