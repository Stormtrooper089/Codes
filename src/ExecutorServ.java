import java.util.Random;
import java.util.concurrent.*;

class Task implements Callable<Integer>{
    @Override
    public Integer call(){
        return new Random().nextInt();
    }
}

public class ExecutorServ {
    public static void main(String[] args){

        Runnable runnable = ()->{
            System.out.println("the thread is created");
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(runnable);

        Future<Integer> future = executorService.submit(new Task());
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
