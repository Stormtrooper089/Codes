package interview;

public class SubArraySum {
    public static void main(String[] args) {
        int [] nums = {2,3,6,2,7,9,11};
        int k = 3;

        int left = 0 ;
        int right = 0 ;
        int sum = 0;
        int maxSum = 0;

        while(right < nums.length){
            sum+=nums[right];
            System.out.println("printing just the indexes  " + left  +  "  " + right +  "  and the sum is " + sum);
            if(maxSum < sum){
                maxSum = sum;
            }
            if(right - left + 1 < k){
                right++;
            }else if(right - left + 1 == k){
                sum = sum - nums[left];
                left++;
                right++;
            }
        }
        System.out.println("the maxium subarray sum of size k  is " + maxSum);
    }
}
