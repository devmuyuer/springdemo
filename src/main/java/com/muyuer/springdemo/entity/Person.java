package com.muyuer.springdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by muyuer
 * Time: 2018-11-30 14:22
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private  Integer id;
    private String name;
    private Integer age;

    //必须要有构造函数
    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}