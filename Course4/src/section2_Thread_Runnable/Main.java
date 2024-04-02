package section2_Thread_Runnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //incrementRunnableExample();

        BlockingQueue<Integer> queue= new section2_Thread_Runnable.BlockingQueue<>(10);

        Thread consumer= new Thread(()-> {
            while (true) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(()-> {
            int counter =0;
            while(true) {
                try {
                    Thread.sleep(1000);
                    queue.put(counter);
                    counter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        consumer.start();
        producer.start();
    }

    private static void incrementRunnableExample() throws InterruptedException {
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


        System.out.println(runnable.getCounter());
        System.out.println(runnable.getCounter()== nr);
    }
}
