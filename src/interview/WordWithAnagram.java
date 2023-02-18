package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordWithAnagram {
    public static void main(String[] args) {
        String que = "please be silent and listen to what the professor says";
        String [] inputArray = que.split(" ");

        HashMap<String, String> wordToAlphaMatch = new HashMap<>();

        for(int i =0 ; i <inputArray.length ; i++){
            char[] chars = inputArray[i].toCharArray();
            int[] count = new int [26];
            for(char c : chars){
                count[c-'a'] += 1;
            }
            String s = "";
            for(int c=0 ; c<26;c++){
                s=s+String.valueOf(count[c]);
            }
            System.out.println("the string generated is " + s);
            wordToAlphaMatch.put(inputArray[i],s);

        }
        HashMap<String ,Integer> countMatch = new HashMap<>();
        for (String s:
                wordToAlphaMatch.values()) {
            if(!countMatch.containsKey(s)){
                countMatch.put(s,1);
            }else{
                countMatch.put(s,countMatch.get(s)+1);
            }

        }

        for (String s:
             countMatch.keySet()) {
            System.out.println("the word repeated  " +  s  + "  and the count is   " +  countMatch.get(s));
        }

    }
}
