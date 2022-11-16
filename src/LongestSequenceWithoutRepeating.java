import java.util.HashMap;

public class LongestSequenceWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcdbb";
        findTheRepeatingLength(s);
    }

    private static void findTheRepeatingLength(String s) {
        char[] charArray = s.toCharArray();
        int max = 0;

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int start =0 ;
        int end =0;
        for(int i =0 ; i < charArray.length ;i++){
            if(hashMap.containsKey(charArray[i])){
                hashMap.put(charArray[i], hashMap.get(charArray[i]) +1);
            }else{
                hashMap.put(charArray[i],1);
            }
            if(checkifEverythingUnique(hashMap)){
                max=Math.max(max,i-start+1);

            }else{
                while(!checkifEverythingUnique(hashMap) && start < charArray.length){
                    hashMap.put(charArray[start], hashMap.get(charArray[start])-1);
                    if(hashMap.get(charArray[start])==null){
                        hashMap.remove(charArray[start]);
                    }
                    start++;
                }
            }
        }
        System.out.println("The maximum substring with unique length is  " + max);
    }
    private static boolean checkifEverythingUnique(HashMap<Character, Integer> hashMap) {
        for(Character c : hashMap.keySet()){
            if(hashMap.get(c)!= (Integer)1){
                return false;
            }
        }
        return true;
    }
}
