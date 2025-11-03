package com.nimbus.hibernate;

import org.hibernate.*;
import org.hibernate.query.Query;

public class StudentCRUD {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // CREATE
            Student s1 = new Student();
            s1.setName("Riya");
            s1.setAge(21);
            session.save(s1);

            // READ
            Student s = session.get(Student.class, s1.getId());
            System.out.println("Fetched: " + s.getName() + ", Age: " + s.getAge());

            // UPDATE
            s.setAge(22);
            session.update(s);

            // DELETE
            // session.delete(s);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
