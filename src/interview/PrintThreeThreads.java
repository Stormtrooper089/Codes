package interview;


class PrintSequence implements Runnable{

    private static int number  = 0 ;
    private int modulo;
    public PrintSequence(int modulo){
        this.modulo = modulo;
    }
    static Object lock = new Object();


    @Override
    public void run() {

        synchronized (lock){
            while(number < 30){
                while(number % 3 != modulo){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("the number printed is  " + number + "  by the thread " + Thread.currentThread().getName());
                number++;
                lock.notifyAll();
            }

        }

    }
}

public class PrintThreeThreads {
    public static void main(String[] args) {


        Thread thread = new Thread(new PrintSequence(0),"t1");
        Thread thread2 = new Thread(new PrintSequence(1),"t2");
        Thread thread3 = new Thread(new PrintSequence(2),"t3");

        thread.start();
        thread2.start();
        thread3.start();

    }
}
