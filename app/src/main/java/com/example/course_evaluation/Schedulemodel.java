package com.example.course_evaluation;

public class Schedulemodel {

    String time,section,department,roomno,course_name;

    public Schedulemodel(String time, String section, String department, String roomno, String course_name) {
        this.time = time;
        this.section = section;
        this.department = department;
        this.roomno = roomno;
        this.course_name = course_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
