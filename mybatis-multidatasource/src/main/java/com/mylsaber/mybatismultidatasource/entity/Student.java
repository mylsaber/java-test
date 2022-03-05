package com.mylsaber.mybatismultidatasource.entity;

/**
 * @author jfw
 */
public class Student {
    private int id;
    private String name;
    private int gender;

    public Student() {
    }

    public Student(int id, String name, int getder) {
        this.id = id;
        this.name = name;
        this.gender = getder;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int getder) {
        this.gender = getder;
    }
}
