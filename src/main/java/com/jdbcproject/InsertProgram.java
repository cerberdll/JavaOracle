package com.jdbcproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.Random;

public class InsertProgram {
    private static final String URL = "jdbc:postgresql://localhost:5432/notices";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        String[] types = {"INFO", "WARN"};
        Random random = new Random();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");

            while (true) {
                String type = types[random.nextInt(types.length)];
                String message = type.equals("INFO")
                        ? "Новое сообщение от " + LocalDateTime.now()
                        : "Произошла ошибка в " + LocalDateTime.now();

                String sql = "INSERT INTO notice (message, type, processed) VALUES (?, ?, FALSE)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, message);
                    statement.setString(2, type);
                    statement.executeUpdate();
                }

                System.out.println("Inserted: " + message);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
