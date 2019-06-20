package com.example.course_evaluation.student;

public class Student_model {
    private String name,email,mobile,department,batch,stdid,userid,imageurl,facebook;
    public Student_model() { }

    public Student_model(String name, String email, String mobile, String department, String batch, String stdid, String userid, String imageurl, String facebook) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.department = department;
        this.batch = batch;
        this.stdid = stdid;
        this.userid = userid;
        this.imageurl = imageurl;
        this.facebook = facebook;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
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


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
