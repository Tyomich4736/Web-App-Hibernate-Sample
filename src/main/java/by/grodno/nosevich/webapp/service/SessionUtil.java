package by.grodno.nosevich.webapp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class SessionUtil {
    private static Session session;
    private static SessionFactory sessionFactory;

    public static Session openSession(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }

    public static Session getSession(){
        return session;
    }

    public static void shutDown(){
        session.close();
        sessionFactory.close();
    }
}
