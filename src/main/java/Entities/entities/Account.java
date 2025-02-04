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

    public synchronized void transfer(Account destinyAccount, double amount) throws TransactionException{
        if(destinyAccount == null){
            throw new TransactionException("Destiny account cannot be null.");
        }

        if(amount <= 0){
            throw new TransactionException("Transfer amount must be higher than zero.");
        }

        synchronized (this){
            synchronized (destinyAccount){
                if(balance >= amount){
                    this.withDraw(amount);
                    destinyAccount.deposit(amount);
                    System.out.println("Transfered value US$ " + amount + " from account " + this.number +
                            " to account " + destinyAccount.getNumber() + "\n");
                }else {
                    throw new TransactionException("Fail to transfer. Insufficient balance.");
                }
            }
        }
    }

    public void showBalance(){
        System.out.println("Currently balance US$: " + this.balance);
    }

    public void showAccountInfos(){
        System.out.println("Showing account informations...");
        System.out.println("Account: " + String.format("%04d", this.number));
        System.out.println("Client name: " + this.client.getName());
        System.out.println("Client cpf: " + this.client.getCpf());
        System.out.println("Currently balance US$: " + this.balance + "\n");

    }

}
