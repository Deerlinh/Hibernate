package com.kaishengit.test;

import com.kaishengit.pojo.Mybatis;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class CriteriaTest {

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
        Criteria criteria=session.createCriteria(Mybatis.class);
        List<Mybatis> list=criteria.list();
       showList(list);

    }
    @Test
    public void findBy(){
        Criteria criteria=session.createCriteria(Mybatis.class);

      /*  criteria.add(Restrictions.eq("id",3508));*/
        criteria.add(Restrictions.like("name","w", MatchMode.ANYWHERE));
      /*  criteria.add(Restrictions.eq("age",22));*/
        criteria.add(Restrictions.in("age", Arrays.asList(22,23)));
       /* Mybatis mybatis= (Mybatis) criteria.uniqueResult();
        System.out.println(mybatis);*/

       List<Mybatis > mybatis=criteria.list();
       showList(mybatis);
    }

    @Test
    public void findOrder(){
        Criteria criteria=session.createCriteria(Mybatis.class);

        criteria.addOrder(Order.desc("id"));
        criteria.addOrder(Order.asc("age"));

        List<Mybatis> list=criteria.list();
        showList(list);
    }

    @Test
    public void page(){
        Criteria criteria=session.createCriteria(Mybatis.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(5);
        List<Mybatis> mybatis=criteria.list();
        showList(mybatis);

    }
@Test
    public void count(){
     Criteria criteria= session.createCriteria(Mybatis.class);
    ProjectionList projectionList= Projections.projectionList();
    projectionList.add(Projections.rowCount());
    projectionList.add(Projections.avg("age"));
    criteria.setProjection(projectionList);

    Object[] data= (Object[]) criteria.uniqueResult();
    System.out.println("Rowcount" + data[0] );
    System.out.println("AVG"+data[1]);

    }


    private void showList(List<Mybatis> list) {
        for(Mybatis mybatis: list){
            System.out.println(mybatis);

        }
    }

}
