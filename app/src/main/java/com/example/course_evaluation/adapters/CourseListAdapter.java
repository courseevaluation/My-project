package com.example.course_evaluation.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_evaluation.Course_detailss_teacher;
import com.example.course_evaluation.Course_request_page;
import com.example.course_evaluation.R;
import com.example.course_evaluation.model.Coursemodel;
import com.example.course_evaluation.util.StudentUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.Viewholder> {
    public ArrayList<Coursemodel> coursearray=new ArrayList<>();
    Context mcontext;

    public CourseListAdapter(Context mcontext) {
        this.mcontext = mcontext;
        adddummydata();
    }

    private void adddummydata() {
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
       coursearray.get(0).setCourse_id("bangla");
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));
        coursearray.add(new Coursemodel("Data Commuication","CSE-3112","Selina Sahrmin","44th","A,b,c,d,e","25/12/2018",true));

    }

    @NonNull
    @Override
    public CourseListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.card_showcourse_item,viewGroup,false);
        return new CourseListAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdapter.Viewholder holder, int i) {
        Coursemodel model=coursearray.get(i);
        holder.c_name.setText(model.getC_name());
        holder.c_code.setText(model.getC_code());
        holder.c_section.setText(model.getC_section());
        holder.c_create_date.setText((String)model.getC_time());
        holder.c_teacher.setText(model.getC_teacher());
        holder.c_batch.setText(model.getC_batch());
        if(model.isC_status())
            holder.c_status.setText("Spring 2019");
        else
            holder.c_status.setText("Ended!");
        // Animation zoomIn = AnimationUtils.loadAnimation(mcontext, R.anim.zoom_in);// animation file
        // holder.itemView.startAnimation(zoomIn);

    }
    @Override
    public int getItemCount() {
        return coursearray.size()==0 ? 0 : coursearray.size();
    }
    public Coursemodel getItem(int po){
        return coursearray.get(po);
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        TextView c_name,c_code,c_teacher,c_batch,c_section,c_status,c_create_date;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            c_name=itemView.findViewById(R.id.cc_course_name);
            c_batch=itemView.findViewById(R.id.cc_course_batch);
            c_teacher=itemView.findViewById(R.id.cc_course_teacher);
            c_code=itemView.findViewById(R.id.cc_course_code);
            c_create_date=itemView.findViewById(R.id.cc_course_create_time);
            c_section=itemView.findViewById(R.id.cc_course_sections);
            c_status=itemView.findViewById(R.id.cc_course_status);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Coursemodel coursemodel=getItem(getAdapterPosition());
                    if(StudentUtil.isregistered(coursemodel.getCourse_id()))
                    {
                        mcontext.startActivity(new Intent(mcontext, Course_detailss_teacher.class));
                    }else
                        new Course_request_page(mcontext).show();
                }
            });
        }

    }
    public class LoadCourse extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            notifyDataSetChanged();
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DatabaseReference ref=FirebaseDatabase.getInstance().getReference("/courses/");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Coursemodel coursemodel= (Coursemodel) snapshot.getValue();
                        coursearray.add(coursemodel);
                        Toast.makeText(mcontext,"Feed Refreshed..",Toast.LENGTH_SHORT);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(mcontext,"Error Updating Data,Try again",Toast.LENGTH_SHORT);
                }
            });
            return null;
        }
    }
}
