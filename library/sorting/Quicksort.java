import java.util.Arrays;

@SuppressWarnings("ALL")
public class Quicksort {
    public static void main(String[] args) {
        int a[] = {1,2,3,6,67,87,68,32,4609,87,67,31,55,68,99,33,5,3,2,345,6};
        quickSort(a,0, a.length-1);
        qsort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void qsort(int[] a, int left, int right) {
        if(left < right) {
            int partition = partition(a, left, right);
            printarr(a, partition);
            qsort(a, left, partition - 1);
            qsort(a, partition, right);
        }
    }

    private static void printarr(int[] a, int partition) {
        for(int i = 0; i <  a.length; i++){
            if(i==partition)
                System.out.print("["+a[i]+"]" + " ");
            else
                System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    private static int partition(int[] a, int left, int right) {
        int mid = ( left + right ) / 2;
        int pivot = a[mid];

        while( left <= right) {

            while(a[left] < pivot){
                left++;
            }

            while(a[right] > pivot) {
                right--;
            }

            if(left <= right) {
                int temp = a[right];
                a[right] = a[left];
                a[left] = temp;
                left++;
                right--;
            }

        }

        return left;
    }


    // Taken from https://www.programcreek.com/2012/11/quicksort-array-in-java/
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }


}
