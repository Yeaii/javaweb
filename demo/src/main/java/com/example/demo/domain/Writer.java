package com.example.demo.domain;

import jakarta.persistence.*;

import java.sql.Date;


@Table(name="writer")
@Entity
public class Writer {
    // 注意属性名要与数据表中的字段名一致
    // 主键自增int(10)对应long

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wid;

    private Date date;
    // 用户名属性varchar对应String
    private String wname;

    // 密码属性varchar对应String
    private String province;

    private String city;
    private String address;
    private String zipcode;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}