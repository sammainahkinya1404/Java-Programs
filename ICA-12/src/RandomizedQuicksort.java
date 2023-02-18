import java.util.*;

public class RandomizedQuicksort {
    public static void main(String[] args) {
        Vector<Integer> array = new Vector<Integer>(Arrays.asList
                (5, 3, 8, 4, 2, 7,
                        1, 10,15, 23, 38, 44, 52,
                        67, 71, 810,25, 33, 48,
                        54, 62, 77, 81,
                        90,45, 53, 68,
                        74, 82, 97, 111, 1210));
        randomizedQuicksort(array, 0, array.size() - 1);
        System.out.println(array);
    }

    public static void randomizedQuicksort(Vector<Integer> array, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(array, p, r);
            randomizedQuicksort(array, p, q - 1);
            randomizedQuicksort(array, q + 1, r);
        }
    }

    public static int randomizedPartition(Vector<Integer> array, int p, int r) {
        int i = (int) (Math.random() * (r - p + 1) + p);
        Collections.swap(array, r, i);
        return partition(array, p, r);
    }

    public static int partition(Vector<Integer> array, int p, int r) {
        int x = array.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array.get(j) <= x) {
                i++;
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, i + 1, r);
        return i + 1;
    }
}
