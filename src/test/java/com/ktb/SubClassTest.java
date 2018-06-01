package com.ktb;

import com.ktb.one2oneforeign.Department;
import com.ktb.one2oneforeign.Manager;
import com.ktb.subclass.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SubClassTest {

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

    /**
     * ont to one 主键约束
     */
   /* @Test
    public void save() {

        Manager manager = new Manager("助长");
        session.save(manager);

        Department department =new Department("销售部");
        department.setMgr(manager);
        session.save(department);
    }


   */


    @Test
    public void save() {
        Student student = new Student("小强");
        session.save(student);

    }

    @Test
    public void query() {
        List<Student> from_student = session.createQuery("from Student").list();
        for(Student student :from_student){
            System.out.println(student.toString());
        }
    }
}
