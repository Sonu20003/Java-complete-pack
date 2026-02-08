package map;

import utility.MyUtility;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {

        // It's like a TreeMap, but totally cool with multiple threads.
        // It keeps keys sorted and is thread-safe.
        ConcurrentSkipListMap<Integer, String> flightSchedule = new ConcurrentSkipListMap<>();

        flightSchedule.put(100, "Flight A");
        flightSchedule.put(50, "Flight B");
        flightSchedule.put(200, "Flight C");

        // Just like TreeMap, it prints in sorted order: 50, 100, 200
        MyUtility.print("Sorted Flights: " + flightSchedule);

        // It has all those "Navigable" methods we love
        MyUtility.print("First flight: " + flightSchedule.firstEntry());
        MyUtility.print("Last flight: " + flightSchedule.lastEntry());

        // This is the "Higher" entry, basically finding the next one up
        MyUtility.print("Next flight after 100: " + flightSchedule.higherEntry(100));

        // It's lock-free! High performance for concurrent reads and writes.
    }
}
