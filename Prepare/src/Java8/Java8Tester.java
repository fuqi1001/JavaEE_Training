package Java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Tester {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        Random random = new Random();
        Long count = strings.stream().filter(string -> strings.isEmpty()).count();
        System.out.println("count empty string: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("count string length = 3: " + count);

        count = strings.stream().filter(string -> string.length() != 3).count();
        System.out.println("count string length != 3: " + count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String mergeString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("MergeString: " + mergeString);

        List<Integer> squaresList = numbers.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println("SquaresList: " + squaresList);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List: "+ stats.getMax());
        System.out.println("Lowest number in List: " + stats.getMin());
        System.out.println("Sum of all number: " + stats.getSum());
        System.out.println("Average of all numbers: " + stats.getAverage());


        List<Integer> sortedList = integers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        random.ints().limit(10).forEach(System.out::println);

        /*
        flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
         */
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        //reduce example
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        sumValue = Stream.of(1,2,3,4).reduce(Integer::sum).get();
        System.out.println(sumValue);


        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println(concat);

        Random seed = new Random();
        Supplier<Integer> rand = seed::nextInt;
        Stream.generate(rand).limit(10).forEach(System.out::println);

        IntStream.generate(() -> (int)(System.nanoTime()) % 100)
                .limit(10)
                .forEach(System.out::println);


        Stream.iterate(0, n -> n+3).limit(10).forEach(s -> System.out.print(s +" "));
        System.out.println();

    }
}
