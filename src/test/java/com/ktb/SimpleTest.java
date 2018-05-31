package com.ktb;

import com.ktb.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
public class SimpleTest {
    Session session;
    Transaction transaction;
    SessionFactory sessionFactory;
    @Before
    public  void init(){
        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        transaction = session.beginTransaction();
    }

    @After
    public  void end() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void saveNews() {

        News news = new News("Java12345", "ATGUIGU", new Date(new java.util.Date().getTime()));
        session.save(news);
    }

    @Test
    public void getNews() {
        News news = session.get(News.class, 1);
        System.out.println(news.toString());
    }

}
