package section5_ParallelStreams;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> coursesList = List.of("Java1A", "Java1P", "Java2");
        Stream<String> parallelStringStream = coursesList.parallelStream();
        Stream<Integer> parallelIntegerStream = Stream.of(1, 2, 3, 4, 5).parallel();

        // parallelStreamExample();
        Integer result= Stream.of(1,2,3,4,5)
                .parallel()
                .unordered() //unordered stream with random
                .skip(2)
                .findFirst()
                .get();
        System.out.println(result);

    }

    private static void parallelStreamExample() {
        LocalTime start = LocalTime.now();
        Stream.of(1,2,3,4,5)
                .parallel()   //to use parallel stream
                .map(el-> processInput(el))
                .forEachOrdered(System.out::println);  //to have them in order
        LocalTime end = LocalTime.now();
        System.out.println(ChronoUnit.MILLIS.between(start,end));
    }

    private static Integer processInput(Integer input){
            try {
                Thread.sleep(5000);  //print element every 5 seconds, total time is around 25 seconds
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
    return input;
    }
}
