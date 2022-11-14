import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Stircase {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(findWays(n));
    }

    private static int findWays(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0 ){
            return 1;
        }
        return Math.max(1+findWays(n-1),1+findWays(n-2));
    }
}
