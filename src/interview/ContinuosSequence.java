package interview;

import java.util.HashSet;

public class ContinuosSequence {
    public static void main(String[] args) {
        int [] nums = {100,3,300,4,2,1,101,9,102,16,103,56,104};
        findTheNums(nums);
    }

    private static void findTheNums(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:
             nums) {
            hashSet.add(i);
        }

        for(int i = 0 ; i < nums.length ;i++){
            int currLength = 1 ;
            int entry = nums[i];
            while(hashSet.contains(entry+1)){
                currLength++;
                entry++;
                maxLength= Math.max(currLength,maxLength);
            }
        }
        System.out.println("the maximum length is " + maxLength);
    }

}
