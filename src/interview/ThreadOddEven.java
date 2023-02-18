package interview;

public class ThreadOddEven {

    static int counter = 0;

     Runnable oddRunnable = ()->{
         synchronized (this){
             while(counter < 20){
                 if(counter % 2 != 1){
                     try {
                         wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
                 System.out.println("the number in odd loop is " + counter);
                 counter++;
                 notify();
             }
         }


    };
    Runnable evenRunnable = ()->{
        synchronized (this){
            while(counter < 20 ){
                if(counter % 2 != 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("the number in even loop is " + counter);
                counter++;
                notify();
            }
        }



    };
    public static void main(String[] args) {

        ThreadOddEven threadOddEven = new ThreadOddEven();
        Thread t1 = new Thread(threadOddEven.oddRunnable);
        Thread t2 = new Thread(threadOddEven.evenRunnable);

        t1.start();
        t2.start();

    }
}
