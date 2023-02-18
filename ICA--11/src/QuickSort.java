import java.util.Vector;

public class QuickSort {
    public static void main(String[] args) {
        Vector<Integer> array = new Vector<Integer>();
        array.add(10);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(1);
        array.add(5);
        array.add(10);
        array.add(78);
        array.add(88);
        array.add(79);
        array.add(21);
        array.add(35);
        array.add(10);
        array.add(47);
        array.add(48);
        array.add(49);
        array.add(41);
        array.add(45);
        array.add(10);
        array.add(47);
        array.add(48);
        array.add(69);
        array.add(61);
        array.add(65);
        array.add(10);
        array.add(67);
        array.add(68);
        array.add(69);
        array.add(61);
        array.add(55);
        array.add(10);
        array.add(57);
        array.add(58);
        array.add(59);
        array.add(51);
        array.add(55);


        quicksort(array, 0, array.size() - 1);

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void quicksort(Vector<Integer> array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quicksort(array, p, q - 1);
            quicksort(array, q + 1, r);
        }
    }

    public static int partition(Vector<Integer> array, int p, int r) {
        int x = array.get(r);
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array.get(j) <= x) {
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        int temp = array.get(i + 1);
        array.set(i + 1, array.get(r));
        array.set(r, temp);
        return i + 1;
    }
}
