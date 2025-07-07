package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = new Employee("Reethika", "B", 75000);
            session.save(emp);

            List<Employee> list = session.createQuery("from Employee").list();
            for (Employee e : list) {
                System.out.println(e);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
