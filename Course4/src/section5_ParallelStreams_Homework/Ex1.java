package section5_ParallelStreams_Homework;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1 {
    /* Write a program that:
    Creates a method isPrime(), that receives as input an integer number and returns a boolean,
    which says if the input is a prime number or not.
    Creates a stream with 10000 elements of type random between 1 and 1 million.
    Runs the task for each element in the stream, using a sequential and a parallel stream. */

    public static void main(String[] args) {
        int n= 113;
        boolean isPrimeresult;
        isPrimeresult = isPrime(n);
        System.out.println(isPrimeresult);


        Random random = new Random();
        List<Integer> intsList = random.ints(10_000,1, 1_000_001)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(intsList);

        Stream<Integer> parallelIntegerStream= intsList.parallelStream();
        System.out.println(parallelIntegerStream.parallel().collect(Collectors.toList()));
        System.out.println(parallelIntegerStream.sequential().collect(Collectors.toList()));

    }

    private static boolean isPrime(int n) {
        int m;
        boolean boolisPrime = true;

        m = n / 2;
        if (n == 0 || n == 1) {
            boolisPrime= false;
        } else
        {
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    boolisPrime = false;
                    break;
                }
            }
        }
        return boolisPrime;
    }
}
