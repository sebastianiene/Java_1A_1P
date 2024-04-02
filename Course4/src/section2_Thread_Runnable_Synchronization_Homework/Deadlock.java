package section2_Thread_Runnable_Synchronization_Homework;

public class Deadlock {
    /* Create class Deadlock, that contains 2 constant values, LOCK1 and LOCk2.
    Create class Thread1, that in method run takes control of LOCK1 and after 100ms, takes over LOCK2 too.
    Create class Thread2 that takes control of the two locks in reverse order.
    Start the two threads and observe the behaviour.
    Find a solution such that the program shall finish its execution.
 */
    public static void main(String[] args) {
        final String LOCK1 = "resource 1";
        final String LOCK2 = "resource 2";

        class Thread1 implements Runnable {
            public synchronized void run() {
                synchronized (LOCK1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (LOCK2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        }

       class Thread2 implements Runnable{
           public void run() {
                synchronized (LOCK2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (LOCK1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        }
        Runnable b1 = new Thread1();
        Thread t1 = new Thread(b1);
        Runnable b2 = new Thread2();
        Thread t2 = new Thread(b2);

        t1.start();
        t2.start();

    }
}
