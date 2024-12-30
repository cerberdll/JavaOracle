package com.coffeeshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleOperations {

    public static void addSchedule(int staffId, String workDate, String shiftStart, String shiftEnd) {
        String sql = "INSERT INTO Schedule (staff_id, work_date, shift_start, shift_end) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staffId);
            statement.setString(2, workDate);
            statement.setString(3, shiftStart);
            statement.setString(4, shiftEnd);
            statement.executeUpdate();
            System.out.println("Schedule added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listSchedules() {
        String sql = "SELECT * FROM Schedule";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Schedule ID: " + resultSet.getInt("id") +
                        ", Staff ID: " + resultSet.getInt("staff_id") +
                        ", Work Date: " + resultSet.getDate("work_date") +
                        ", Shift Start: " + resultSet.getTime("shift_start") +
                        ", Shift End: " + resultSet.getTime("shift_end"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
