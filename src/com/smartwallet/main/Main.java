package com.smartwallet.main;

import com.smartwallet.controller.UserController;

public class Main {

    public static void main(String[] args) {

        UserController controller = new UserController();

        System.out.println("===== TEST 1: REGISTER USER =====");
        controller.register("Ary", "ary4@gmail.com", "1234");

        System.out.println("\n===== TEST 2: VIEW WALLET =====");
        controller.viewWallet("ary4@gmail.com");

        System.out.println("\n===== TEST 3: DUPLICATE USER =====");
        controller.register("Ary", "ary4@gmail.com", "1234");

        System.out.println("\n===== TEST 4: VIEW UNKNOWN WALLET =====");
        controller.viewWallet("unknown@gmail.com");
    }
}