package section3_ExecutorService_homework;

import java.time.LocalTime;
import java.util.concurrent.*;
import section3_ExecutorService_homework.BeeperControl;


public class Ex1 {
    /* Write a program that:

    Submits to an executor service a task of type runnable which increments 500_000 times a global counter.
    Waits for the result of this task a maximum of 4 ms.
    Submits a task of type Callable that increments a local counter, the same number of times and returns it.
    Apply also on the Future object received the get method and observe the difference (for Runnable is returned null, for Callable the result)
    Create an executor that executes a periodical task, with initial delay 2seconds, and at 5 seconds intervals shall show the current hour. */
    public static void main(String[] args) {
        final int[] global_counter = new int[1];

        Runnable runnableTask = () -> {
            for (int i=0;i<500_000;i++)
            {
                global_counter[0] = global_counter[0] + 1;
                System.out.println("global_counter runnable = "+global_counter[0]);
            }
        };

        Callable callableTask = () -> {
            for (int i=0;i<500_000;i++)
            {
                global_counter[0] = global_counter[0] + 1;
                System.out.println("global_counter callable = "+global_counter[0]);
            }
            return global_counter[0];
        };
        ExecutorService executorService_runnable = Executors.newSingleThreadExecutor(); //as many threads as needed and system supports
        executorService_runnable.submit(runnableTask);
        executorService_runnable.shutdown();

        try {

            if(!executorService_runnable.awaitTermination(4, TimeUnit.MILLISECONDS)){
                executorService_runnable.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        ExecutorService executorService_callable = Executors.newSingleThreadExecutor(); //as many threads as needed and system supports
        executorService_callable.submit(callableTask);
        executorService_callable.shutdown();

        try {

            if(!executorService_callable.awaitTermination(4, TimeUnit.MILLISECONDS)){
                executorService_callable.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* code below does not work in static context, so making it in a separate Class as in the help guidance of the function*/
//        Runnable runnableTaskDate = () -> {
//            System.out.println("current time is " + LocalTime.now());
//        };
//        ScheduledFuture<?> scheduledFuture = ScheduledExecutorService.scheduleAtFixedRate(runnableTaskDate, 2, 5, TimeUnit.SECONDS);

        BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();


    }
}
