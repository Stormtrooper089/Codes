package interview;

import java.util.ArrayList;
import java.util.HashMap;

public class AlternatePaths {

    public static void main(String[] args) {
        int n = 3 ;
        int [][] redEdges ={{0,1},{1,2}};
        int [][] blueEdges ={};
    }
    public void shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        HashMap<Integer, ArrayList<Integer>> redEdgesPath = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> blueEdgesPath = new HashMap<>();

        for (int[] row:
             redEdges) {
            if(redEdgesPath.containsKey(row[0])){
                redEdgesPath.get(row[0]).add(row[1]);
            }else{
                redEdgesPath.put(row[0],new ArrayList<>(row[1]));
            }
        }

        for (int[] row:
                blueEdges) {
            if(blueEdgesPath.containsKey(row[0])){
                blueEdgesPath.get(row[0]).add(row[1]);
            }else{
                blueEdgesPath.put(row[0],new ArrayList<>(row[1]));
            }
        }

    }
}
