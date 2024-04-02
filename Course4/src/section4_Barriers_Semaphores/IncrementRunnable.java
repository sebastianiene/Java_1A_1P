package section4_Barriers_Semaphores;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementRunnable implements Runnable{
    private AtomicInteger counter = new AtomicInteger(0);

    public AtomicInteger getCounter() {
        return counter;
    }

    @Override
    public void run() {
        counter.incrementAndGet();
    }


}
