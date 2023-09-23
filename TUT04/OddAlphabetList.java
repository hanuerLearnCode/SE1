package SE1.TUT04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OddAlphabetList {
    public static void main(String[] args) {
        /**
         * List of chars that has odd char code
         */
        List<Character> alphabet = new ArrayList<>();
        // find the char with the odd char code
        for (char c = 'a'; c <= 'z'; c++) {
            if (c % 2 != 0) {
                // add to list
                alphabet.add(c);
            }
        }

        // iterator
        Iterator<Character> iterator = alphabet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
