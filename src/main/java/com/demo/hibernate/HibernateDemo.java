package com.demo.hibernate;

import com.demo.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        HibernateDemo demo = new HibernateDemo();

        UserDetails user = new UserDetails();
        user.setUserName("Carl");
        user.setAddress("Monako");
        user.setJoinedDate(new Date());
        user.setDescription("it is cool guy");

        demo.createUser(user);
        demo.listUsers();
        user.setUserName("Bruno Shults");
        user.setAddress("Germany");
        demo.updateUser(user);

        demo.listUsers();
    }

    private UserDetails createUser(UserDetails userDetails) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction tx = session.beginTransaction();

        Integer id = (Integer) session.save(userDetails);
        userDetails.setUserId(id);

        tx.commit();
        HibernateSessionFactory.closeSession();
        return userDetails;
    }

    private void updateUser(UserDetails userDetails) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction tx = session.beginTransaction();

        UserDetails dbUser = (UserDetails) session.get(UserDetails.class, userDetails.getUserId());
        dbUser.setUserName(userDetails.getUserName());
        dbUser.setAddress(userDetails.getAddress());
        dbUser.setDescription(userDetails.getDescription());
        dbUser.setJoinedDate(userDetails.getJoinedDate());

        session.flush();
        tx.commit();
        HibernateSessionFactory.closeSession();
    }

    private void listUsers() {
        Session session = HibernateSessionFactory.currentSession();
        Transaction tx = session.beginTransaction();

        @SuppressWarnings("unchecked") // from Users table we able to take only users
        List<UserDetails> users = session.createQuery("from UserDetails").list();

        for (UserDetails user : users) {
            System.out.printf("ID: %d NAME: %s%n", user.getUserId(), user.getUserName());
        }
        tx.commit();
        HibernateSessionFactory.closeSession();
    }
}
