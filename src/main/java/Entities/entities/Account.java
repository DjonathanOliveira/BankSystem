package Entities.entities;


import Entities.Exceptions.TransactionException;

public class Account {

    private int number;
    private double balance;
    private Client client;


    public Account() {
    }

    public Account(int number,  Client client) {
        this.number = number;
        this.balance = 0;
        this.client = client;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public synchronized void deposit(double amount) throws TransactionException {
        if(amount <= 0){
            throw new TransactionException("Amount must be higher than zero for deposit.");
        }
        this.balance += amount;
    }

    public synchronized void withDraw(double amount) throws TransactionException{
        if(amount > balance){
            throw new TransactionException("Insufficient balance.");
        }

        if(amount <= 0){
            throw new TransactionException("Invalid amount.");
        }
        this.balance -= amount;
    }

}
