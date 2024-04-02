package section4_Barriers_Semaphores;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int nrStudents= 10;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        courseJava courseJava= new courseJava();
        CyclicBarrier barrier= new CyclicBarrier(10);

        for (int i = 0; i<10; i++){
            executorService.submit(()-> courseJava.performTask(barrier));
        }

        executorService.shutdown();


    }
}

class courseJava{
    private void setUpCurs(){
        System.out.println("Before the course");
    };

    private void ongoingCourse(){
        System.out.println("ongoing course");
    }

    private void testCourse(){
        System.out.println("Examination taking place for course");
    }

    public void performTask(CyclicBarrier barrier){
        setUpCurs();
        try {
            barrier.await();
            ongoingCourse();
            barrier.await();
            testCourse();
        } catch (InterruptedException| BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
