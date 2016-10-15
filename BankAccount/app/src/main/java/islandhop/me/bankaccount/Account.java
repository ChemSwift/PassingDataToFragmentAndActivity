package islandhop.me.bankaccount;

/**
 * Created by Chem Swift on 10/13/16.
 */

public class Account {

    private double balance;

    public Account(double initialAccountBalance){
        if(initialAccountBalance > 0.0){
            this.balance = initialAccountBalance;
        }
    }

    public void credit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}
