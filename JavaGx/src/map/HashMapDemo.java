package map;

import utility.MyUtility;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        // Key is the ID (Integer), Value is the name (String)
        HashMap<Integer, String> userMap = new HashMap<>();

        // Adding data (put)
        userMap.put(101, "Sonu");
        userMap.put(102, "Ram");
        userMap.put(103, "Shyam");

        // Overwriting a value - it just replaces the old one
        userMap.put(101, "Sonu (Updated)");

        // Getting a single value
        MyUtility.print("User with ID 102: " + userMap.get(102));

        // Quick checks
        MyUtility.print("Does ID 105 exist? " + userMap.containsKey(105));

        // Removing someone
        userMap.remove(103);


        // Only looping through keys
        MyUtility.print("--- All IDs (KeySet) ---");
        for (Integer id : userMap.keySet()) {
            MyUtility.print("ID: " + id);
        }

        // The EntrySet loop (The most efficient way to get both)
        MyUtility.print("--- Full User List (EntrySet) ---");
        for (Map.Entry<Integer, String> entry : userMap.entrySet()) {
            MyUtility.print("ID: " + entry.getKey() + " | Name: " + entry.getValue());
        }

        // Current size
        MyUtility.print("Total users left: " + userMap.size());
    }
}
