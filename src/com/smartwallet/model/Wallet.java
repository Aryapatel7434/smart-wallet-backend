/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartwallet.model;

/**
 *
 * @author ABC
 */
public class Wallet {
    private int walletId;
    private int userId;
    private double balance;
    private String walletAddress;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Wallet(int walletId, int userId, double balance, String walletAddress) {
        this.walletId = walletId;
        this.userId = userId;
        this.balance = balance;
        this.walletAddress = walletAddress;
    }
    
    
    
}
