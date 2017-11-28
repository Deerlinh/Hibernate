package com.kaishengit.pojo;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class Card {
    private  Integer id;
    private String cardNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private  Person person;

}
