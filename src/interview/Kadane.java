package interview;

public class Kadane {
    public static void main(String[] args) {
        int [] nums= {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            maxEndingHere = Math.max(x, maxEndingHere + x);
            System.out.println("the value of i " + i +  "  max end here "  + maxEndingHere  + "   max so far  " + maxSoFar);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            System.out.println("max after calculate  " + maxSoFar);
        }

        return maxSoFar;

    }
}
