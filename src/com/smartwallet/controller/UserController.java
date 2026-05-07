package com.smartwallet.controller;

import com.smartwallet.service.UserService;

public class UserController {

    private UserService service = new UserService();

    public void register(String name, String email, String password) {
        service.registerUser(name, email, password);
    }

    public void viewWallet(String email) {
        service.showWalletByEmail(email);
    }
}