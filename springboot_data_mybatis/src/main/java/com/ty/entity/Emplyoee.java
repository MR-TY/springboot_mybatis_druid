package com.ty.entity;

/**
 * Created by Administrator on 2018/5/11.
 */
public class Emplyoee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getdId() {
        return dId;
    }
}
