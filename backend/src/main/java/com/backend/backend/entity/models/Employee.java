package com.backend.backend.entity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int employee_id;
    String imageurl;
    String name;
    String job;

    

    public Employee() {
    }

    public Employee(int employee_id, String imageurl, String name, String job) {
        this.employee_id = employee_id;
        this.imageurl = imageurl;
        this.name = name;
        this.job = job;
    }

    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee employee_id(int employee_id) {
        setEmployee_id(employee_id);
        return this;
    }

    public Employee imageurl(String imageurl) {
        setImageurl(imageurl);
        return this;
    }

    public Employee name(String name) {
        setName(name);
        return this;
    }

    public Employee job(String job) {
        setJob(job);
        return this;
    }

}
