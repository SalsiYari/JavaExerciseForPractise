package Lists;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        if(o1.getInterestRate() == o2.getInterestRate() ){
            return 0;
        } else if (o1.getInterestRate() < o2.getInterestRate()) {
            return -1;
        }
        return +1;
    }
}
