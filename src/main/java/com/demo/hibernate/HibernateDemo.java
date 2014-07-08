package com.demo.hibernate;

import com.demo.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateDemo {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
//        user.setUserId(1);
        user.setUserName("Carl");
        user.setAddress("Monako");
        user.setJoinedDate(new Date());
        user.setDescription("it is cool guy");

//        UserDetails userDetails = new UserDetails();

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
//        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        System.out.println("FINIS");

        user = null;
        session = factory.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println("User name retrieved is " + user.getUserName());
        session.close();

//        factory.close();
    }
}
