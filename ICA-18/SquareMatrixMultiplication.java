public class SquareMatrixMultiplication {
    public static int[][] squareMatrixMultiplyRecursive(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            // Partition the matrices
            int[][] A11 = partitionMatrix(A, 0, 0);
            int[][] A12 = partitionMatrix(A, 0, n/2);
            int[][] A21 = partitionMatrix(A, n/2, 0);
            int[][] A22 = partitionMatrix(A, n/2, n/2);

            int[][] B11 = partitionMatrix(B, 0, 0);
            int[][] B12 = partitionMatrix(B, 0, n/2);
            int[][] B21 = partitionMatrix(B, n/2, 0);
            int[][] B22 = partitionMatrix(B, n/2, n/2);

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
            combineMatrices(C11, C, 0, 0);
            combineMatrices(C12, C, 0, n/2);
            combineMatrices(C21, C, n/2, 0);
            combineMatrices(C22, C, n/2, n/2);
        }

        return C;
    }


}
