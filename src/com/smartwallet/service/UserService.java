package com.smartwallet.service;

import com.smartwallet.model.User;
import com.smartwallet.model.Wallet;
import com.smartwallet.repository.UserRepository;

public class UserService {

    private UserRepository repository = new UserRepository();

    public void registerUser(String name, String email, String password) {

        User user = new User(name, email, password);

        int userId = repository.insertUser(user);

        if (userId != -1) {
            String walletAddress = "WALLET_" + name.toUpperCase() + "_" + userId;

            repository.createWallet(userId, walletAddress);

            System.out.println("User registered successfully");
            System.out.println("Wallet created successfully");
            System.out.println("Wallet Address: " + walletAddress);
        } else {
            System.out.println("User registration failed");
        }
    }

    public void showWalletByEmail(String email) {

        Wallet wallet = repository.getWalletByEmail(email);

        if (wallet != null) {
            System.out.println("Wallet ID: " + wallet.getWalletId());
            System.out.println("User ID: " + wallet.getUserId());
            System.out.println("Wallet Address: " + wallet.getWalletAddress());
            System.out.println("Balance: " + wallet.getBalance());
        } else {
            System.out.println("Wallet not found");
        }
    }
}