import java.util.Random;
public class QuickSort {
    public void sort(int[] ar) {
        quicksort(ar, 0, ar.length - 1);
    }
    //private----------------------------------------------
    private void quicksort(int[]ar, int f , int l) {
        if (f >= 0 && l >= 0 && f < l) {//**break case if not satisfied
            int split = partition(ar, f, l);
            quicksort(ar, f, split);
            quicksort(ar, split + 1, l);
        }
    }
    private int partition(int[]ar, int f , int l) {
        int pivot = ar[(new Random()).nextInt(f,l)];
        int i = f - 1;
        int j = l + 1;
        while (true) {
            do {
                i = i + 1;
            } while (ar[i] > pivot);
            do {
                j = j - 1;
            } while (ar[j] < pivot);
            if (i >= j) return j;
            swap(ar, i, j);
        }
    }
    private void swap(int[]ar,int i ,int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
