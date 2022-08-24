package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    private static UserDao userDao = new UserDaoHibernateImpl();
    private  static  User user1 = new User("name1", "last_name1", (byte) 23);
    private  static  User user2 = new User("name2", "last_name2", (byte) 43);
    private  static  User user3 = new User("name3", "last_name3", (byte) 54);
    private  static  User user4 = new User("name4", "last_name4", (byte) 23);
    public static void main(String[] args) {

        userDao.createUsersTable();
        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        userDao.removeUserById(3);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
