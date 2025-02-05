import Entities.Exceptions.TransactionException;
import Entities.entities.Account;
import Entities.entities.Client;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            Client client = new Client("Djonathan", "168.600.317-00");
            Account account = new Account(314, client);

            Client client2 = new Client("Alice", "349.730.215-14");
            Account account2 = new Account(315, client2);

            account.deposit(100.00);
            account.showAccountInfos();

            account2.showAccountInfos();

            account.transfer(account, 25.00);

            account.showAccountInfos();
            account2.showAccountInfos();
        }catch (TransactionException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
