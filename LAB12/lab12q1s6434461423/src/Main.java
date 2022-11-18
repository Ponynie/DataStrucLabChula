public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] listA ={15,9,7,16,31,2,20,25,17,12};
        QuickSort qs = new QuickSort();
        qs.sort(listA); //sort
        printArray(listA);
        int[] listB ={5,2,12,9,1,8,7,18};
        MergeSort ms = new MergeSort();
        listB = ms.sorted(listB); //sorted
        printArray(listB);
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) System.out.println(array[i]);
            else System.out.print(array[i] + ",");
        }
    }
}
