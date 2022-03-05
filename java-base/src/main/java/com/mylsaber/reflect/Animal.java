package com.mylsaber.reflect;

import org.omg.PortableInterceptor.INACTIVE;

public class Animal {
    private Integer id;
    public String name;

    public Animal() {
    }

    private Animal(String name) {
        this.name = name;
    }

    public Animal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
