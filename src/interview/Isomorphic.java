package interview;

import java.util.Arrays;

public class Isomorphic {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        isIsomorphic(s,t);
    }

    public static boolean isIsomorphic(String s, String t) {
        int [] first = new int[26];
        int [] second = new int[26];

        for(int i =0 ; i < s.length() ;i++){
            first[s.charAt(i)-'a']+=1;
        }

        for(int i = 0 ; i < t.length() ;i++){
            second[t.charAt(i)-'a']+=1;
        }

        Arrays.sort(first);
        Arrays.sort(second);

        for(int i = 0 ;i< 26;i++){
            System.out.println(first[i] + "   second  " + second[i]);
            if(first[i] != second[i]){
                return false;
            }
        }
        return true;


    }
}
