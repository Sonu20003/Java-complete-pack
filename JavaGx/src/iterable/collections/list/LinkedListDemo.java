package iterable.collections.list;

import utility.MyUtility;
import java.util.LinkedList;
import java.util.Deque;

public class LinkedListDemo {
    public static void main(String[] args) {

        // LinkedList implements both List and Deque interfaces
        LinkedList<String> names = new LinkedList<>();

        // Basic Additions
        names.add("Java");
        names.add("Spring");

        // Deque Methods are, what makes linkedlist special
        names.addFirst("Microservices"); // O(1) - Fast!
        names.addLast("Docker");         // O(1) - Fast!

        // Retrieval
        MyUtility.print("First Element: " + names.getFirst());
        MyUtility.print("Last Element: " + names.getLast());

        // Removing front and back elements are efficient
        names.removeFirst();
        names.removeLast();

        // Using it as a Queue (FIFO)
        names.offer("Kubernetes"); // Adds to tail
        String polled = names.poll(); // Removes from head

        // Using it as a Stack (LIFO)
        names.push("GraphQL"); // Adds to head
        String popped = names.pop(); // Removes from head

        // Iteration
        System.out.print("Current List: ");
        for (String s : names) {
            System.out.print(s + " <-> ");
        }
        MyUtility.print("null");
    }
}
