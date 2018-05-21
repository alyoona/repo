package com.stroganova.io.serializationdataoutputstream;

import java.util.Date;

public class Message {

    private int id;
    private Date date = new Date();
    private String content;


    public int getId() {
        return id;
    }

    public long getDate() {
        return date.getTime();
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
