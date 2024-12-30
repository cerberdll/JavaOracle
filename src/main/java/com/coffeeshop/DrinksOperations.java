package com.coffeeshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrinksOperations {
    public static void main(String[] args) {
        addDrink("Cappuccino", "Капучино", 5.00);
        listDrinks();
    }

    public static void addDrink(String nameEn, String nameLocal, double price) {
        String sql = "INSERT INTO Drinks (name_en, name_local, price) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameEn);
            statement.setString(2, nameLocal);
            statement.setDouble(3, price);
            statement.executeUpdate();
            System.out.println("Drink added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listDrinks() {
        String sql = "SELECT * FROM Drinks";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", English Name: " + resultSet.getString("name_en") +
                        ", Local Name: " + resultSet.getString("name_local") +
                        ", Price: $" + resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
