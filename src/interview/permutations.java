package interview;

import java.util.HashSet;
import java.util.Set;

public class permutations {
    static int currSum = 0 ;
    public static void main(String[] args) {
        String  s = "ashish";
        Set<String> stringSet = new HashSet<>();
        stringSet = findPermutations(s,0,s.length(),stringSet);
        for (String value :
             stringSet) {
            System.out.println(" the string generated are " + value);
        }

        System.out.println("the number of unique generated is " + stringSet.size());

        int[] d1 = new int[] {1,0,-1,0};
        int [][] arraydk = {{1,3,4},{2,4,5}};
    }

    private static Set<String> findPermutations(String s, int l, int r, Set<String> stringSet) {
        if( l == r ){
            stringSet.add(s);
            //System.out.println("The currsum is " +  s +  "  dsj  " +  currSum++ );
        }
        for( int i = l ; i< r ;i++){
            s =  swap(s,l,i);
            findPermutations(s,l+1 , r, stringSet);
            s = swap(s,l,i);
        }
        return stringSet;
    }

    private static String swap(String s, int l, int r) {
        char[] stringArray = s.toCharArray();
        char temp = stringArray[l];
        stringArray[l]  =  stringArray[r];
        stringArray[r] = temp;

        return String.valueOf(stringArray);
    }
}
