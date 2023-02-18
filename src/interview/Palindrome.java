package interview;

import java.util.PriorityQueue;

public class Palindrome {

    public static void main(String[] args) {
        String s = "abbac";
        generateAllLengthString(s,0);
    }

    private static void generateAllLengthString(String s,int length) {
        if(s.length() < 1){
            return;
        }
        if(checkPalindrome(s)){
            if(length < s.length()){
                length = s.length();
                System.out.println("the palindrome is of length "  + s);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.remove(5);
        generateAllLengthString(s.substring(0,s.length()-1),length);
        generateAllLengthString(s.substring(1,s.length()),length);

    }

    private static boolean checkPalindrome(String s) {
        if(s.length() ==1){return false ;}
        char[] element = s.toCharArray();
        for(int i =0; i <element.length/2 ; i++){
            if(element[i] != element[element.length-1-i]){
                return false;
            }
        }
        return true;
    }


}
