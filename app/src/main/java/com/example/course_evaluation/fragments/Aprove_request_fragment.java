package com.example.course_evaluation.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.course_evaluation.R;
import com.example.course_evaluation.adapters.PendingStudentAdapter;
import com.example.course_evaluation.customcomponent.MyalertDialog;

public class Aprove_request_fragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    Button approveall,declineall;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.aproval_pager_layout,container,false);
        recyclerView=view.findViewById(R.id.recyclerview_aproval_page);
        PendingStudentAdapter pendingStudentAdapter=new PendingStudentAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(pendingStudentAdapter);
        approveall=view.findViewById(R.id.approval_page_approve_all);
        approveall.setOnClickListener(this);
        declineall=view.findViewById(R.id.approval_page_decline_all);
        declineall.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.approval_page_approve_all:
                proceedapproveall();
                break;
            case R.id.approval_page_decline_all:
                proceedDeclineall();
                break;
        }
    }

    private void proceedDeclineall() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure\n want to Decline All ?")
                .setTitle("Caution")
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setCancelable(false);
        builder.show();

    }
    private void proceedapproveall() {
        final MyalertDialog dialog=new MyalertDialog(getActivity());
        dialog.setMesssage("Are you sure <br>" +
                "want to <font color='red';size='18' > Accept All </font> request ?");
        dialog.setPositiveButton("Approve", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setLoading(
                        true
                );
                // dialog.dismiss();

            }
        });
        dialog.setCancelable(false);
        dialog.setNegativeButton("cancel",null);
        dialog.show();
    }
}
