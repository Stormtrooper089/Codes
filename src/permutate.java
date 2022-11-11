public class permutate {
    public static void main(String[] args) {
        String s  = "abcde";
        findpermute(s,0,s.length());
    }

    private static void findpermute(String s, int l, int r) {
        if( l == r){
            System.out.println("the string is  " + s);
            return;
        }
        for(int i= l ;i<r ;i++){
            s = swapT(s,l,i);
            findpermute(s,l+1,r);
            s = swapT(s,l,i);
        }
    }

    private static String swapT(String s, int l, int r) {
        char[] charArray =  s.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;

        return String.valueOf(charArray);
    }
}
