package com.example.course_evaluation.others;

import java.util.ArrayList;
import java.util.HashMap;

public class StringDataCollections {
    static ArrayList< String > coursenames=new ArrayList<>();
    static HashMap<String,String> coursecodemap=new HashMap<>();
    static ArrayList<String> departmentnames = new ArrayList<>();
    static ArrayList<String> yearslist=new ArrayList<>();

    public StringDataCollections() {

    }
    static void loadCoursenames(){
        if(coursenames.size()==0){
            coursenames.add("Data Structure");
            coursecodemap.put("Data Structure","CSE 3212");
            coursenames.add("Theory of computation");
            coursecodemap.put("Theory of computation","CSE 2215");
            //.........
        }

    }
    static void loaddepartmentnames(){
        if(departmentnames.size()==0){
            departmentnames.add("Computer Science & Engineering");
            departmentnames.add("Civil Engineering");
            departmentnames.add("EEE");
            departmentnames.add("Business Administration");
            departmentnames.add("Architecture");
            departmentnames.add("English");
            departmentnames.add("Law");
            departmentnames.add("Islamic Studies");
            departmentnames.add("Public Health");
            departmentnames.add("Tourism and Hospitality Management");
        }
    }
    static void loadyear(){
        if(yearslist.size()==0){
            yearslist.add("2018");
            yearslist.add("2019");
            yearslist.add("2020");
            yearslist.add("2021");
            yearslist.add("2022");
            yearslist.add("2023");
            yearslist.add("2024");
            yearslist.add("2025");
            yearslist.add("2026");
            yearslist.add("2027");
            yearslist.add("2028");
            yearslist.add("2029");
        }
    }
    public static ArrayList<String> getCoursenames() {
        loadCoursenames();
        return coursenames;
    }

    public static void setCoursenames(ArrayList<String> coursenames) {
        StringDataCollections.coursenames = coursenames;
    }

    public static HashMap<String, String> getCoursecodemap() {
        return coursecodemap;
    }

    public static void setCoursecodemap(HashMap<String, String> coursecodemap) {
        StringDataCollections.coursecodemap = coursecodemap;
    }

    public static ArrayList<String> getDepartmentnames() {
        return departmentnames;
    }

    public static void setDepartmentnames(ArrayList<String> departmentnames) {
        StringDataCollections.departmentnames = departmentnames;
    }

    public static ArrayList<String> getYearslist() {
        return yearslist;
    }

    public static void setYearslist(ArrayList<String> yearslist) {
        StringDataCollections.yearslist = yearslist;
    }
}
