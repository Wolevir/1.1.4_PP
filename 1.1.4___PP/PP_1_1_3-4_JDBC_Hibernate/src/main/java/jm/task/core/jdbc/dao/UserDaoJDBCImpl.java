//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl extends Util implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//    Connection connection = getConnection();
//
//    public void createUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS USERS (ID BIGINT PRIMARY KEY AUTO_INCREMENT, " +
//                    "NAME VARCHAR(255), " +
//                    "LASTNAME VARCHAR(255), " +
//                    "AGE INT)");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DROP TABLE IF EXISTS USERS");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (NAME, LASTNAME, AGE) VALUES (?, ?, ?)")) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?")) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> listUsers = new ArrayList<>();
//        try (ResultSet resultSet = connection.prepareStatement("SELECT * FROM USERS").executeQuery()) {
//            while (resultSet.next()) {
//                User user = new User(resultSet.getString("NAME"),
//                        resultSet.getString("LASTNAME"),
//                        resultSet.getByte("AGE"));
//                user.setId(resultSet.getLong("ID"));
//                listUsers.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for (User user : listUsers) {
//            System.out.println(user);
//        }
//        return listUsers;
//    }
//
//    public void cleanUsersTable() {
//        try (Statement statement = connection.createStatement()){
//            statement.executeUpdate("TRUNCATE TABLE USERS");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
