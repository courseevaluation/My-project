package com.example.course_evaluation.teacher;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.course_evaluation.R;
import com.example.course_evaluation.customcomponent.CircleImageView;
import com.example.course_evaluation.util.Constants;

import java.util.ArrayList;


public class Teacher_search_adapter extends RecyclerView.Adapter<Teacher_search_adapter.Viewholder> implements Filterable {
    ArrayList<Teacher_model> teacher_list=new ArrayList<>();
    ArrayList<Teacher_model> filtered_list=new ArrayList<>();
    Animation animation;
    Context mContext;
    public Teacher_search_adapter(Context context){
        this.mContext=context;
        animation=AnimationUtils.loadAnimation(context,R.anim.recyclerview_anim);
        new load_teacher_list().execute();
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        System.out.println(i);
        View view=null;
        if(i==0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.card_teacher_search_item, viewGroup, false);
        }
        else{
            view = LayoutInflater.from(mContext).inflate(R.layout.card_teacher_search_item_right,viewGroup,false);}
        view.startAnimation(animation);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int i) {
        Teacher_model model=getitem(i);
        holder.tv1.setText(model.getName());
        holder.tv2.setText(model.getDesignation());
        holder.tv3.setText(model.getDepartment());
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0)
            return 1;
        else return 0;

    }

    @Override
    public int getItemCount() {
        return filtered_list.size()== 0 ? 0 : filtered_list.size();
    }
    public Teacher_model getitem(int pos){
        return filtered_list.get(pos);
    }




    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3;
        CircleImageView image;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.card_peaple_name);
            tv2=itemView.findViewById(R.id.card_peaple_designation);
            tv3=itemView.findViewById(R.id.card_peaple_department);
            image=itemView.findViewById(R.id.card_peaple_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

        }
    }
    class load_teacher_list extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Tahsan Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of CSE","facebook.com/mjarif97",null));
            teacher_list.add(new Teacher_model(Constants.getUserId(),"Abdullah Ahmed","cse.ariful@gmail.com","01766704060","Assistant proffessior","Department of EEE","facebook.com/mjarif97",null));
            filtered_list=teacher_list;
            return null;
        }
    }


    @Override
    public Filter getFilter() {


        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String qry=constraint.toString();
                if(qry.isEmpty())
                {
                    filtered_list=teacher_list;
                }else {
                    ArrayList<Teacher_model > list=new ArrayList<>();
                    for(Teacher_model model : teacher_list){
                        if(model.getName().toLowerCase().contains(qry) || model.getDepartment().toLowerCase().contains(qry))
                            list.add(model);

                    }
                    filtered_list=list;
                }

                FilterResults filterResults=new FilterResults();
                filterResults.values=filtered_list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();

            }
        };

    }


}
