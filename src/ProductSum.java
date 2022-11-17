import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProductSum {
    public static void main(String[] args) {
        int [] nums = {100,2,3,4,100,5,6,7,100};
        int k = 100;
        findTheProduct(nums,k);
    }
    /*
    [10],
    [5],
     [2],
      [6],
      [10, 5],
       [5, 2],
        [2, 6],
         [5, 2, 6]
     */

    /*
    [10]
    [10, 5]
    [5, 2]
    [5, 2, 6]
     */
    private static void findTheProduct(int[] nums, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int prior = 1;
        int count = 0;
        int start = 0;
        for(int i =0 ; i < nums.length ;i++){
            if(nums[i]>=k){
                start++;
                arrayList.removeAll(arrayList);
                continue;
            }
            if( k == 0){
                break;
            }
            if(prior * nums[i] < k){
                arrayList.add(nums[i]);
                prior *= nums[i];

            }else{
                while(prior*nums[i]>=k && arrayList.size()>0){
                    prior = prior/ arrayList.get(0);
                    System.out.println("arraylist prior removal" + arrayList);
                    arrayList.remove(0);
                    System.out.println("arraylist after removal  " + arrayList);
                    start++;
                }


                if(prior * nums[i] <k){
                    arrayList.add(nums[i]);
                    prior*=nums[i];
                }
            }
            count+=i - start+1;

        }
        System.out.println(count);
    }

    private static void printArrayList(ArrayList<Integer> arrayList) {
        System.out.println(arrayList);
    }
}
