package com.example.course_evaluation.teacher;

public class Teacher_model {
    String name,email,mobile,designation,department,facebook,userid,imageurl;
    public Teacher_model() { }
    public Teacher_model(String userid, String name, String email, String mobile, String designation, String department, String facebook, String imageurl) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.designation = designation;
        this.department = department;
        this.facebook = facebook;
        this.userid=userid;
        this.imageurl=imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
}
