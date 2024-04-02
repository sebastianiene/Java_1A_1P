package section4_Barriers_Semaphores_Homework;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    /* Create class SemaphoreExample which has:
    ExecutorService executor received as parameter in the constructor
    Semaphore semaphore receives number of permits as a parameter.
    executeTask(final Callable<Integer> task) method that makes aquire to the semaphore
    then submits the received task, and finally makes release to the semaphore
     (to use the call method on the received instance)
     In the main method, instantiate this class with a ExecutorService with at least two threads
     (it is recommended a CachedThreadPool) and value 2 (can modify later to observe behaviour)
*/

    private ExecutorService executorService;
    private Semaphore semaphore;

    public SemaphoreExample(ExecutorService executorService, int permits) {
        this.executorService = executorService;
        this.semaphore = new Semaphore(permits);
    }
    public void executeTask(final Callable task) throws InterruptedException {
        semaphore.acquire();
        System.out.println("semaphore.acquire....");
        executorService.submit(()->{
            try {
                task.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            semaphore.release();
            System.out.println("semaphore.release....");
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        section4_Barriers_Semaphores.SemaphoreExample semaphoreExample = new section4_Barriers_Semaphores.SemaphoreExample(executorService, 2);  //how many threads maximum in parallel

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

    }
}
