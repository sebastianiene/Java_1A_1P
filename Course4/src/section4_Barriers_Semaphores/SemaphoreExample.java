package section4_Barriers_Semaphores;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private ExecutorService executorService;
    private Semaphore semaphore;

    public SemaphoreExample(ExecutorService executorService, int permits) {
        this.executorService = executorService;
        this.semaphore = new Semaphore(permits);
    }

    public void executeTask(Runnable task) throws InterruptedException {
        semaphore.acquire();
        System.out.println("semaphore.acquire....");
        executorService.submit(()->{
            task.run();
            semaphore.release();
            System.out.println("semaphore.release....");
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SemaphoreExample semaphoreExample = new SemaphoreExample(executorService, 2);  //how many threads maximum in parallel

        semaphoreExample.executeTask(()->{
            System.out.println(LocalTime.now()+ " : task1 is running ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now()+" : task1 is done");
        });

        semaphoreExample.executeTask(()->{
            System.out.println(LocalTime.now()+ " : task2 is running ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now()+" : task2 is done");
        });

        semaphoreExample.executeTask(()->{
            System.out.println(LocalTime.now()+ " : task3 is running ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now()+" : task3 is done");
        });

        semaphoreExample.executeTask(()->{
            System.out.println(LocalTime.now()+ " : task4 is running ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now()+" : task4 is done");
        });

        semaphoreExample.executeTask(()->{
            System.out.println(LocalTime.now()+ " : task5 is running ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now()+" : task5 is done");
        });

        executorService.shutdown();
    }

}
