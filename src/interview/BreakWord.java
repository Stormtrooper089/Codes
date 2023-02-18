package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BreakWord {
    public static void main(String[] args) {
        //s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
        String s = "catsanddog";
        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));


        findMatchups(s,wordDict,new ArrayList<String>());
    }

    private static void findMatchups(String s, ArrayList<String> wordDict,ArrayList<String> tillDateResult) {
        boolean found = false;
        for(int i = 0; i < wordDict.size() ;i++){
            if(s.contains(wordDict.get(i))){
                int start = s.indexOf(wordDict.get(i));
                int end = start + wordDict.get(i).length();
                tillDateResult.add(wordDict.get(i));
                found =true;
                findMatchups(s.substring(0,start)+s.substring(end,s.length()),wordDict,tillDateResult);
            }
            if(s.length() == 0){
                System.out.println(tillDateResult);
                found =true;
            }
        }

    }
}

