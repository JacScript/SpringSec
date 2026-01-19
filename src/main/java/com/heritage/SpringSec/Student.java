package com.heritage.SpringSec;

public class Student {
    private int id;
    private String name;
    private String mark;

    public Student(int id, String name, String mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
    }
}
