package section2_Thread_Runnable_Synchronization_Homework;

import section2_Thread_Runnable.IncrementRunnable;

public class Ex1 {
    /* 1. Create a class named IncrementRunnable that has a int static attribute.
    Method run shall show the current value and then shall increment this value.
    Instantiate 4 threads using an instance of IncrementRunnable and starts them.
    Synchronize events from the run method, using the Runnable instance.
    Create 4 Runnable instances that offer themselves as parameters to the 4 threads.
    Modify the code to keep the preceding functionality.
 */
    public static class IncrementRunnable implements Runnable{
        private int someval;
        public IncrementRunnable(final int someval){
            this.someval = someval;
        }
        @Override
        public synchronized void run(){
            System.out.println(someval);
            someval = someval + 1;
        }
    }
    public static void main(String[] args) {
        int someval = 0;
        Ex1.IncrementRunnable runnable = new Ex1.IncrementRunnable(someval);
        int nr=  4;
        Thread[] threads = new Thread[nr];
        for (int i=0; i<nr; i++)
        {
            threads[i]= new Thread(runnable);
        }
        for (int i=0; i<nr; i++)
        {
            threads[i].start();
        }
    }
}
