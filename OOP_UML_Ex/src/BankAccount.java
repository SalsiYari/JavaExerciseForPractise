public class BankAccount {
    private double balance;
    public BankAccount(){
        balance=0;
    }
    public BankAccount(Double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double val){
        balance += val;
    }
    public void withdraw(double val){
        if(val <= balance){
           balance -= val;
        }
    }
}
