public class Heap {
    int[] arr;
    public Heap(int[] arr) {
        this.arr = new int[arr.length + 1];
        this.arr[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            this.arr[i] = arr[i-1];
        }
        builtHeap();
    }
    public void printHeap() {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }   
    }

    private void builtHeap() {
        int h = (int) Math.ceil(Math.log(arr.length)/Math.log(2));
        int start = ((int) Math.pow(2, h-1)) - 1;
        for (int i = start ; i >= 1 ; i--) {
            siftDown(i);
        }
    }
    private void siftDown(int i) {
        if (leftIndex(i) == 0 && rightIndex(i) == 0) return;
        else if (rightIndex(i) == 0) {
            if (arr[i] < arr[leftIndex(i)]) swap(i, leftIndex(i));
            return;
        }
        else {
            if (arr[i] >= arr[leftIndex(i)] && arr[i] >= arr[rightIndex(i)]) return;
            if (arr[leftIndex(i)] > arr[rightIndex(i)]) {
                swap(i, leftIndex(i));
                siftDown(leftIndex(i));
            }
            else {
                swap(i, rightIndex(i));
                siftDown(rightIndex(i));
            }
        }
    }
    private void swap(int i , int e) {
        int temp = arr[i];
        arr[i] = arr[e];
        arr[e] = temp;
    }
    /*
    private int parentIndex(int i) {
        if (inRange(i/2)) return i/2;
        return 0;
    }
    */
    private int leftIndex(int i) {
        if (inRange(2*i)) return 2*i;
        return 0;
    }
    private int rightIndex(int i) {
        if (inRange(2*i + 1)) return 2*i + 1;
        return 0;
    }
    private boolean inRange(int i ) {
        return (i > 0 && i < arr.length);
    }

}
