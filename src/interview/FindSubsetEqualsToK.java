package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubsetEqualsToK {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int k = 4;

        ArrayList<ArrayList<Integer>> list  = findTheSubsets(nums);
        for (List<Integer> integers : list) {

            Integer sum = integers.stream()
                    .mapToInt(Integer::intValue)
                            .sum();
            if(sum == k){
                System.out.println("the substring with the sum equals to k is " + integers.toString());
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findTheSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        backTrack(list,new ArrayList<>(),nums,0);

        return list;
    }

    private static ArrayList<ArrayList<Integer>> backTrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempArray, int[] nums, int start) {
        list.add(new ArrayList<>(tempArray));
        for(int i = start ;i < nums.length ; i++){
            tempArray.add(nums[i]);
            backTrack(list,tempArray,nums,i+1);
            tempArray.remove(tempArray.size()-1);
        }
        return list;
    }
}
