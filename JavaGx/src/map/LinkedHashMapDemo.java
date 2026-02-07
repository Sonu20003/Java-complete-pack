package map;

import utility.MyUtility;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        // Unlike HashMap, this guy remembers the order you put things in.
        // Super useful if you need to print a menu or a list in order.
        LinkedHashMap<String, String> fruitColors = new LinkedHashMap<>();

        fruitColors.put("Apple", "Red");
        fruitColors.put("Banana", "Yellow");
        fruitColors.put("Grape", "Green");

        // It'll print exactly: Apple, Banana, Grape
        for (Map.Entry<String, String> entry : fruitColors.entrySet()) {
            MyUtility.print(entry.getKey() + " is " + entry.getValue());
        }

        MyUtility.print("--- LRU Cache Section ---");

        // Testing the custom LRU Cache below
        // We set capacity to 2, so the oldest item should get booted.
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "Data A");
        cache.put(2, "Data B");

        // Accessing 1 makes it 'recently used'
        cache.get(1);

        // Adding a 3rd item triggers the removal of the eldest (which is 2)
        cache.put(3, "Data C");

        MyUtility.print("Cache contents (2 should be gone): " + cache);

    }
}

/**
 * A simple Least Recently Used (LRU) Cache.
 * By passing 'true' in the constructor, the map tracks 'access order'
 * instead of 'insertion order'.
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // Java calls this automatically after every 'put'
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // If we go over capacity, kick out the oldest entry
        boolean kickout = size() > this.capacity;
        if (kickout) MyUtility.print("LRU item removed! "+ this.entrySet().stream().findFirst());
        return kickout;
    }
}
