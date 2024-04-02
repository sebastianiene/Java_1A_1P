package section4_Barriers_Semaphores;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // atomicIntegerExample();
    }

    private static void atomicIntegerExample() throws InterruptedException {
        IncrementRunnable runnable = new IncrementRunnable();
        int nr=  10000;
        Thread[] threads = new Thread[nr];
        for (int i=0; i<nr; i++)
        {
            threads[i]= new Thread(runnable);
        }
        for (int i=0; i<nr; i++)
        {
            threads[i].start();
        }
        for (int i=0; i<nr; i++)
        {
            threads[i].join();
        }

        System.out.println(runnable.getCounter().get());
    }
}
