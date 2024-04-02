package section2_Thread_Runnable;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private int capacity;
    private Queue<T> queue= new LinkedList<>();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        //add element
        while(queue.size() == capacity){
            wait();
        }

        queue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        // we obtain the element T
        while  (queue.isEmpty()){
            wait();
        }
        T item = queue.remove();
        notify();
        return item;
    }
}
