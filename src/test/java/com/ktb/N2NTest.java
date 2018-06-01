package com.ktb;

import com.ktb.n2n.Category;
import com.ktb.n2n.Item;
import com.ktb.subclass.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class N2NTest {
    Session session;
    Transaction transaction;
    SessionFactory sessionFactory;
    Logger logger = LoggerFactory.getLogger(N2NTest.class);
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
    public void save() {
        Category category1 = new Category();
        category1.setName("C-AA");

        Category category2 = new Category();
        category2.setName("C-BB");

        Item item1 = new Item();
        item1.setName("I-AA");

        Item item2 = new Item();
        item2.setName("I-BB");

        category1.getItems().add(item1);
        session.save(category1);
        session.save(item1);


    }

    /**
     * 原生SQL需要 addEntity()
     */
    @Test
    public void query() {
        Category category  = (Category) session.createQuery("from Category c where c.id = 1").uniqueResult();
        List<Item> items =  session.createSQLQuery("select item1_.* from CATEGORIES_ITEMS items0_ inner join items item1_ on items0_.I_ID=item1_.id where items0_.C_ID=?")
                 .addEntity(Item.class)
                .setParameter(0,category.getId())
                 .list();
        System.out.println(items);
    }
}
