package section1_Thread_Examples;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from: "+ Thread.currentThread().getName());
    }
}
