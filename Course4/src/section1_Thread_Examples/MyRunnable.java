package section1_Thread_Examples;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from: "+ Thread.currentThread().getName());
    }
}
