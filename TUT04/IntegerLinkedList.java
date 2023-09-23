package SE1.TUT04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * subclass IntegerLinkedList of super-class LinkedList<Integer>
 */
public class IntegerLinkedList extends LinkedList<Integer> {
    /**
     * the evenIterator() method that will be used instead of just iterator()
     * @return an object of class EvenIterator
     */
    public Iterator<Integer> evenIterator() {
        return new EvenIterator();
    }

    /**
     *
     * Class EvenIterator that implements the Iterator class
     */
    private class EvenIterator implements Iterator<Integer> {

        private int index = -1;
        /**
         *
         * @return whether the iterator will continue or not
         */
        @Override
        public boolean hasNext() {
            int nextIndex = index+1;
            while (nextIndex < size() && get(nextIndex)%2 != 0) {
                nextIndex++;
            }
            return nextIndex < size();
        }

        /**
         *
         * @return the next value that is even of the iterator
         */
        @Override
        public Integer next() {
            int nextIndex = index + 1;
            while (nextIndex < size() && get(nextIndex) % 2 != 0) {
                nextIndex++;
            }
            if (hasNext()) {
                index = nextIndex;
                return get(index);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /**
     * Main
     */
    public static void main(String[] args) {
        // create a list
        IntegerLinkedList list = new IntegerLinkedList();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);

        // iterator
        Iterator<Integer> iterator = list.evenIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
