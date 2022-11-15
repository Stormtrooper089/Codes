import java.util.Arrays;

public class Robbers {
    public static void main(String[] args) {
        int [] nums =  {2,7,9,3,1};
        int [] max = new int[nums.length];
        Arrays.fill(max,-1);
        System.out.println(findTheRobbersMax(nums,0,nums.length,max));
    }

    /*
        private int solve(int nums[],int i,int dp[]){

        if(i>=nums.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int a=nums[i]+solve(nums,i+2,dp);
        int b=solve(nums,i+1,dp);

        return dp[i]=Math.max(a,b);


    }
     */
    private static int findTheRobbersMax(int[] nums,int i,int n,int[] max) {
        if(i >= n){
            return 0;
        }
        if(max[i]!=-1){
            return max[i];
        }
        int include  = nums[i] + findTheRobbersMax(nums,i+2,n,max);
        int exclude = findTheRobbersMax(nums,i+1,n,max);

        max[i] = Math.max(include,exclude);
        return max[i];
    }
}
