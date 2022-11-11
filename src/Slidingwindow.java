import java.util.ArrayList;
import java.util.OptionalInt;

public class Slidingwindow {
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int arrSize = nums.length;


        ArrayList<Integer> currArr = new ArrayList<>();
        int[] ans = new int[arrSize - k + 1];
        for(int i =0 ; i < k ;i++){
            currArr.add(nums[i]);
        }

        OptionalInt max = currArr.stream()
                .mapToInt(Integer::intValue)
                .max();
        ans[0] = max.getAsInt();
        int j = 0;
        for(int i = k ; i < arrSize; i++){


            currArr.remove(0);
            currArr.add(nums[i]);
            System.out.println("the curent array at this moment is " + currArr);
            max = currArr.stream()
                    .mapToInt(Integer::intValue)
                    .max();
            j++;
            ans[j]=max.getAsInt();
        }
        for(int u=0 ; u < ans.length ; u++){
            System.out.println(ans[u]);
        }
        //return ans;
    }
}
