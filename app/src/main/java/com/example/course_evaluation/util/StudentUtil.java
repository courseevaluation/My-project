package com.example.course_evaluation.util;

import java.util.ArrayList;

public class StudentUtil {
    private static ArrayList<String> RegisteredCourse=new ArrayList<>();
    public static void addcourse(String id){ RegisteredCourse.add(id);}
    public static boolean isregistered(String id){
        if(RegisteredCourse.isEmpty()) {RegisteredCourse.add("dummy");}
        for(int i=0;i<RegisteredCourse.size();i++){
            if(RegisteredCourse.get(i).equals(id))return true;
        }
        return false;
    }
    public static ArrayList<String> getRegisteredCourse() {
        return RegisteredCourse;
    }
    public static void setRegisteredCourse(ArrayList<String> registeredCourse) {
        RegisteredCourse = registeredCourse;
    }
    public void clearregcourses(){
        RegisteredCourse.clear();
    }
}