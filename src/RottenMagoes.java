public class RottenMagoes {

    public static void main(String[] args) {

        /*
        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
         */
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        String[] index  = findFirstRotten(grid).split(" ");
        if(index[0].equalsIgnoreCase("-1")){
            System.out.println("there is no rotten");
        }

        orangesRotting(grid,Integer.parseInt(index[0]),Integer.parseInt(index[1]),0);

    }

    private static String findFirstRotten(int[][] grid) {
        for(int i = 0 ; i < grid.length; i++){
            for(int j =0 ; j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    return "i " + "j";
                }
            }
        }
        return "-1";
    }

    public static int orangesRotting(int[][] grid, int i, int j,int count) {
        if(checkIfAllRotten(grid)){
            return count;
        }
        return count;
    }

    private static boolean checkIfAllRotten(int[][] grid) {
        for(int i = 0 ; i < grid.length; i++){
            for(int j =0 ; j<grid[0].length;j++){
                if(grid[i][j] != 2){
                    return false;
                }
            }
        }
        return true;
    }
}
