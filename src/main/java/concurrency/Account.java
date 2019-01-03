package concurrency;

/*
 * Created by kader.belli on 03.01.2019.
 */

public class Account{
    
    int userNumber;
    String userLastName;
    String userFirstName;
    double userBalance;
    
//    public synchronized boolean deposit(double amount){
    public boolean deposit(double amount){
        double newBalance;
        if(amount < 0.0)
        {
            return false; /* Can’t deposit negative amount */
        }
        else
        {
            synchronized(this) // the parameter passed to synchronize is the object to use as the lock.
            {
                newBalance = userBalance + amount;
                userBalance = newBalance;
            }
            return true;
        }
    }
    
//    public synchronized boolean withdraw(double amount){
    public boolean withdraw(double amount){
        double newBalance;
        synchronized(this) // the parameter passed to synchronize is the object to use as the lock.
        {
            if(amount < 0.0 || amount > userBalance)
            {
                return false; /* Negative withdrawal or insufficient funds */
            }
            else
            {
                newBalance = userBalance - amount;
                userBalance = newBalance;
                return true;
            }
        }
    }
}


