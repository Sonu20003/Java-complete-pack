package map;

import utility.MyUtility;
import java.util.WeakHashMap;
import java.util.Map;

public class WeakHashMapDemo {
    public static void main(String[] args) {

        // This map doesn't stop the Garbage Collector from nuking its keys.
        // It's like a temporary storage that cleans itself up.
        Map<String, String> cache = new WeakHashMap<>();

        // Case 1: The 'Strong' Key (String Pool)
        String strongKey = "Permanent";
        cache.put(strongKey, "This won't be deleted easily");

        // Case 2: The 'Weak' Key (Heap Object)
        String weakKey = new String("Temporary");
        cache.put(weakKey, "This is gone once 'weakKey' becomes null");

        MyUtility.print("Before GC: " + cache);

        // We lose the reference to the weak key
        weakKey = null;

        // Telling Java to clean up (not guaranteed)
        System.gc();

        // Give it a second to breathe
        try { Thread.sleep(1000); } catch (Exception ignored) {}

        // The "Temporary" entry should be gone now!
        MyUtility.print("After GC: " + cache);
    }
}
