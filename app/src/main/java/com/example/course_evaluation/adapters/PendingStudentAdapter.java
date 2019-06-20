package com.example.course_evaluation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.course_evaluation.R;
import com.example.course_evaluation.model.PendingModel;

import java.util.ArrayList;

public class PendingStudentAdapter extends RecyclerView.Adapter<PendingStudentAdapter.Viewholder> {
    ArrayList<PendingModel> pendinglist=new ArrayList<>();
    Context mcontext;

    public PendingStudentAdapter(Context mcontext) {
        this.mcontext = mcontext;
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
        pendinglist.add(new PendingModel("1712020177","Ariful Jannat Arif","pending"));
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.card_accept_decline_row,viewGroup,false);
        return new PendingStudentAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int i) {
        PendingModel pm=pendinglist.get(i);
        holder.name.setText(pm.getName());
        holder.id.setText(pm.getId());
    }
    @Override
    public int getItemCount() {
        return pendinglist.size()==0 ? 0 :pendinglist.size();
    }

    public class Viewholder extends  RecyclerView.ViewHolder{
        TextView name,id;
        Button accept;
        TextView decline;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.pending_row_name);
            id=itemView.findViewById(R.id.pending_row_id);
            accept=itemView.findViewById(R.id.pending_row_accept);
            decline=itemView.findViewById(R.id.pending_row_decline);
        }
    }
}
