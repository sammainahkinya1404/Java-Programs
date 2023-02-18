import java.util.Vector;

public class StrassenMatrixMultiplication {

    public static Vector<Vector<Integer>> strassenMultiply(Vector<Vector<Integer>> A, Vector<Vector<Integer>> B) {

        int n = A.size();

        if (n == 1) {
            Vector<Integer> row = new Vector<Integer>();
            row.add(A.get(0).get(0) * B.get(0).get(0));
            Vector<Vector<Integer>> C = new Vector<Vector<Integer>>();
            C.add(row);
            return C;
        } else {

            // Divide matrices into submatrices
            Vector<Vector<Integer>> A11 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> A12 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> A21 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> A22 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> B11 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> B12 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> B21 = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> B22 = new Vector<Vector<Integer>>();

            for (int i = 0; i < n / 2; i++) {
                Vector<Integer> rowA11 = new Vector<Integer>();
                Vector<Integer> rowA12 = new Vector<Integer>();
                Vector<Integer> rowA21 = new Vector<Integer>();
                Vector<Integer> rowA22 = new Vector<Integer>();
                Vector<Integer> rowB11 = new Vector<Integer>();
                Vector<Integer> rowB12 = new Vector<Integer>();
                Vector<Integer> rowB21 = new Vector<Integer>();
                Vector<Integer> rowB22 = new Vector<Integer>();

                for (int j = 0; j < n / 2; j++) {
                    rowA11.add(A.get(i).get(j));
                    rowA12.add(A.get(i).get(j + n / 2));
                    rowA21.add(A.get(i + n / 2).get(j));
                    rowA22.add(A.get(i + n / 2).get(j + n / 2));
                    rowB11.add(B.get(i).get(j));
                    rowB12.add(B.get(i).get(j + n / 2));
                    rowB21.add(B.get(i + n / 2).get(j));
                    rowB22.add(B.get(i + n / 2).get(j + n / 2));
                }

                A11.add(rowA11);
                A12.add(rowA12);
                A21.add(rowA21);
                A22.add(rowA22);
                B11.add(rowB11);
                B12.add(rowB12);
                B21.add(rowB21);
                B22.add(rowB22);
            }

            // Calculate the 10 submatrices
            Vector<Vector<Integer>> S1 = subtract(B12, B22);
            Vector<Vector<Integer>> S2 = add(A11, A12);
            Vector<Vector<Integer>> S3 = add(A21, A22);
            Vector<Vector<Integer>> S4 = subtract(B21, B11);
            Vector<Vector<Integer>> S5 = add(A11, A22);
            Vector<Vector<Integer>> S6 = add(B11, B22);
            Vector<Vector<Integer>> S7 = subtract(A12, A22);
            Vector<Vector<Integer>> S8 = add(B21, B22);
        }
    }
}
