package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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


        Alien a1 = new Alien();
        a1.setAid(102);
        a1.setName("Rahul");
        a1.setTech("Python");
        a1.setLaptop(laptop);

        Alien a2 = null;

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(laptop);

        a2 = session.get(Alien.class, 102);

        transaction.commit();

        session.close();

        System.out.println(a2);

        System.out.println("This is mapping hibernate");

    }
}
