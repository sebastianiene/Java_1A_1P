package section2_Thread_Runnable;

public class IncrementRunnable implements Runnable{
private int counter=0;
    @Override
    public void run() {
        //code
        synchronized (this){
        counter++;   //only these instructions synchronized
        }
        //code
    }

    public int getCounter() {
        return counter;
    }

    private static void method(){
        //code
        synchronized (IncrementRunnable.class) {
            System.out.println(Thread.currentThread().getName());
        }
        //code
    }
}
