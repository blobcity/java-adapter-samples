package com.blobcity.demo.basic;

import com.blobcity.db.Db;
import com.blobcity.db.annotations.Entity;


@Entity(collection = "Sample")
public class Person extends Db {
    String _id; //auto defined primary key. This field is optional
    String name;
    int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
