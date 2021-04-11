package ru.platon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/ishop";
    public static final String USER = "ishop";
    public static final String PASSWORD = "ishop";
    volatile Connection connection = null;
    static volatile Statement statement = null;

    public void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер PostgreSQL JDBC не обнаружен. Подключите драйвер для доступа к базе данных.");
            e.printStackTrace();
            return;
        }
        System.out.println("Драйвер PostgreSQL JDBC Driver успешно подключен.");

        {
            try {
                this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println("Не удалось установить соединение.");
            }
        }

        try {
            this.statement = connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Соединение установлено.");
        }

        if (this.connection != null) {
            System.out.println("Вы успешно подключились к базе.");
        } else {
            System.out.println("Не удалось подключиться к базе.");
        }
    }
}
