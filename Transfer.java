package edu.kau.fcit.cpit252.transactions;

import java.util.Scanner;

public class Transfer extends Transaction {

    private String accountNumber;
    private double amount;

    public Transfer(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
   
    public boolean showDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transferring money? (y|n) ");
        String answer = scanner.next();
        if (answer.contains("y")) {
            return true;
        }
        return false;
    }

    public boolean perform(User u) {
        simulateNetworkLatency();
        System.out.println("Transferring: SAR " + this.amount + " was sent to " + this.accountNumber);
        return true;
    }

    public void closeDialog() {
        System.out.println("Closing the Transfer dialog.");
    }
}
