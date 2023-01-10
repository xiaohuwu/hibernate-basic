package com.ktb.manytoone;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;


    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet();


    public Set getOrders() {
        return orders;
    }


    public void setOrders(Set orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}