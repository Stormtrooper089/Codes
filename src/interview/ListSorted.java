package interview;

import java.util.*;

public class ListSorted {
    public static void main(String[] args) {
        Integer [] a ={1, 2, 4, 8};
        Integer b[] = {1, 2, 3};
        Integer c[] = {1, 3, 5, 11, 12, 16};
        Integer d [] = {1, 2};

        int k = 3;

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(a));
        arrayList.addAll(Arrays.asList(b));
        arrayList.addAll(Arrays.asList(c));
        arrayList.addAll(Arrays.asList(d));

        HashMap<Integer,Integer> hashMap = new HashMap();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return hashMap.get(o2)-hashMap.get(o1);
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(3,comparator);

        for(int i=0 ; i< arrayList.size() ;i++){
            if(hashMap.containsKey(arrayList.get(i))){
                hashMap.put(arrayList.get(i), hashMap.get(arrayList.get(i))+1 );
            }else{
                hashMap.put(arrayList.get(i),1 );
            }
        }
        pq.addAll(hashMap.keySet());

        int m = 0;
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
            m++;
        }

    }
}
