package interview;

import java.sql.Array;
import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int [] nums = {4,6,4,4,4,5,5,1,1,1,2,2,3,4,5,4,6,4,4,4,5,5};
        int n = nums.length;
        int k = 2;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i:
             nums) {
            list.add(i) ;
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i:
             list) {
            System.out.println("the sorted array element is " + i );
        }

        //
        // findTheTop(nums,n,k);
    }

    private static void findTheTop(int[] nums, int n, int k ) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o1);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.addAll(map.keySet());

        for (int m = 0; m < k; m++) {
            Integer val = pq.poll();
            System.out.println(val);
        }


        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(map.keySet());

        System.out.println(treeSet.toString());

    }
}
