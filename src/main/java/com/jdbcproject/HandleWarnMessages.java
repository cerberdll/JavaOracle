package com.jdbcproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HandleWarnMessages {
    private static final String URL = "jdbc:postgresql://localhost:5432/notices";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");

            while (true) {
                String selectSql = "SELECT id, message FROM notice WHERE type = 'WARN' AND processed = FALSE";
                try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
                    ResultSet resultSet = selectStatement.executeQuery();

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String message = resultSet.getString("message");
                        System.out.println("WARN: " + message);

                        String updateSql = "UPDATE notice SET processed = TRUE WHERE id = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                            updateStatement.setInt(1, id);
                            updateStatement.executeUpdate();
                        }
                    }
                }

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
