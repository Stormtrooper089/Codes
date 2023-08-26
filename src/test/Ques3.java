package test;

public class Ques3 {


    public static synchronized void printNumber(String name){
        System.out.println("fhh");

    }

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread 1 ");
            printNumber("thread1");
        }
    };

    Runnable r2 = ()-> {
            System.out.println("Thread 2 ");
            printNumber("thread2");
    };
}
