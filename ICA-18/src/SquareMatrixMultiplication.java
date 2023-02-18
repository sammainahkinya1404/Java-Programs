public class SquareMatrixMultiplication {
    public static int[][] squareMatrixMultiplyRecursive(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            // Partition the matrices
            int[][] A11 = partitionMatrix(A, 0, n / 2 - 1, 0, n / 2 - 1);
            int[][] A12 = partitionMatrix(A, 0, n / 2 - 1, n / 2, n - 1);
            int[][] A21 = partitionMatrix(A, n / 2, n - 1, 0, n / 2 - 1);
            int[][] A22 = partitionMatrix(A, n / 2, n - 1, n / 2, n - 1);

            int[][] B11 = partitionMatrix(B, 0, n / 2 - 1, 0, n / 2 - 1);
            int[][] B12 = partitionMatrix(B, 0, n / 2 - 1, n / 2, n - 1);
            int[][] B21 = partitionMatrix(B, n / 2, n - 1, 0, n / 2 - 1);
            int[][] B22 = partitionMatrix(B, n / 2, n - 1, n / 2, n - 1);

            // Recursively calculate products
            int[][] C11 = addMatrices(squareMatrixMultiplyRecursive(A11, B11),
                    squareMatrixMultiplyRecursive(A12, B21));
            int[][] C12 = addMatrices(squareMatrixMultiplyRecursive(A11, B12),
                    squareMatrixMultiplyRecursive(A12, B22));
            int[][] C21 = addMatrices(squareMatrixMultiplyRecursive(A21, B11),
                    squareMatrixMultiplyRecursive(A22, B21));
            int[][] C22 = addMatrices(squareMatrixMultiplyRecursive(A21, B12),
                    squareMatrixMultiplyRecursive(A22, B22));

            // Combine the submatrices
            combineMatrices(C11, C12, C21, C22, C);
        }


        return C;
    }

    private static int[][] partitionMatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        int size = endRow - startRow + 1;
        int[][] result = new int[size][size];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                result[i - startRow][j - startCol] = matrix[i][j];
            }
        }

        return result;
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int size = matrix1.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

/**
 * Combines four submatrices into a larger matrix
 *
 * @param A the matrix for the top-left submatrix
 * @param B the matrix for the top-right submatrix
 * @param C the matrix for the bottom-left submatrix
 *
 **/
public static void combineMatrices(int[][] A, int[][] B, int[][] C, int[][] D, int[][] result) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i < n/2 && j < n/2) {
                result[i][j] = A[i][j];
            } else if (i < n/2 && j >= n/2) {
                result[i][j] = B[i][j - n/2];
            } else if (i >= n/2 && j < n/2) {
                result[i][j] = C[i - n/2][j];
            } else {
                result[i][j] = D[i - n/2][j - n/2];
            }
        }
    }
}

}