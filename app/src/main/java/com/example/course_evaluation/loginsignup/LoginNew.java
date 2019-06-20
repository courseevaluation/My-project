package com.example.course_evaluation.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_evaluation.customcomponent.LoadingDialog;
import com.example.course_evaluation.customcomponent.MyalertDialog;
import com.example.course_evaluation.customcomponent.MyprogressDialog;
import com.example.course_evaluation.util.Constants;
import com.example.course_evaluation.R;
import com.example.course_evaluation.teacher.Teacher_dashboard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginNew extends AppCompatActivity {
    String mail,pass;int x=1;
    ImageView top_curve;
    EditText email,password;
    TextView email_text, password_text, login_title;
    ImageView logo;
    LinearLayout new_user_layout;
    CardView login_card;
    Button loginbtn;
    LoadingDialog loadingDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Constants.getUiMode());
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //hide the notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loginsignup_activity_login_new);
        top_curve = findViewById(R.id.top_curve);
        email = findViewById(R.id.email);
        email_text = findViewById(R.id.email_text);
        password = findViewById(R.id.password);
        password_text = findViewById(R.id.password_text);
        logo = findViewById(R.id.logo);
        login_title = findViewById(R.id.login_text);
        new_user_layout = findViewById(R.id.new_user_text);
        login_card = findViewById(R.id.login_card);
        Animation top_curve_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.top_to_down);
        top_curve.startAnimation(top_curve_anim);
        Animation editText_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.edittext_anim);
        email.startAnimation(editText_anim);
        password.startAnimation(editText_anim);
        Animation field_name_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.field_name_anim);
        email_text.startAnimation(field_name_anim);
        password_text.startAnimation(field_name_anim);
        logo.startAnimation(field_name_anim);
        login_title.startAnimation(field_name_anim);
        loginbtn=findViewById(R.id.login_button);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x==1){
                  //  if(loadingDialog==null)
                   // loadingDialog = new LoadingDialog(LoginNew.this);
                  //  loadingDialog.show();
                   // loadingDialog.dismiss();
                    startActivity(new Intent(LoginNew.this, Teacher_dashboard.class));
                    overridePendingTransition(R.anim.fast_zoom_in,R.anim.fade_out);
                }
                mail=email.getText().toString().trim();
                pass=password.getText().toString().trim();
                if(mail.isEmpty() || !mail.contains(".com") || !mail.contains("@") ){
                    email.setError("Invalid Email");
                    if(pass.trim().isEmpty())
                        password.setError("Invalid");
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        final MyprogressDialog progressdialog=new
                                MyprogressDialog(LoginNew.this,"Connecting...",false);
                        progressdialog.show();
                        if(!Constants.IsConnected()){
                            progressdialog.setMesssage("You are not connected to internet");
                            progressdialog.setLoading(false);
                            progressdialog.setCancelable(true);
                            return;
                        }
                        progressdialog.setMesssage("<font color='red'>Signing you in please wait</font>");
                        final FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                        firebaseAuth.signInWithEmailAndPassword(mail,pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            if(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
                                               /* startActivity(new Intent(LoginNew.this, TeacherDashboard.class));
                                                progressdialog.dismiss();
                                                finish();
                                                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                                                */
                                            }else{
                                                progressdialog.dismiss();
                                                final MyalertDialog dialog=new MyalertDialog(LoginNew.this,"Your email address is not verified<br> \n" +
                                                        "Sent Verification Email ?");
                                                dialog.setCancelable(false);
                                                dialog.setPositiveButton("Send mail again", new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification();
                                                        FirebaseAuth.getInstance().signOut();
                                                        dialog.dismiss();
                                                    }
                                                });
                                                dialog.setNegativeButton("cancel", new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        FirebaseAuth.getInstance().signOut();
                                                        dialog.dismiss();
                                                    }
                                                });
                                                dialog.show();
                                            }
                                        }else{
                                            progressdialog.setMesssage("<font color='red' fontsize='15px'>The Email and Password Doesnt Match</font>");
                                            progressdialog.setCancelable(true);
                                            progressdialog.setLoading(false);
                                        }
                                    }
                                });

                    }
                }).run();
            }
        });

        Animation center_reveal_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.center_reveal_anim);
        login_card.startAnimation(center_reveal_anim);

        Animation new_user_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down_top);
        new_user_layout.startAnimation(new_user_anim);

    }

    public void register(View view) {
        startActivity(new Intent(this, Signup.class));
        overridePendingTransition(R.anim.fast_zoom_in,R.anim.no_anim);
    }

    public void loginButton(View view) {
        Toast.makeText(this,"Login Clicked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.no_anim,R.anim.fast_zoom_out);
    }
}
