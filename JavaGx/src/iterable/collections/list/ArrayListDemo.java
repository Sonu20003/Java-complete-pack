package iterable.collections.list;

import utility.MyUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(100);

        list.add(10);
        list.add(20);
        list.add(30);

        list.add(0, 20);
        list.set(1, 100);

        // Removing elements (by index or by object)
        list.remove(Integer.valueOf(30)); // Removes the first occurrence of 30
        list.remove(0); // Removes element at index 0

        // Checking position
        int firstIdx = list.indexOf(20); // Returns first occurrence index
        int lastIdx = list.lastIndexOf(20); // Useful for duplicate-heavy lists

        // Bulk Operations
        List<Integer> batch = Arrays.asList(50, 60, 70);
        list.addAll(batch); // Adds a whole collection at once

        Collections.sort(list); // Sorts in natural ascending order

        // Converting to Array
        Object[] array = list.toArray();

        // Printing results
        System.out.print("[ ");
        for(int i : list) {
            System.out.print(i + " ");
        }
        MyUtility.print("]");

        MyUtility.print("Is list empty? " + list.isEmpty()); // Better than list.size() == 0
        MyUtility.print("Index zero element: " + list.get(0));
        MyUtility.print("List contains 10 ..?: " + list.contains(10));
        MyUtility.print("List size: " + list.size());

        // Fixed-size vs Immutable reminders
        List<String> li1 = Arrays.asList("Sonu", "Ram", "Shyam");
        // li1.add("New"); -> Throws UnsupportedOperationException

        List<String> li2 = List.of("Sonu", "Ram", "Shyam");
        // li2.set(0, "New"); -> Throws UnsupportedOperationException

        // custom sort via lambda expressions
        list.sort((a,b) -> a-b);
        System.out.println(list);
        list.sort((a,b) -> b-a);
        System.out.println(list);
    }
}
