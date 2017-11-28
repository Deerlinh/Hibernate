package com.kaishengit.pojo.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by 蔡林红 on 2017/11/27.
 */
public class MybatisUtil {

    private static SessionFactory sessionFactory= builderSessionFactory();

    private static SessionFactory builderSessionFactory() {
        Configuration configuration=new Configuration().configure();
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static  SessionFactory sessionFactory(){
        return  sessionFactory;
    }
    public   static Session session(){
        return  sessionFactory().getCurrentSession();
    }

}
