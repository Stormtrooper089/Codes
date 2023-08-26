package interview;

import java.util.Arrays;

public class Robbers {
    public static void main(String[] args) {
        int [] nums =  {2,7,9,3,1};
        int [] max = new int[nums.length];
        Arrays.fill(max,-1);
        System.out.println(findTheRobbersMax(nums,0,nums.length,max,false));
    }

    private static int findTheRobbersMax(int[] nums,int i,int n,int[] max,boolean isFirstIncluded) {
        if(i == n-1 && isFirstIncluded){
            return 0;
        }
        if(i >= n ){
            return 0;
        }
        if(max[i] != -1){
            return max[i];
        }
        int include  = nums[i] + findTheRobbersMax(nums,i+2,n,max,true);
        int exclude = findTheRobbersMax(nums,i+1,n,max,false);

        max[i] = Math.max(include,exclude);
        return max[i];
    }
}
