package com.coffeeshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountQueries {

    // Минимальная скидка
    public static void getMinDiscount() {
        String sql = "SELECT MIN(discount) AS min_discount FROM Customers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                System.out.println("Minimum Discount: " + resultSet.getDouble("min_discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Максимальная скидка
    public static void getMaxDiscount() {
        String sql = "SELECT MAX(discount) AS max_discount FROM Customers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                System.out.println("Maximum Discount: " + resultSet.getDouble("max_discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Средняя скидка
    public static void getAverageDiscount() {
        String sql = "SELECT AVG(discount) AS avg_discount FROM Customers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                System.out.println("Average Discount: " + resultSet.getDouble("avg_discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Клиенты с минимальной скидкой
    public static void getCustomersWithMinDiscount() {
        String sql = "SELECT full_name, discount FROM Customers WHERE discount = (SELECT MIN(discount) FROM Customers)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Customer: " + resultSet.getString("full_name") +
                        ", Discount: " + resultSet.getDouble("discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Клиенты с максимальной скидкой
    public static void getCustomersWithMaxDiscount() {
        String sql = "SELECT full_name, discount FROM Customers WHERE discount = (SELECT MAX(discount) FROM Customers)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Customer: " + resultSet.getString("full_name") +
                        ", Discount: " + resultSet.getDouble("discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
