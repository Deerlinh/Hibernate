package com.kaishengit.pojo;

/**
 * Created by 蔡林红 on 2017/11/27.
 */
public class Mybatis {
    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Mybatis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clsId=" + clsId +
                '}';
    }

    private  Integer clsId;

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

    public Integer getClsId() {
        return clsId;
    }

    public void setClsId(Integer clsId) {
        this.clsId = clsId;
    }
}
