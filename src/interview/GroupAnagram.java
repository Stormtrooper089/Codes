package interview;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashmapList = new HashMap<>();
        List<List<String>> finalList = new ArrayList<>();
        for(int i = 0 ; i < strs.length;i++){
            int [] seq = new int[26];
            Arrays.fill(seq,0);
            for(int j = 0 ; j < strs[i].length() ;j++){
                seq[strs[i].charAt(j)-'a']+= 1;
            }
            String result = Arrays.stream(seq)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("-"));
            ArrayList<String> list;
            if(hashmapList.containsKey(result)){
                list = hashmapList.get(result);
            }else{
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            hashmapList.put(result,list);

            System.out.println(result);
        }

        for(String key : hashmapList.keySet()){
            finalList.add(hashmapList.get(key));
        }
        return finalList;
    }
}
