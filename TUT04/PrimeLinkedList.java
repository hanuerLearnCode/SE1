package SE1.TUT04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Ex 06
 * SubClass PrimeLinkedList that inherits from Super Class LinkedList<Integer>
 */
public class PrimeLinkedList extends LinkedList<Integer> {

    /**
     * This method create an instance of PrimeIterator
     * @effects when it is called, create an obj of PrimeIterator -> perform the functions of the class
     * @return a PrimeIterator obj
     */
    private Iterator<Integer> primeIterator() {
        return new PrimeIterator();
    }

    /**
     * Class PrimeIterator -> implements Iterator<Integer>
     */
    private class PrimeIterator implements Iterator<Integer> {
        /**
         * a pointer to keep track of the current position
         */
        private int currentIndex = -1;

        /**
         *
         * @return whether the list has any prime elements
         */
        public boolean hasNext() {
            // create an index to perform the loop
            int nextIndex = currentIndex+1;
            // check whether the index is smaller than the size of the list
            // and whether the number at index position is prime or not
            while (nextIndex < size() && isPrime(get(nextIndex))) {
                nextIndex++; // increase the index if satisfied
            }
            // compare the last value of the index with the size of the list
            return nextIndex < size();
        }

        /**
         *
         * @return <pre> the next prime element in the list, <br>
         * if not found, throw NoSuchElementException </pre>
         */
        public Integer next() {
            int nextIndex = currentIndex + 1;
            while (nextIndex < size() && !isPrime(get(nextIndex))) {
                nextIndex++;
            }

            if (nextIndex >= size()) {
                throw new NoSuchElementException();
            }

            currentIndex = nextIndex;
            return get(currentIndex);
        }

        private boolean isPrime(Integer value) {
            if (value <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(value); i++) {
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        PrimeLinkedList list = new PrimeLinkedList();
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.primeIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
