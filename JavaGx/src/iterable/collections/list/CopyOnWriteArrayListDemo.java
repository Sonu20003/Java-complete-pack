package iterable.collections.list;

import utility.MyUtility;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {

        // This guy is part of the 'concurrent' package.
        // Use it when multiple threads are reading and writing to the same list.
        CopyOnWriteArrayList<String> sharedList = new CopyOnWriteArrayList<>();

        sharedList.add("Apple");
        sharedList.add("Banana");
        sharedList.add("Cherry");

        try {
            ArrayList<String> fruits = new ArrayList<>();

            fruits.add("Apple");
            fruits.add("Banana");
            fruits.add("Cherry");

            for(String fruit : fruits) {
                MyUtility.print(fruit);
                if(fruit.equals("Banana")) fruits.add("Dragon Fruit");
            }
        } catch (ConcurrentModificationException e) {
            MyUtility.print("+---------------------------------------------------------------------------------+");
            MyUtility.print("| Concurrent modification error caught: "+ e +" |");
            MyUtility.print("+---------------------------------------------------------------------------------+");
        }

        // Here's the magic: Fail-Safe Iterator.
        // In a normal ArrayList, if you remove something while looping, it crashes.
        // Here, it won't, because the iterator is looking at a "snapshot" of the array.

        for (String fruit : sharedList) {
            MyUtility.print("Reading: " + fruit);

            // This would normally throw ConcurrentModificationException in a regular ArrayList
            if (fruit.equals("Banana")) {
                sharedList.add("Dragon fruit");
                MyUtility.print("Just added Dragon fruit while iterating!");
            }
        }

        MyUtility.print("Final list after all that: " + sharedList);
    }
}
