package section3_ExecutorService;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // simpleExecutorServiceExample();
        // otherExecutorServiceExamples();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
      //  ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        Callable<Integer> callable = ()->{
            System.out.println("Hello from: " + Thread.currentThread().getName());
            System.out.println(LocalTime.now());
            return 1;
        };


        System.out.println(LocalTime.now());
        Runnable runnableTask = () -> {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
       // scheduledExecutorService.scheduleAtFixedRate(runnableTask,100, 1000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(runnableTask, 100, 1000, TimeUnit.MILLISECONDS);
       // ScheduledFuture<Integer> result = scheduledExecutorService.schedule(callable, 3, TimeUnit.SECONDS);

        // scheduledExecutorService.shutdown();

    }

    private static void otherExecutorServiceExamples() throws InterruptedException, ExecutionException {
        Callable<Integer> callable = ()->{
            System.out.println("Hello from: " + Thread.currentThread().getName());
            return 1;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5); //as many threads as needed and system supports
        List<Callable<Integer>> tasksList = List.of(callable, callable, callable);
        List<Future<Integer>> futures = executorService.invokeAll(tasksList);
        Integer result = executorService.invokeAny(tasksList);
        System.out.println(result);

        executorService.shutdown();
    }

    private static void simpleExecutorServiceExample() throws InterruptedException, ExecutionException {
        Callable<Integer> callable = ()->{
            System.out.println("Hello from: " + Thread.currentThread().getName());
            return 1;
        };

        Runnable task = ()->{
            System.out.println("Hello from: "+ Thread.currentThread().getName());
        };

        ExecutorService executorService = Executors.newCachedThreadPool(); //as many threads as needed and system supports
        Future<?> submittedTask = executorService.submit(callable);
/*        submittedTask.cancel(true);
        System.out.println(submittedTask.isCancelled());*/
        while (!submittedTask.isDone()){
            System.out.println("Hello..........");
        }
        System.out.println("Result is: "+ submittedTask.get());
        executorService.submit(callable);  //submit for callable and execute for runnable
        executorService.submit(callable);
        executorService.submit(callable);
        executorService.submit(callable);
        executorService.submit(callable);

        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        List<Runnable> unprocessedTasks= executorService.shutdownNow();
//        System.out.println(unprocessedTasks.size());
//        executorService.execute(task);
    }
}
