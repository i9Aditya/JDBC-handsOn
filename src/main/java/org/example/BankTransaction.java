package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransaction {

    void transferMoney(
            int fromAccount,
            int toAccount,
            double amount,
            Connection con) {

        try {
            con.setAutoCommit(false);

            // Deduct from sender
            try (PreparedStatement ps = con.prepareStatement(
                    "UPDATE accounts " +
                            "SET balance = balance - ? " +
                            "WHERE id = ?")) {

                ps.setDouble(1, amount);
                ps.setInt(2, fromAccount);

                int rows = ps.executeUpdate();

                if (rows == 0) {
                    throw new SQLException("Sender account not found");
                }
            }

            // Add to receiver
            try (PreparedStatement ps = con.prepareStatement(
                    "UPDATE accounts " +
                            "SET balance = balance + ? " +
                            "WHERE id = ?")) {

                ps.setDouble(1, amount);
                ps.setInt(2, toAccount);

                int rows = ps.executeUpdate();

                if (rows == 0) {
                    throw new SQLException("Receiver account not found");
                }
            }

            con.commit();

            System.out.println("Transfer successful!");

        } catch (SQLException e) {

            try {
                con.rollback();
                System.out.println("Transfer failed. Transaction rolled back.");
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }

            e.printStackTrace();
        }
    }
}