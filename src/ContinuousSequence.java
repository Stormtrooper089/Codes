public class ContinuousSequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

       // findSubsequence(nums);
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for(int i =1; i < nums.length ; i++){
            int currMax =0 ;
            for(int j=0; j < i ; j++){
                if(nums[i] > nums[j]){
                    currMax=Math.max(dp[j],currMax);
                }
            }
            dp[i] = currMax + 1;
        }

        for (int j =0 ; j< dp.length ;j++){
            System.out.println("The length is " + dp[j]);
        }
    }

    private static void findSubsequence(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 0;
        int max = 0;
        int prevMax = 0 ;
        for(int i = 1; i < n; i++){
            prevMax = 0;
            for (int j =0 ; j < i ;j++){
                if(nums[i] > nums[j]){
                    prevMax = Math.max(prevMax,dp[j]);
                }
            }
            dp[i] = prevMax + 1 ;
        }
    }
}
