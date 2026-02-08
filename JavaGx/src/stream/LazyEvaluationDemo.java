package stream;

import utility.MyUtility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    MyUtility.print("Filtering: " + name);
                    return name.length() > 3;
                });

        MyUtility.print("Before terminal operation");

        List<String> result = stream.collect(Collectors.toList());

        MyUtility.print("After terminal operation");
        MyUtility.print(result);


    }
}
