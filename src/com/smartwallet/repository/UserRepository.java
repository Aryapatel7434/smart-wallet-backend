package com.smartwallet.repository;

import com.smartwallet.db.DBConnection;
import com.smartwallet.model.User;
import com.smartwallet.model.Wallet;
import java.sql.*;

public class UserRepository {

    public int insertUser(User user) {
        int userId = -1;

        String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                userId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }

    public void createWallet(int userId, String walletAddress) {

        String sql = "INSERT INTO wallets(user_id, balance, wallet_address) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setDouble(2, 0.00);
            ps.setString(3, walletAddress);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Wallet getWalletByEmail(String email) {

        String sql = """
                     SELECT w.wallet_id, w.user_id, w.balance, w.wallet_address
                     FROM users u
                     JOIN wallets w ON u.user_id = w.user_id
                     WHERE u.email = ?
                     """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Wallet(
                        rs.getInt("wallet_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("balance"),
                        rs.getString("wallet_address")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}