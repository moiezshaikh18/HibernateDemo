package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        // Creating a new student instance
//        NewStudent student = new NewStudent();
//        student.setSname("Kiran");
//        student.setRoll_no(102);
//        student.setAge(29);
//
//        NewStudent newStudent = null;
//
//        // Optimized Configuration setup
//        // Configuration configuration = new Configuration();
//        // configuration.addAnnotatedClass(org.example.NewStudent.class);
//        // configuration.configure();
//
//        SessionFactory sessionFactory = new Configuration()
//                .addAnnotatedClass(org.example.NewStudent.class)
//                .configure()
//                .buildSessionFactory(); // configuration.buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//
//        // Retrieve data from the database
//        newStudent = session.get(NewStudent.class, 105);
//
//        // Update existing student data
//        session.merge(student);
//
//        //Removing data from student table
//        session.remove(newStudent);
//
//        Transaction transaction = session.beginTransaction();
//
//        // Persisting new student data
//        // session.persist(student);
//
//        transaction.commit();
//
//        // Closing session and session factory
//        session.close();
//        sessionFactory.close();
//
//        // Output retrieved student details
//        System.out.println(newStudent);


        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setBrand("Dell");
        laptop.setModel("Insprision");
        laptop.setRam(4);


        Laptop laptop1 = new Laptop();
        laptop.setLid(3);
        laptop.setBrand("Ryzon");
        laptop.setModel("gup");
        laptop.setRam(9);

        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setBrand("Lenovo");
        laptop2.setModel("IDeapad");
        laptop2.setRam(10);


        Alien a1 = new Alien();
        a1.setAid(103);
        a1.setName("Ramesh");
        a1.setTech("java");
//        a1.setLaptop(laptop);
        a1.setLaptops(List.of(laptop,laptop1,laptop2));

        Alien a2 = new Alien();
        a2.setAid(104);
        a2.setName("Yogesh");
        a2.setTech("IOS");
        a2.setLaptops(List.of(laptop,laptop2));

        Alien a4 = new Alien();
        a4.setAid(102);
        a4.setName("Kiran");
        a4.setTech("Android");
        a4.setLaptops(List.of(laptop1));

//        laptop.setAlien(a1);
//        laptop1.setAlien(a1);

        laptop.setAlien(List.of(a1,a2));
        laptop1.setAlien(List.of(a2,a4));
        laptop.setAlien(List.of(a4));

        Alien a3 = null;

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(a4);
        session.persist(laptop);
        session.persist(laptop1);
        session.persist(laptop2);

        a3 = session.get(Alien.class, 102);

        transaction.commit();

        session.close();

        System.out.println(a3);

        System.out.println("This is mapping hibernate");

    }
}
