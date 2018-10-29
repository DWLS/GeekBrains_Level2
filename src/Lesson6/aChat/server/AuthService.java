package Lesson6.aChat.server;

import java.sql.*;
import java.util.Objects;

class AuthService {
    private static Connection connection;
    private static Statement stmt;

    static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB25102018.db");
            System.out.println("БД подключена!");
            stmt = connection.createStatement();
            System.out.println("Соединение с БД установлено!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname FROM USERS" +
                " WHERE login = '%s' AND password = '%s'", login, pass);
        try {
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(Objects.requireNonNull(rs).next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void disconnect() {
        try {
            connection.close();
            System.out.println("Соединение с БД закрыто!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}