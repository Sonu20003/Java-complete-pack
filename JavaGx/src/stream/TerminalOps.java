package stream;

import utility.MyUtility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        // 1. collect
        list.stream().skip(1).toList();
        list.stream().skip(1).toList();

        // 2. forEach
        list.stream().forEach(System.out::println);

        // 3. reduce : Combines elements to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);
        MyUtility.print(optionalInteger.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        MyUtility.print(b);
        boolean b1 = list.stream().allMatch(x -> x > 0);
        MyUtility.print(b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        MyUtility.print(b2);

        // 6. findFirst, findAny
        MyUtility.print(list.stream().findFirst().get());
        MyUtility.print(list.stream().findAny().get());

        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min / max
        MyUtility.print("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1));
        MyUtility.print("min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));

        // 9. forEachOrdered
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        MyUtility.print("Using forEach with parallel stream:");
        numbers0.parallelStream().forEach(System.out::println);
        MyUtility.print("Using forEachOrdered with parallel stream:");
        numbers0.parallelStream().forEachOrdered(System.out::println);



        // Example: Filtering and Collecting Names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        MyUtility.print(names.stream().filter(x -> x.length() > 3).toList());

        // Example: Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        MyUtility.print(numbers.stream().map(x -> x * x).sorted().toList());

        // Example: Summing Values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        MyUtility.print(integers.stream().reduce(Integer::sum).get());

        // Example:  Counting Occurrences of a Character
        String sentence = "Hello world";
        MyUtility.print(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        List<String> list1 = stream.map(String::toUpperCase).toList(); // exception

        // stateful & stateless



    }
}
