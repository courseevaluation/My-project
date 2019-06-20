package com.example.course_evaluation;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Teacher_schedule_adapter extends ArrayAdapter<Schedulemodel> {

    private Context mContext;
    private List<Schedulemodel> schedulemodels = new ArrayList<>();

    public Teacher_schedule_adapter( Context context,  ArrayList<Schedulemodel> list) {
         super(context, 0 , list);
        mContext = context;
      schedulemodels=list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.card_schedule_row,parent,false);
        Schedulemodel model = schedulemodels.get(position);
        final TextView time,room,department,section,cname,togglebtn;
        time=listItem.findViewById(R.id.schedule_time);
        time.setText(model.getTime());
        room=listItem.findViewById(R.id.schedule_room_no);
        room.setText("Room no : "+ model.getRoomno());
        department=listItem.findViewById(R.id.schedule_department);
        department.setText(model.getDepartment());
        section=listItem.findViewById(R.id.schedule_section);
        section.setText(model.getSection());
        cname=listItem.findViewById(R.id.schedule_course_name);
        cname.setText(model.getCourse_name());
        togglebtn=listItem.findViewById(R.id.schedule_toggle);
        togglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(togglebtn.getText().toString().equals(v.getResources().getString(R.string.turn_of_this_schedule_txt))){
                    togglebtn.setText(v.getResources().getString(R.string.turn_on_schedule_txt));
                    togglebtn.setTextColor(Color.RED);
                }else{
                    togglebtn.setText(v.getResources().getString(R.string.turn_of_this_schedule_txt));
                    togglebtn.setTextColor(Color.GREEN);
                }
            }
        });
        return listItem;
    }
    public void refresh(){

    }
}