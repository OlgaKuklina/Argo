package ok.lab.com;

public class IslandsPerimeter {

    public static void main(String[] args ) {
        int[][] matrix = {{0,0,0,1,1,1,1,1,1,0,0},
                          {0,0,0,1,1,1,1,1,1,0,0},
                          {0,0,0,1,1,1,0,0,0,0,0},
                          {0,0,0,0,0,0,0,0,0,0,0},
                          {0,1,1,1,1,1,0,0,0,0,0},
                          {0,1,0,0,0,1,1,1,1,1,0},
                          {0,1,1,1,1,1,1,1,1,1,0}};

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(getIslandsPerimeter(matrix));
        for( int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static int getIslandsPerimeter(int[][] matrix) {
        int maxPerimeter = 0;
        for(int i = 0; i< matrix.length; i++) {
            for(int j= 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                if(matrix[i][j] == 1) {
                    int perimeter = getPerimeter(matrix, i, j);
                    if(maxPerimeter > perimeter) {
                        continue;
                    }
                    else {
                        maxPerimeter = perimeter;
                    }
                }
                else if (matrix[i][j] == 2) {
                    continue;
                }
            }
        }
        return maxPerimeter;
    }

    public static int getPerimeter(int[][] matrix, int i, int j) {
        if(i>=matrix.length || j>= matrix[0].length || i<0 || j<0) {
            return 0;
        }
        int perimeter = 0;
        if(matrix[i][j] == 0) {
            return 0;
        }
        if(matrix[i][j] == 2) {
            return 0;
        }
        if((j+1 < matrix[0].length && matrix[i][j +1] == 0) || (i+1 < matrix.length && matrix[i+1][j] == 0) ||
                (i-1 >= 0 && matrix[i-1][j] == 0)
                || (j-1 >= 0 && matrix[i][j-1] == 0)) {
            perimeter = perimeter+1;
            matrix[i][j] = 2;
            perimeter += getPerimeter(matrix, i-1, j);
            perimeter += getPerimeter(matrix, i+1, j);
            perimeter += getPerimeter(matrix, i, j-1);
            perimeter += getPerimeter(matrix, i, j+1);
        }
        else {
            matrix[i][j] = 2;
        }

        return perimeter;
    }
}
