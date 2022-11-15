import java.util.*;

public class InversionList {
    public static void main(String[] args) {
        int [] nums = {1, 20, 6, 4, 5};

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
        int count = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();

        int [] max = new int[nums.length];

        for(int i =0 ; i< nums.length;i++){

            arrayList.add(nums[i]);

            for(int j = i ;j < nums.length;j++){
                if(nums[j] < nums[i]){
                    count+=1;
                }
            }
        }
        System.out.println("the inversion count  is "  +  count);



    }
}
