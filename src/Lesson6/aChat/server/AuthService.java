package Lesson6.aChat.server;

import java.sql.*;

class AuthService {
    private static Connection connection;
    private static Statement stmt;

    static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB25102018.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname FROM USERS" +
                " WHERE login = '%s' AND password = '%s'", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

