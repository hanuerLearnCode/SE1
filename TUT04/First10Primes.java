package SE1.TUT04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class First10Primes {
    public static void main(String[] args) {
        List primes = new ArrayList<>();
        // find 10 primes and add to the list
        int ct = 0, n = 0, i = 1, j = 1;
        while (n < 10) {
            j = 1;
            ct = 0;
            while (j <= i) {
                if (i % j == 0) ct++;
                j++;
            }
            if (ct == 2) {
                primes.add(i);
                n++;
            }
            i++;
        }

        // using iterator instead of for loop to print list elements
        Iterator<Integer> integerIterator = primes.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
    }
}
