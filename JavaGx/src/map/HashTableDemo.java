package map;

import utility.MyUtility;
import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) throws InterruptedException {

        // The old-school thread-safe map.
        // All methods are synchronized, so it's safe but slow.
        Hashtable<String, Integer> table = new Hashtable<>();
        String key = "Count";
        // Thread A: Adding numbers
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                table.put(key, i);
            }
        });

        // Thread B: Adding numbers simultaneously
        Thread thread2 = new Thread(() -> {
            for (int i = 500; i < 1000; i++) {
                table.put(key, i);
            }
        });

        thread1.start();
        thread2.start();

        // Wait for both to finish
        thread1.join();
        thread2.join();

        // If this was a regular HashMap, the size or value might be corrupted.
        // With Hashtable, it's consistent (though the last value depends on race).
        MyUtility.print("Final Table Size: " + table.size());
        MyUtility.print("Last value put in: " + table.get(key));
    }
}
