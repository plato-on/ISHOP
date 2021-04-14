package ru.platon.util;

import lombok.experimental.UtilityClass;

import java.sql.*;

@UtilityClass
public class JDBCUtils {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ishop";
    private static final String USER = "ishop";
    private static final String PASSWORD = "ishop";


    private Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер PostgreSQL JDBC не обнаружен. Установите драйвер для доступа к базе данных.");
            e.printStackTrace();
            return null;
        }
        System.out.println("Драйвер PostgreSQL JDBC Driver успешно подключен.");

        {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println("Не удалось установить соединение.");
            }
        }

        if (connection != null) {
            System.out.println("Вы успешно подключились к базе.");
        } else {
            System.out.println("Не удалось подключиться к базе.");
        }

        return connection;
    }

    public static Statement createStatement() {

        Connection connection = createConnection();
        Statement statement = null;

        if (connection == null) {
            System.out.println("Error");
            return null;
        }

        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Соединение установлено.");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Соединение не установлено.");
            return null;
        }

        return statement;
    }

}
