package com.momo.server;

/**
 * Author: liuzhiyuan
 * Date: 2019/10/29
 * Description:
 */
public class Student {
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
