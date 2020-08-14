package com.example.jwt.demo.entity;

public class RespBean {
    private String messagge;
    private String status;

    public RespBean(String messagge, String status) {
        this.messagge = messagge;
        this.status = status;
    }

    public String getMessagge() {
        return messagge;
    }

    public void setMessagge(String messagge) {
        this.messagge = messagge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
