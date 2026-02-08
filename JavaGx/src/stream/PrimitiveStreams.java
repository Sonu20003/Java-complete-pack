package stream;

import utility.MyUtility;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);

        MyUtility.print(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        MyUtility.print(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        IntStream.of(1, 2, 3);

        DoubleStream doubles = new Random().doubles(5);
//        MyUtility.print(doubles.sum());
//        MyUtility.print(doubles.min());
//        MyUtility.print(doubles.max());
//        MyUtility.print(doubles.average());
//        doubles.summaryStatistics()
//        doubles.mapToInt(x -> (int) (x + 1));
        MyUtility.print(doubles.boxed().toList());

        IntStream intStream = new Random().ints(5);
        MyUtility.print(intStream.boxed().toList());
    }
}
