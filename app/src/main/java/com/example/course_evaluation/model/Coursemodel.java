package com.example.course_evaluation.model;

public class Coursemodel {
    private String c_name,c_code,c_teacher,c_batch,c_section,course_id="dummy";
    Object c_time;
    boolean c_status;
    public Coursemodel(){}
    public Coursemodel(String c_name, String c_code, String c_teacher, String c_batch, String c_section, Object c_time, boolean c_status) {
        this.c_name = c_name;
        this.c_code = c_code;
        this.c_teacher = c_teacher;
        this.c_batch = c_batch;
        this.c_section = c_section;
        this.c_time = c_time;
        this.c_status = c_status;
    }
    public Coursemodel(String c_name, String c_code, String c_teacher, String c_batch, String c_section, String course_id, Object c_time, boolean c_status) {
        this.c_name = c_name;
        this.c_code = c_code;
        this.c_teacher = c_teacher;
        this.c_batch = c_batch;
        this.c_section = c_section;
        this.course_id = course_id;
        this.c_time = c_time;
        this.c_status = c_status;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_teacher() {
        return c_teacher;
    }

    public void setC_teacher(String c_teacher) {
        this.c_teacher = c_teacher;
    }

    public String getC_batch() {
        return c_batch;
    }

    public void setC_batch(String c_batch) {
        this.c_batch = c_batch;
    }

    public String getC_section() {
        return c_section;
    }

    public void setC_section(String c_section) {
        this.c_section = c_section;
    }

    public Object getC_time() {
        return c_time;
    }

    public void setC_time(Object c_time) {
        this.c_time = c_time;
    }

    public boolean isC_status() {
        return c_status;
    }

    public void setC_status(boolean c_status) {
        this.c_status = c_status;
    }
}
