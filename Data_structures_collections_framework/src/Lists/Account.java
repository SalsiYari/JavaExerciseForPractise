package Lists;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Account{
    double amount;
    double interestRate;
    LocalDate duePaymant;

    public Account(double amount, double interestRate, LocalDate duePaymant) {
        this.amount = amount;
        this.interestRate= interestRate;
        this.duePaymant=duePaymant;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getDuePaymant() {
        return duePaymant;
    }

    public void setDuePaymant(LocalDate duePaymant) {
        this.duePaymant = duePaymant;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", interestRate=" + interestRate +
                ", duePaymant=" + duePaymant +
                '}';
    }
}
