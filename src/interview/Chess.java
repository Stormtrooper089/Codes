package interview;


class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Chess {
    public static void main(String[] args) {
        /*
        Input: N 8
        Knight Position (X): 1,2
        Target (Y): 7,5

         */
        Position startPosition = new Position(0, 0);
        Position targetPosition = new Position(99, 99);

        int[][] visited = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] pos = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {-1, 2}, {1, 2}, {1, -2}, {-1, -2}};
        findMinMoves(startPosition, targetPosition, 0, Integer.MAX_VALUE, pos, visited);
        // 1 2

    }

    private static void findMinMoves(Position startPosition, Position targetPosition, int moves, int minMoves, int[][] pos, int[][] visited) {


        if (minMoves < moves) {
            return ;
        }
        if (!positionValid(startPosition)) {
            return;
        }

        if (visited[startPosition.getX()][startPosition.getY()] < moves) {
            return;
        }

        if (startPosition.getY() == targetPosition.getY() && startPosition.getX() == targetPosition.getX()) {
            if (minMoves > moves) {
                minMoves = moves;
                System.out.println("The minMoves to target pos is  " + moves);
            }
        }

        for (int[] position : pos) {
            if (positionValid(startPosition)) {
                //visited[startPosition.getX()][startPosition.getY()] = 1;
                if(visited[startPosition.getX()][startPosition.getY()] > moves){
                    visited[startPosition.getX()][startPosition.getY()] = moves;
                }
            }
            int x = position[0] + startPosition.getX();
            int y = position[1] + startPosition.getY();
            startPosition.setX(x);
            startPosition.setY(y);
            findMinMoves(startPosition, targetPosition, moves + 1, minMoves, pos, visited);

        }

    }

    private static boolean positionValid(Position startPosition) {
        if (startPosition.getX() >= 0 && startPosition.getX() < 100 && startPosition.getY() >= 0 && startPosition.getY() < 100) {
            return true;
        }
        return false;
    }

}
