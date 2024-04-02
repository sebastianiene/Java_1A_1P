package section1_Thread_Examples;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main thread..."+ Thread.currentThread().getName());
       // simpleThreadExamples();
         blockedStateExample();
        // waitingStateExample();
        // timedWaitingStateExample();
        // terminatedStateExample();
        System.out.println("Ending main thread..." + Thread.currentThread().getName());
    }

    private static void terminatedStateExample() throws InterruptedException {
        Thread thread= new Thread(() -> System.out.println("Hello from: "+ Thread.currentThread().getName()));
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }

    private static void timedWaitingStateExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getState());
    }

    private static void waitingExample() throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread thread = new Thread(() ->System.out.println(main.getState()));
        thread.start();
        thread.join();
    }

    private static void blockedStateExample() throws InterruptedException {
        Runnable runnable = new SimpleRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2= new Thread(runnable);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread2.getState());
    }

    private static void simpleThreadExamples() {
    /*Thread thread = new SimpleThread();
    thread.start();*/

        // Runnable runnable = new MyRunnable();   // with runnable we can extend another class, is a functional interface so can use lambda expressions
        Thread thread1 = new Thread(() -> System.out.println("Hello from: " + Thread.currentThread().getName()));
        System.out.println(thread1.getState());
        thread1.start();
        System.out.println(thread1.getState()); //in runnable after start
    }
}
