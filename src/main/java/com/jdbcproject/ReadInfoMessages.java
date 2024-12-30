package com.jdbcproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadInfoMessages {
    private static final String URL = "jdbc:postgresql://localhost:5432/notices";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");

            while (true) {
                String selectSql = "SELECT id, message FROM notice WHERE type = 'INFO' AND processed = FALSE";
                try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
                    ResultSet resultSet = selectStatement.executeQuery();

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String message = resultSet.getString("message");
                        System.out.println("INFO: " + message);

                        String deleteSql = "DELETE FROM notice WHERE id = ?";
                        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                            deleteStatement.setInt(1, id);
                            deleteStatement.executeUpdate();
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
