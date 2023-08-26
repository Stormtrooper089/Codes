package interview;

import java.util.Comparator;
import java.util.PriorityQueue;

 class Box1{
    int id;
    int size;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

class Solution1 {
    public static void main(String[] args) {
        int [][] boxType  = {{1,3},{2,2},{3,1}};

        int truckSize = 4;
        System.out.println(maximumUnits(boxType,truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {


        Comparator<Box1> cmp = new Comparator<Box1>() {
            public int compare(Box1 s1, Box1 s2) {
                return s2.size - s1.size;
            }
        };
        PriorityQueue<Box1> pq = new PriorityQueue<Box1>(cmp);

        for(int[] array : boxTypes){
            Box1 box =  new Box1();
            box.setId(array[0]);
            box.setSize(array[1]);
            pq.add(box);
        }

        int count = 0;
        while(truckSize > 0 && !pq.isEmpty()){
            Box1 b = pq.poll();
            if( b != null ){
                if( b.getId() <= truckSize){

                    count += b.getId() * b.getSize();
                    truckSize = truckSize - b.getId();
                    System.out.println(" If part  " + count);

                }else{
                    count += truckSize * b.getSize();
                    System.out.println(" else part  " + count);

                    truckSize = 0;
                }
            }

        }
        return count;

    }
}