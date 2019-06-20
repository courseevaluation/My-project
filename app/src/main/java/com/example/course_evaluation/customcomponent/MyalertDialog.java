package com.example.course_evaluation.customcomponent;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.course_evaluation.R;


public class MyalertDialog extends Dialog {
    String messsage="",oktxt="",canceltxt="";
    TextView msg;
    ProgressBar progressBar;
    private View.OnClickListener yeslistener=null,nolistenr=null;
    Context mContext;
    TextView ok,cancel,btyes,btno;
    public MyalertDialog(Context context){
        super(context);
        mContext=context;
    }
    public MyalertDialog(Context context, String messsage){
        super(context);
        mContext=context;
        this.messsage=messsage;
    }
    public MyalertDialog(Context context,int themeresid){
        super(context,themeresid);
        mContext=context;
    }
    public MyalertDialog(Context context,OnCancelListener onCancelListener,boolean cancellable){
        super(context,cancellable,onCancelListener);
    }
    @Override
    public void onCreate(Bundle saveinstancestate){
        super.onCreate(saveinstancestate);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.customcomponent_dialog_layout_ok_cancel);
        msg=findViewById(R.id.dialog_ok_cancel_textview);
        msg.setText(messsage);
        btyes=findViewById(R.id.dialog_ok_cancel_ok_btn);
        btyes.setOnClickListener(yeslistener);
        btno=findViewById(R.id.dialog_ok_cancel_cancel_btn);
        nolistenr=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        };
        btno.setOnClickListener(nolistenr);
        btyes.setText(oktxt);
        progressBar=findViewById(R.id.dialog_ok_cancel_progress);
        btno.setText(canceltxt);
    }
    public  void setCancellable(boolean st){
        setCancelable(st);
    }
    public View.OnClickListener getYeslistener() {
        return yeslistener;
    }

    public void setPositiveButton(String txt,View.OnClickListener yeslistener) {
        this.oktxt=txt;
        this.yeslistener = yeslistener;
    }

    public View.OnClickListener getNolistenr() {
        return nolistenr;
    }

    public void setNegativeButton(String txt1,View.OnClickListener nolistenr) {
        this.nolistenr = nolistenr;
        this.canceltxt=txt1;
    }
    public void setLoading(boolean state){
        if(state){
            btyes.setVisibility(View.GONE);
            btno.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            btyes.setVisibility(View.VISIBLE);
            btno.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
        this.msg.setText(messsage);
    }

    public String getOktxt() {
        return oktxt;
    }

    public void setOktxt(String oktxt) {
        this.oktxt = oktxt;
    }

    public String getCanceltxt() {
        return canceltxt;
    }

    public void setCanceltxt(String canceltxt) {
        this.canceltxt = canceltxt;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public TextView getOk() {
        return ok;
    }

    public void setOk(TextView ok) {
        this.ok = ok;
    }

    public TextView getCancel() {
        return cancel;
    }

    public void setCancel(TextView cancel) {
        this.cancel = cancel;
    }
}
