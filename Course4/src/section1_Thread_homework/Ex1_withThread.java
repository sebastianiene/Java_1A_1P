package section1_Thread_homework;

public class Ex1_withThread {
   /* Write a program which:

   Prints the elements of an array using another thread
   Calculates the sum of a list and shows it, next to the name of the thread, on a new thread;
   Use both Thread and Runnable;
   Start 10 threads that execute the same task. */

    public static class Worker extends Thread{
        private final int message;
        public Worker(final int message){
            this.message = message;
        }
        @Override
        public void run(){
            System.out.println(message);
        }
    }

    public static class sumWorker extends Thread{
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
            new Worker(message).start();
            sumValue= sumValue + message;
        }
        new sumWorker(sumValue).start();
    }
}
