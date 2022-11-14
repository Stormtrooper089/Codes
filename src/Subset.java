import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        int arr[]  =  {1,2,3,4};
        List<List<Integer>> list  = subsets(arr);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

     //1 2 3 4


    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list =  new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<Integer>(),nums,0);
        return list ;
    }

    private static void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i = start;  i < nums.length;i++ ){
            tempList.add(nums[i]);
            backTrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
