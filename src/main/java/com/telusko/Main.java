package com.telusko;


//import com.sun.tools.javac.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import java.util.List;

//public class Main {
//    public static void main() {
//        Student s1 = new Student();
//
//        s1.setRollNo(113);
//        s1.setSname("SANYA");
//        s1.setsAge(21);

//        Laptop l1 = new Laptop();
//        l1.setBrand("Asus");
//        l1.setModel("Rog");
//        l1.setRam(16);
//
//        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("Navin");
//        a1.setTech("Java");
//        a1.setLaptops(l1);

//        Student s2 = null;  //new Student();

//  Because,we use sf.openSession(); and sf is null,so we use Configuration as it is a class and we can make obj. of it.
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.telusko.Student.class);
//        cfg.configure("hibernate.cfg.xml");
//        Remove above 3 lines as we use in 1 line below:

//  Now make obj. of Configuration.
//  We need a session factory to use Session:
//        SessionFactory sf = null;
//  BELOW CODE IS THE 1 LINE CODE:
//        SessionFactory sf = new Configuration()
//                .configure()
//                .addAnnotatedClass(com.telusko.Student.class)
//                .addAnnotatedClass(com.telusko.Alien.class)
//                .addAnnotatedClass(com.telusko.Laptop.class)
//                .buildSessionFactory();
                //cfg.buildSessionFactory();
//        Session session = sf.openSession();

//  As "Session" is an interface we can't create direct object of Session so we mark it null for now:
//     Session session = null;

//  Save method hasbeen removed in 7.1.0 and deprecated in 6.6.3:

//  Cannot invoke "org.hibernate.Session.save(Object)" because "session" is null it will give NullPointerException.

//        GET OBJECT:
//        s1 = session.get(Student.class,113);
//        Transaction transaction = session.beginTransaction();
//
//        session.persist(l1);
//        session.persist(a1);

        //        THIS WILL UPDATE VALUE:
//        session.merge(s1);
//        REMOVE OBJECT:
//        session.remove(s1);

//  SAVE INSERT DATA BUT HAVE A WARNING PERSIST DON'T HAVE:
//    session.save(s1);
//    save(s1);
//      PERSIST INSERT DATA:
//        session.persist(s1);  COMMENT BY SHWETA


//        s2 = session.get(Student.class, 110);



//        Alien a2 = session.get(Alien.class, 101);
//        System.out.println(a2);
//
//
//        transaction.commit();
//        session.close();
//        sf.close();
//        System.out.println(s1);
//        System.out.println(s2);
//    }
//}


//_____________________________________________________________________________________________________________________



//import java.util.Arrays;

//public class Main {
//    public static void main(String[] args) {
//
//        Laptop l1 = new Laptop();
//        l1.setLid(73);
//        l1.setBrand("Asus");
//        l1.setModel("Rog");
//        l1.setRam(20);


//        Laptop l2 = new Laptop();
//        l2.setLid(74);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(30);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(75);
//        l3.setBrand("Apple");
//        l3.setModel("Mack book air");
//        l3.setRam(14);
//
//        Alien a1 = new Alien();
//        a1.setAid(144);
//        a1.setAname("kriti");
//        a1.setTech("css");
//
//
//        Alien a2 = new Alien();
//        a2.setAid(145);
//        a2.setAname("Naina");
//        a2.setTech("python");


//        Alien a3 = new Alien();
//        a3.setAid(132);
//        a3.setAname("harshit");
//        a3.setTech("html");


//        a1.setLaptops(Arrays.asList(l1, l2));
//        a2.setLaptops(Arrays.asList(l3));


//        l1.setAliens(Arrays.asList(a1,a3));
//        l2.setAliens(Arrays.asList(a1,a2));
//        l3.setAliens(Arrays.asList(a2));




//        SessionFactory sf = new Configuration()
//                .configure()
//                .addAnnotatedClass(com.telusko.Alien.class)
//                .addAnnotatedClass(com.telusko.Laptop.class)
//                .buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);

//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);

//        transaction.commit();
//
//        session.close();

//        Session session1 = sf.openSession();
//        Alien a5 = session.get(Alien.class, 140);
//        System.out.println(a5);
//        session.close();


//        sf.close();
//
//
//    }
//
//}

//_____________________________________________________________________________________________________________________


//public class Main {
//    public static void main(String[] args) {
//
//
//        SessionFactory sf = new Configuration()
//                .configure()
//                .addAnnotatedClass(com.telusko.Laptop.class)
//                .buildSessionFactory();
//
//        Session session = sf.openSession();

//   Select * from laptop where ram=32 ->SQL
//        from Laptop where ram=32 -> HQL

//
//        Query query = session.createQuery("from Laptop where brand = 'ASUS' ");
//        List<Laptop> laptops = query.getResultList();


//        Laptop l1=session.get(Laptop.class, 3);
//        System.out.println(laptops);
//        session.close();
//
//        sf.close();


//    }
//
//}

//_____________________________________________________________________________________________________


public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

//   Select * from laptop where ram=32 ->SQL
//        from Laptop where ram=32 -> HQL

        String brand = "Asus";

//        Query query = session.createQuery("from Laptop where brand like 'Asus' ");

        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);

//        List<Laptop> laptops = query.getResultList();
        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " : " + (String) data[1]);
        }
//        Laptop l1=session.get(Laptop.class, 3);


        System.out.println(laptops);
        session.close();

        sf.close();


    }

}