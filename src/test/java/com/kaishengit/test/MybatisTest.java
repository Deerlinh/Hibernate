package com.kaishengit.test;

import com.kaishengit.pojo.Mybatis;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by 蔡林红 on 2017/11/27.
 */
public class MybatisTest {

    @Test
    public void save(){
        Session session= MybatisUtil.session();
        session.beginTransaction();

        Mybatis mybatis=new Mybatis();
        mybatis.setName("jake");
        mybatis.setAge(23);
        mybatis.setClsId(2);
       session.save(mybatis);
        session.getTransaction().commit();

    }

}
