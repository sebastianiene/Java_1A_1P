package section1_Thread_Examples;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        accessCommonResource();


    }

    private static synchronized void accessCommonResource() {
    while(true){
///one single instance can run this code at a given moment, but remains blocked here
    }

    }
}
