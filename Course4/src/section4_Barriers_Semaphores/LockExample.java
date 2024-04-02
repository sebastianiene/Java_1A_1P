package section4_Barriers_Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
    public static void main(String[] args) {
        Runnable runnable = new RunnableReadWrite();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

        executorService.shutdown();

    }
}

class RunnableReadWrite implements Runnable {

        public ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private int x;


    @Override
    public void run() {
        for (int i = 0; i<5; i++){
            writeResource();
            readResource();
        }
    }

    private void readResource(){
        readWriteLock.readLock().lock();
        System.out.println("x = "+ x);
        readWriteLock.readLock().unlock();
    }

    private void writeResource(){
        readWriteLock.writeLock().lock();
        x++;
        readWriteLock.writeLock().unlock();
    }

    public int getX() {
        return x;
    }
}
