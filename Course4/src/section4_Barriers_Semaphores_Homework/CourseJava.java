package section4_Barriers_Semaphores_Homework;

import section4_Barriers_Semaphores_Homework.CourseJava;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseJava {
    /* Write a program that:
    Creates class CourseJava which has 4 methods (just shows a corresponding message):
    setUpCourse()
    ongoingCourse()
    testCourse()
    performTask() that calls the other methods
    Knowing there are 6 students enrolled to the course and all need to do the setup before the course,
    respectively to be prepared before the beginning of the test,
     create a synchronisation mechanism, such that there is a thread for each student.*/
    private void setUpCourse(){
        System.out.println("Before the course");
    };

    private void ongoingCourse(){
        System.out.println("ongoing course");
    }

    private void testCourse(){
        System.out.println("Examination taking place for course");
    }
    public void performTask(CyclicBarrier barrier){
        setUpCourse();
        try {
            barrier.await();
            ongoingCourse();
            barrier.await();
            testCourse();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int nrStudents= 6;
        ExecutorService executorService = Executors.newFixedThreadPool(nrStudents);

        CourseJava courseJava= new CourseJava();
        CyclicBarrier barrier= new CyclicBarrier(nrStudents);

        for (int i = 0; i<nrStudents; i++){
            executorService.submit(()-> courseJava.performTask(barrier));
        }

        executorService.shutdown();


    }
}
