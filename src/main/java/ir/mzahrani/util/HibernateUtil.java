package ir.mzahrani.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory;

    private HibernateUtil() {
        // private constructor to prevent instantiation
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            //Thread a,b
            synchronized (HibernateUtil.class) {
                // Double check blocking
                if (sessionFactory == null) {
                    try {
                        String env = System.getProperty("app.env", "dev");
                        String configFile;

                        if ("test".equals(env)) {
                            configFile = "hibernate-test.cfg.xml";
                        } else {
                            configFile = "hibernate.cfg.xml";
                        }

                        Configuration cfg = new Configuration()
                                .configure(configFile);
                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(cfg.getProperties()).build();
                        sessionFactory = cfg.buildSessionFactory(serviceRegistry);
                    } catch (Exception e) {
                        throw new ExceptionInInitializerError(e);
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

