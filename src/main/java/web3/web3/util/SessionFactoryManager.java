package web3.web3.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import web3.web3.entity.CoordinatesRow;

public class SessionFactoryManager {
    private static SessionFactory sessionFactory;

    private SessionFactoryManager() {}

    public static SessionFactory getSession() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(CoordinatesRow.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception in Session Factory Manager");
            }
        }
        return sessionFactory;
    }
}
