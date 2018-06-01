package com.ktb;

import com.ktb.query.Department;
import com.ktb.query.Employee;
import com.ktb.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QueryTest {
    Session session;
    Transaction transaction;
    SessionFactory sessionFactory;

    @Before
    public  void init(){
        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作

        sessionFactory = HibernateUtils.getInstance().getSessionFactory(); // 相当于得到一个Connection
        session = sessionFactory.openSession();
        // 开启事务
        transaction = this.session.beginTransaction();
    }


    @After
    public  void end() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    public void simpleSave(){
        //获取 Session
        //开启事务
        Department department = new Department();
        department.setName("销售部");
        Employee employee = new Employee();
        employee.setDept(department);
        employee.setEmail("1205150638@sina.com");
        employee.setName("xiaohu");
        employee.setSalary(126f);
        session.save(employee);
    }

    @Test
    public void testLeftJoinFetch2(){
        String hql = "SELECT e FROM Employee e LEFT JOIN e.dept";
        Query query = session.createQuery(hql);

        List<Object []> emps = query.list();
        System.out.println(emps.size());

        for(Object [] objs: emps){
            System.out.println(Arrays.asList(objs));
        }
    }

    @Test
    public void testLeftJoin(){
        String hql = "SELECT d  FROM Department d INNER JOIN d.emps";
        Query query = session.createQuery(hql);
        List<Department> result = query.list();
        for(Department objs: result){
            System.out.println(objs);
        }
    }


}
