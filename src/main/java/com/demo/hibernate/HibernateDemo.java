package com.demo.hibernate;

import com.demo.dto.FourWheeler;
import com.demo.dto.TwoWheeler;
import com.demo.dto.UserDetails;
import com.demo.dto.Vehicle;
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

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Jaguar");
        /*Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Cabriolet");
        user.getVehicles().add(vehicle1);
        user.getVehicles().add(vehicle2);*/

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandler("bike steering handler");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Car");
        car.setSteeringWheel("car steering wheel");

        demo.createUser(user, vehicle1, bike, car);
        System.out.println("USERS BEFORE UPDATE:");
        demo.listUsers();
        user.setUserName("Bruno Shults");
        user.setAddress("Germany");
        demo.updateUser(user);

        System.out.println("USERS AFTER UPDATE:");
        demo.listUsers();

        System.exit(1);
    }

    private UserDetails createUser(UserDetails userDetails, Vehicle ... vehicles) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction tx = session.beginTransaction();

        Integer id = (Integer) session.save(userDetails);
        userDetails.setUserId(id);

        for (Vehicle vehicle : vehicles) {
            session.save(vehicle);
        }

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
//        Query query = session.createQuery("from UserDetails");
//        query.setFirstResult(5);
//        query.setMaxResults(4);
        /*from UserDetails where userId > 5*/
        for (UserDetails user : users) {
            System.out.printf("ID: %d NAME: %s%n", user.getUserId(), user.getUserName());
        }
        tx.commit();
        HibernateSessionFactory.closeSession();
    }
}
