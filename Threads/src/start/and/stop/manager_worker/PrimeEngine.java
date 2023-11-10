package start.and.stop.manager_worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeEngine implements Callable<List<Integer>> {
    int start;
    int end;

    public PrimeEngine(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> call() {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }
}