package com.coffeeshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderOperations {

    public static void addOrder(int customerId, String itemType, int itemId, int quantity, double totalPrice) {
        String insertOrder = "INSERT INTO Orders (customer_id, order_date, total_price) VALUES (?, CURRENT_DATE, ?)";
        String insertOrderDetails = "INSERT INTO OrderDetails (order_id, item_type, item_id, quantity) VALUES (currval('orders_id_seq'), ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement orderStmt = connection.prepareStatement(insertOrder);
             PreparedStatement detailsStmt = connection.prepareStatement(insertOrderDetails)) {

            orderStmt.setInt(1, customerId);
            orderStmt.setDouble(2, totalPrice);
            orderStmt.executeUpdate();

            detailsStmt.setString(1, itemType);
            detailsStmt.setInt(2, itemId);
            detailsStmt.setInt(3, quantity);
            detailsStmt.executeUpdate();

            System.out.println("Order added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listOrders() {
        String sql = "SELECT * FROM Orders";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Order ID: " + resultSet.getInt("id") +
                        ", Customer ID: " + resultSet.getInt("customer_id") +
                        ", Order Date: " + resultSet.getDate("order_date") +
                        ", Total Price: $" + resultSet.getDouble("total_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
