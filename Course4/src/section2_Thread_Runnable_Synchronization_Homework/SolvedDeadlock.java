package section2_Thread_Runnable_Synchronization_Homework;

public class SolvedDeadlock {
    /* Create class Deadlock, that contains 2 constant values, LOCK1 and LOCk2.
    Create class Thread1, that in method run takes control of LOCK1 and after 100ms, takes over LOCK2 too.
    Create class Thread2 that takes control of the two locks in reverse order.
    Start the two threads and observe the behaviour.
    Find a solution such that the program shall finish its execution.
 */
    public static void main(String[] args) {
        final String LOCK1 = "resource 1";
        final String LOCK2 = "resource 2";

        class Thread1 extends Thread {

            public synchronized void run() {
                synchronized (LOCK2) {
                    try {
                        Thread.sleep(100);
                        System.out.println("Thread 1: locked resource 2");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    synchronized (LOCK1) {
                        System.out.println("Thread 1: locked resource 1");
                    }
                }
            }
        }

        class Thread2 extends Thread{
            public void run() {
                synchronized (LOCK2) {
                    try {
                        Thread.sleep(100);
                        System.out.println("Thread 2: locked resource 2");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    synchronized (LOCK1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        }


        Thread t1 = new Thread1();
        Thread t2 = new Thread2();

        t1.start();
        t2.start();

    }
}
