package interview;

public class ContinuosStringSizeK {
    public static void main(String[] args) {
        String s= "xyzzaz";
        int k = 3 ;
        findTheSubStringSizeK(s,k);
    }

    private static void findTheSubStringSizeK(String s, int k) {
        int start = 0;
        int end =0 ;

        for(int i = 0 ; i<s.length() ;i++){
            if(i - start + 1 == k) {
                System.out.println(s.substring(start, i+1));
                start++;
            }
        }
    }
}
