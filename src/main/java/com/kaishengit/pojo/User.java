package com.kaishengit.pojo;

import java.util.Set;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class User {
    private  Integer id;
    private  String userName;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    private Set<Address> addressSet;
}
