package com.ktb;

import static org.junit.Assert.assertTrue;

import com.ktb.domain.Customer;
import com.ktb.domain.Order;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void saveCustomerTest() {


        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Customer c = new Customer();
        c.setName("张三");

        // 2.2创建两个订单
        Order o1 = new Order();
        o1.setMoney(1000d);
        o1.setReceiverInfo("武汉");

        Order o2 = new Order();
        o2.setMoney(2000d);
        o2.setReceiverInfo("上海");

        // 2.3.2客户关联订单
        o1.setCustomer(c);
        o2.setCustomer(c);
        // 2.3.2客户关联订单
        session.save(c);
        session.save(o1);
        session.save(o2);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateCustomerTest() {

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        // 操作
       Customer customer =  session.get(Customer.class,1);
        customer.setName("xiaohu");
        session.update(customer);
       System.out.println(customer.toString());
        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    public void getCustomerTest() {

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        // 操作
        Customer customer =  session.get(Customer.class,2);
        System.out.println(customer.toString());
        Set orders = customer.getOrders();
        Iterator iterator = orders.iterator();
        while (iterator.hasNext()){
            Order next = (Order)iterator.next();
            System.out.println(next.toString());
        }




        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void findCustomerTest() {

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        // 操作
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_customer where name=?");
        sqlQuery.setParameter(0,"xiaohu");
        sqlQuery.addEntity(Customer.class);
        List<Customer> list =  sqlQuery.list();
        for(Customer customer:list){
            System.out.println(customer.toString());
        }
        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteCustomerTest() {

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Customer c = session.get(Customer.class, 2);
        // 得到客户的一个订单
        Order o = session.get(Order.class, 3);

        c.getOrders().remove(o);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void InnnerJionTest() {

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        String hql = "from Order o inner join o.customer";
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        for(Object[] objects:list){
            for (Object obj : objects) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        }
        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void  SessionFactoryTest() {
        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession(); // 相当于得到一个Connection
        session.beginTransaction();

        // 注意：fetch不可以与单独条件的with一起使用  //select distinct c from Customer c left outer join fetch c.orders where c.id=1
        List<Customer> list = session.createQuery("select distinct c from Customer c left outer join fetch c.orders where c.id=1").list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        session.getTransaction().commit();
        session.close();
    }
}
