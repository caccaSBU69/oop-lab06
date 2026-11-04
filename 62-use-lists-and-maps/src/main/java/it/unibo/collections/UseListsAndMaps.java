package it.unibo.collections;

import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    static final int MIN_LIST = 1000;
    static final int MAX_LIST = 2000;

    static final int ELEMENT_ADDED_TEST_TIME = 100000;
    static final int ELEMENT_READ_TEST_TIME = 1000;

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> n1 = new ArrayList<Integer> () ;
        for(int i = MIN_LIST ; i < MAX_LIST ; i++) {
            n.add(Integer.valueOf(i));
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> n2 = new LinkedList<Integer> (n1) ;
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int appoggio = n1.getFirst();
        n1.set(0, n1.getLast());
        n1.set(n1.size()-1, appoggio);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int n : n1) {
            IO.println(n);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMENT_ADDED_TEST_TIME; i++) {
            n1.add(0,i);
        }
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Per l'arrayList ci ha impiegato " + time + "," + millis + " per inserire " + 
            ELEMENT_ADDED_TEST_TIME + " elementi");

        time = System.nanoTime();
        for (int i = 1; i <= ELEMENT_ADDED_TEST_TIME; i++) {
            n2.add(0,i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Per linkedList ci ha impiegato " + time + "," + millis +  " per inserire " + 
            ELEMENT_ADDED_TEST_TIME + " elementi");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        for (int i = 1; i <= ELEMENT_READ_TEST_TIME; i++) {
            n1.get(n1.size()/2 + i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Per l'arrayList ci ha impiegato " + time + "," + millis + " per leggere " + 
            ELEMENT_READ_TEST_TIME + " elementi");

        time = System.nanoTime();
        for (int i = 1; i <= ELEMENT_READ_TEST_TIME; i++) {
            n2.get(n2.size()/2 + i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Per linkedList ci ha impiegato " + time + "," + millis + " per leggere " + 
            ELEMENT_READ_TEST_TIME + " elementi");
            
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> popolazione = new HashMap<>();
        popolazione.put("Africa", 1_110_635_000L);
        popolazione.put("Americas", 972_005_000L);
        popolazione.put("Antarctica", 0L);
        popolazione.put("Asia", 4_298_723_000L);
        popolazione.put("Europe", 742_452_000L);
        popolazione.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */

        long totale = 0;
        for (long abitanti : popolazione.values()) {
            totale += abitanti;
        }
        IO.println("Popolazione mondiale: " + totale);
    }
}
