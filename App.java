package edu.kau.fcit.cpit252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.kau.fcit.cpit252.transactions.Balance;
import edu.kau.fcit.cpit252.transactions.Transaction;
import edu.kau.fcit.cpit252.transactions.Transfer;
import edu.kau.fcit.cpit252.transactions.User;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Transaction transaction = null;
        System.out.print("Please enter your username: ");
        String username = reader.readLine();
        System.out.print("Please enter your password: ");
        String password = reader.readLine();
        System.out.print("Please enter your email: ");
        String email = reader.readLine();
        User user = new User(username, email, password);

        System.out.print("Please enter the current balance: ");
        double balance = Double.parseDouble(reader.readLine());


        System.out.println("\nChoose a transaction you want to perform.\n" +
                "1 - Balance Inquiry \n" +
                "2 - Transfer\n");
        int choice = Integer.parseInt(reader.readLine());

        if (choice == 1) {
            transaction = new Balance(balance);
            transaction.executeTransaction(user);
        } else if (choice == 2) {
            System.out.print("Please enter the account number: ");
            String accountNumber = reader.readLine();
            System.out.print("Please enter the amount: ");
            String amount = reader.readLine();
            transaction = new Transfer(accountNumber, Double.parseDouble(amount));
            transaction.executeProtectedTransaction(user);
        }
    }
}
