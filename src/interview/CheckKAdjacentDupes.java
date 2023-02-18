package interview;

import lombok.Data;

class Location{
    int start;
    int end;
    boolean isDupes;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean isDupes() {
        return isDupes;
    }

    public void setDupes(boolean dupes) {
        isDupes = dupes;
    }
}

public class CheckKAdjacentDupes {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("pbbcggttciiippooaais");
        int k = 2;
        StringBuilder answer = removesKDupes(s,k);
        System.out.println("the answer is " + answer.toString());
    }

    private static StringBuilder removesKDupes(StringBuilder s, int k) {

        while(dupesPossible(s,k-1).isDupes){
            Location location = dupesPossible(s,k-1);
            s = new StringBuilder(s.substring(0, location.start).concat(s.substring(location.end + 1, s.length())));
        }
        return s;
    }

    private static Location dupesPossible(StringBuilder s, int k) {
        Location location = new Location();
        location.setDupes(false);
        boolean flag = true;
        for(int i =0 ; i < s.length()-k ;i++){
            while(k>0){
                if(s.charAt(i) != s.charAt(i+k)){
                    flag =false;
                }
                k--;
            }
            if(flag){
                location.setDupes(true);
                location.setStart(i);
                location.setEnd(i+k);
                return location;
            }
        }
        return location;
    }
}
