package com.kaishengit.test;

import com.kaishengit.pojo.Card;
import com.kaishengit.pojo.Person;
import com.kaishengit.pojo.Post;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class OneToOneTest {

    private Session session;
    @Before
    public void before() {
        session = MybatisUtil.session();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }

    @Test
    public void save(){
        Person person=new Person();
        person.setPersonName("jim");


        Card card=new Card();
        card.setCardNum("23wdsdsdsfdgdfgdfsadfsad");

        card.setPerson(person);
        session.save(person);
        session.save(card);
    }

    @Test
    public void findBy(){
        Person person= (Person) session.get(Person.class,2);
        System.out.println( person.getCard().getCardNum());
        System.out.println(person.getPersonName());

    }

    @Test
    public  void delete(){
            Person person= (Person) session.get(Person.class,3);
            session.delete(person);
    }

    @Test
    public void findByPost() {
        Post post = (Post) session.get(Post.class,3);
        System.out.println(post.getTitle());
        System.out.println(post.getPostContent().getContent());
    }
}
