package map;

import utility.MyUtility;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        // This guy keeps everything sorted by the Key automatically.
        // It's the go-to for leaderboards or alphabetical lists.
        TreeMap<Integer, String> scores = new TreeMap<>();

        // Adding items out of order
        scores.put(90, "Sonu");
        scores.put(100, "Ram");
        scores.put(75, "Shyam");

        // It will print in ascending order: 75, 90, 100
        MyUtility.print("Sorted Scoreboard: " + scores);

        // --- COOL NAVIGABLE METHODS ---

        // Getting the boundaries
        MyUtility.print("Lowest Score: " + scores.firstKey());
        MyUtility.print("Highest Score: " + scores.lastKey());

        // 'Floor' is like finding the greatest key <= the given value
        MyUtility.print("Highest score below or at 95: " + scores.floorKey(95));

        // 'Ceiling' is the lowest key >= the given value
        MyUtility.print("Lowest score at or above 80: " + scores.ceilingKey(80));

        // You can even get a "sub-view" of the map
        MyUtility.print("Scores between 70 and 95: " + scores.subMap(70, 95));
    }
}
