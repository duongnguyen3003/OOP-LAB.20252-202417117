public class MatrixAddition {
    public static void main(String[] args) {
        int[][] matrixA ={
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        int[][] matrixB ={
            {3, 2, 1},
            {1, 2, 7},
            {7, 4, 2},
        };

        int row = matrixA.length;
        int col = matrixA[0].length;

        int[][] resultMatrix = new int [row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
        }

        System.err.println("Matrix A:");
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(matrixA[i][j] + " ");
            }
            System.err.println("");
        }

        System.err.println("Matrix B:");
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(matrixB[i][j] + " ");
            }
            System.err.println("");
        }

        System.err.println("Result Matrix:");
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.err.println("");
        }
    }
}
