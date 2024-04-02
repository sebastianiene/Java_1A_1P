package section1_Thread_homework;

public class Ex1_withRunnable {
    /* Write a program which:

   Prints the elements of an array using another thread
   Calculates the sum of a list and shows it, next to the name of the thread, on a new thread;
   Use both Thread and Runnable;
   Start 10 threads that execute the same task. */
    public static class Worker implements Runnable{
        private final int message;
        public Worker(final int message){
            this.message = message;
        }
        @Override
        public void run(){
            System.out.println(message);
        }
    }

    public static class sumWorker implements Runnable{
        private int sumValue;
        public sumWorker(int sumValue)
        {
            this.sumValue= sumValue;
        }
        @Override
        public void run() {
            System.out.println("Hello from thread "+ Thread.currentThread().getName()+" sum is: "+ sumValue);
        }
    }
    public static void main(String[] args) {
        int[] messages = new int[]{7,8,9,10,11,12,13,14,15,16};
        int sumValue = 0;
        for(final int message: messages){
            Thread myThread = new Thread(new Ex1_withRunnable.Worker(message));
            myThread.start();
            sumValue= sumValue + message;
        }
        Thread mySumThread_1 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_1.start();
        Thread mySumThread_2 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_2.start();
        Thread mySumThread_3 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_3.start();
        Thread mySumThread_4 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_4.start();
        Thread mySumThread_5 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_5.start();
        Thread mySumThread_6 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_6.start();
        Thread mySumThread_7 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_7.start();
        Thread mySumThread_8 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_8.start();
        Thread mySumThread_9 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_9.start();
        Thread mySumThread_10 = new Thread(new Ex1_withRunnable.sumWorker(sumValue));
        mySumThread_10.start();
    }
}
