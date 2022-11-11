public class PeakElements {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        findPeakElement(nums);

    }

    public static int findPeakElement(int[] nums) {
        for(int i = 1 ; i < nums.length -1 ; i++){
            if(nums[i] > nums[i-1] && nums[i] < nums[i+1]){
                System.out.println("The peak element is " +  nums[i]);
                return nums[i];
            }
        }
        if(nums[0]>nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums[nums.length-1];
        }
        return -1;
    }
}
