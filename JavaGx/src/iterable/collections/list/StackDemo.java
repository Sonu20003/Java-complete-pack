package iterable.collections.list;

import utility.MyUtility;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        // "Last-In-First-Out" structure.
        Stack<String> bookStack = new Stack<>();

        // Adding stuff to the top
        bookStack.push("Java Basics");
        bookStack.push("Spring Boot");
        bookStack.push("Microservices");

        // Just taking a peek at the top without actually removing it
        MyUtility.print("What's on top right now? " + bookStack.peek());

        // Removing the top item (LIFO)
        String removedItem = bookStack.pop();
        MyUtility.print("Just popped: " + removedItem);

        // Checking where an item is in the stack
        // Warning: search is 1-based, not 0-based. Kinda weird, I know.
        int position = bookStack.search("Java Basics");
        MyUtility.print("Position of Java Basics: " + position);

        // Quick check if we ran out of items
        MyUtility.print("Is the stack empty? " + bookStack.empty());

        // Let's see what's left
        System.out.print("Remaining books: ");
        for(String book : bookStack) {
            System.out.print(book + " <- ");
        }
        MyUtility.print("BOTTOM");
    }
}
