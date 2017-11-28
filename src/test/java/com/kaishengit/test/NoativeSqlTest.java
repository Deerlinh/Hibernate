package com.kaishengit.test;

import com.kaishengit.pojo.Mybatis;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class NoativeSqlTest {
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
    public void findByAll(){
        String sql="select * from mybatis order by id desc";

        SQLQuery query=session.createSQLQuery(sql);

        List<Object[]> list= query.list();
        for(Object[] data: list){
            System.out.println(data[0] +"->"+data[1]+"->"+data[2]);
        }
    }

    @Test
    public void findById(){
        String sql="select * from mybatis where id =? order by id desc";
        SQLQuery sqlQuery=session.createSQLQuery(sql).addEntity(Mybatis.class);

        sqlQuery.setParameter(0,3508);
        List<Mybatis> list=sqlQuery.list();
        showList(list);
    }



    private void showList(List<Mybatis> list) {
        for(Mybatis mybatis:list){

            System.out.println(mybatis);
        }
    }
}
