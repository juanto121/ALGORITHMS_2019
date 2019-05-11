import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        //int a[] = {5,4,3,2,1};
        //int a[] = {5,4};
        //int a[] = {1,2,3,6,67,87,1,5,3,2,1,345,6};

        int a[] = {1,2,3,6,67,87,68,32,4609,87,67,31,55,68,99,33,5,3,2,345,6};
        qsort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void qsort(int[] a, int left, int right) {
        if(left < right) {
            int partition = partition(a, left, right);
            if(left < partition)
                qsort(a, left, partition - 1);
            if(right > partition)
                qsort(a, partition+1, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int mid = ( left + right ) / 2;
        int pivot = a[mid];

        while( left < right) {

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


}
