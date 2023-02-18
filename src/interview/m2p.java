package interview;

import java.beans.BeanProperty;
import java.util.Arrays;

public class m2p {


    public static void main(String[] args) {
        int [] array = {0,1,1,2,2, 2, 1, 0, 1, 2};

        /*
        start = 0
        middle start+1
        end = n-1

        start = 1
        middle 2
        end = n-1
         */
        findTheSortedArray(array,0,1,array.length-1);
    }

    private static void findTheSortedArray(int[] array, int start, int middle, int end) {
        for(int i = 0 ; i< array.length;i++){
            if(array[i] == 0){
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;
                start++;
            }
            if(array[i] == 1){
                middle++;
            }
            if(array[i] == 2){

                int position = findLastNonTwo(array,i);
                if(position < end && position > i){
                    int temp = array[position];
                    array[position] = array[i];
                    array[i] = temp;
                    end = position;
                }



            }
        }


        for(int j =0 ;j < array.length ;j++){
            System.out.println(array[j]);
        }
    }

    private static int findLastNonTwo(int[] array,int dist) {
        for(int i = array.length-1 ; i > dist ;i-- ){
            if(array[i] != 2){
                return i;
            }
        }
        return -1;
    }
}

