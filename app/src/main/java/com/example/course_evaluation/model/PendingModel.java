package com.example.course_evaluation.model;

public class PendingModel {
    String id,name,batch,status;

    public PendingModel(String id, String name, String batch, String status) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.status = status;
    }

    public PendingModel(String id, String name, String batch) {
        this.id = id;
        this.name = name;
        this.batch = batch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
