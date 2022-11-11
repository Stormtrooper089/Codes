import java.util.*;

public class FindTheBridge {

    private static final int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        int [][] earth = {{0,1,0},{0,1,0},{0,0,1}};

        for(int i =0 ; i < earth.length ;i++){
            for(int j =0; j < earth[0].length ; j++ ){
                if(earth[i][j] == 1){
                    HashSet<List<Integer>> es  = findTheIsland(earth,i ,j,new HashSet<>());
                    break;
                }
            }
        }
    }

    private static HashSet<List<Integer>> findTheIsland(int[][] earth, int i, int j, HashSet<List<Integer>> es) {
        if(!outOFBound(i,j,earth)  && earth[i][j]==1 && es.add(List.of(i,j))){
            for(int [] var : dir){
                findTheIsland(earth,i+var[0],j+var[1],es);
            }
        }

        return es;
    }

    private static boolean outOFBound(int i, int j, int[][] earth) {
        if( i ==-1 || i==earth.length || j ==-1 || j== earth[0].length){
            return true;
        }
        return false;
    }
}
