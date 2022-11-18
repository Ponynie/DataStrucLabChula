public class MergeSort {
    public int[] sorted(int[] ar) {
        //base case (return itseft if length is 1)
        if (ar.length <= 1) return ar;
        //recursive case
        //create left and right empty arrays with calculated size
        int Lsize = ar.length/2;
        int Rsize;
        if (ar.length % 2 == 0) Rsize = ar.length/2;
        else Rsize = ar.length/2 + 1;
        int[] left = new int[Lsize];
        int[] right = new int[Rsize];
        //create left and right array (fill elements to empty array)
        int k = 0, j = 0;
        for (int i = 0; i < ar.length; i++) {
            if (i < ar.length/2)  {
                left[k] = ar[i];
                k++;
            }
            else {
                right[j] = ar[i];
                j++;
            }
        }
        //recursively sort both subarray
        left = sorted(left);
        right = sorted(right);
        //merge now-sorted subarray
        return merge(left, right);
    }
    //private----------------------------------------------------------------
    private int[] merge(int[]left, int[]right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                result[k] = left[i];
                i++;
                k++;
            }
            else {
                result[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }
}
