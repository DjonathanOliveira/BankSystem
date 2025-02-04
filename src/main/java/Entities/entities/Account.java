package Entities.entities;


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

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
