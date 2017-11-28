package com.kaishengit.pojo;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class Person {
    private  Integer id;
    private String personName;
    private  Card card;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
