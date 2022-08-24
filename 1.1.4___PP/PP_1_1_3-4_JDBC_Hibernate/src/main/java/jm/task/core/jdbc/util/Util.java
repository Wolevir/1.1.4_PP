package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

public class Util {
//    private final String URL = "jdbc:mysql://localhost:3306/my";
//    private final String USERNAME = "root";
//    private final String PASSWORD = "root";
//
//    public Connection getConnection() {
//        Connection connection = null;
//        if (connection == null) {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }

    private static SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        try {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/my_database");
            properties.setProperty("hibernate.connection.username", "wolevir");
            properties.setProperty("hibernate.connection.password", "wolevir");
            properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            sessionFactory =  new Configuration().
                    addProperties(properties).
                    addAnnotatedClass(User.class).
                    buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }



}