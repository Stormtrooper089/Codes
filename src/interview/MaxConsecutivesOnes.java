package interview;

import java.util.Arrays;

public class MaxConsecutivesOnes {
    public static void main(String[] args) {
        int [] nums= {1,1,1,0,0,0,1,1,1,1,0};
        //1,1,1,0,0,0,1,1,1,1,0
        //1 2 3 4 5 1 2 3 4 5 6
        int k = 3;

        findMax(nums,k);
    }

    private static void findMax(int[] nums, int k) {
        int n = nums.length;
        int dp[] = new int[n];
        if(nums[0] == 0){
            dp[0] = 0;
        }else{
            dp[0]=1;
        }

        int curr = 0 ;
        boolean flag;
        for(int i=1 ; i < n ;i++){
            flag = false;
            if(nums[i] == 1 ){
                dp[i] =dp[i-1]+1;
            }
            if(nums[i] == 0 && k > 0){
                dp[i]=dp[i-1]+1;
                k--;
                flag =true;
            }
            if(k <= 0 && nums[i] ==0 && !flag){
                dp[i]=1;
                k=1;
            }
        }

        int max =0 ;
        for(int m =0 ; m < n ;m++){
            System.out.print(dp[m] + " ");
            if(dp[m] > max){
                max = dp[m];
            }
        }

        System.out.println("the max output is  " + max);



    }
}
