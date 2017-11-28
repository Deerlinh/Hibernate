package com.kaishengit.test;

import com.kaishengit.pojo.Address;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class OneToManyTest {

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
    public  void  findByAddress(){
        Address address= (Address) session.get(Address.class,1);
        System.out.println(address.getAddress()+ "----"+address.getCityName());

        User user=address.getUser();
        System.out.println(user.getUserName()+ "----"+user.getId());
    }

    @Test
    public void findUser(){
       User user = (User) session.get(User.class,1);

        System.out.println(user.getUserName());

        Set<Address> addresses=user.getAddressSet();
        for(Address address:addresses){
            System.out.println(address.getId() + "=====" + address.getCityName()+"----"+address.getAddress());
        }
    }


    @Test
    public void save(){
        User user=new User();
        user.setUserName("jakes");

        Address address=new Address();
        address.setAddress("新正街");
        address.setCityName("河南");
        address.setUser(user);

        Address address2 = new Address();
        address2.setCityName("洛杉矶");
        address2.setAddress("莫宁路110号");
        address2.setUser(user);

        Set<Address> addresses=new HashSet<Address>();
        addresses.add(address);
        addresses.add(address2);

        user.setAddressSet(addresses);

        session.save(user);
        session.save(address);





    }

    @Test
    public void delete(){
        Criteria criteria=session.createCriteria(Address.class);
        criteria.add(Restrictions.eq("user.id",7));

        List<Address> addresses=criteria.list();
        for(Address address: addresses){
            session.delete(address);
        }

        User user= (User) session.get(User.class,7);
        session.delete(user);

    }

    @Test
    public void delete2(){
        User user= (User) session.get(User.class,3);
        session.delete(user);
        //在hbm.xml中配置 cascade="delete" 级联删除
    }
}
