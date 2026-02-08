package map;

import utility.MyUtility;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {

        // The king of thread-safe maps.
        // It doesn't lock the whole map, so multiple threads can write at once.
        ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();

        // Using a thread pool to simulate a high-traffic environment
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Multiple threads trying to increment a value simultaneously
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                // compute() is an atomic operation provided by ConcurrentHashMap
                inventory.compute("Items", (key, value) -> (value == null) ? 1 : value + 1);
            });
        }

        executor.shutdown();
        boolean b = executor.awaitTermination(5, TimeUnit.SECONDS);
        MyUtility.print(b);

        MyUtility.print("Final inventory count: " + inventory.get("Items"));

        // Another cool thing: it allows reading while someone else is writing
        // without throwing ConcurrentModificationException.
        inventory.put("A", 1);
        inventory.put("B", 2);

        MyUtility.print("Iterating through map safely:");
        inventory.forEach((k, v) -> MyUtility.print(k + ":" + v + " "));
    }
}
