package ok.lab.com;

public class Islands {
    public int islandsCount(int[][] matrix) {
        int islandCount = 0;
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                else if(matrix[i][j] == 1) {
                    colorIsland(matrix, i,j);
                    islandCount++;
                }
                else if(matrix[i][j] == 2) {
                    continue;
                }
            }
        }
        return islandCount;
    }
    public void colorIsland(int[][] matrix, int i, int j) {
        if(matrix[i][j] == 0) {
            return;
        }
        if(matrix[i][j] == 2) {
            return;
        }
        if(i >= matrix.length || j >= matrix[0].length || i<0 || j<0 ) {
            return;
        }
        matrix[i][j] = 2;
        colorIsland(matrix, i+1, j);
        colorIsland(matrix, i-1, j);
        colorIsland(matrix, i, j+1);
        colorIsland(matrix, i, j-1);
    }
}
