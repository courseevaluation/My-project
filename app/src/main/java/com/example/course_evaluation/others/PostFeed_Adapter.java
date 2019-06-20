package com.example.course_evaluation.others;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class PostFeed_Adapter extends RecyclerView.Adapter<PostFeed_Adapter.Myviewholder> {

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
