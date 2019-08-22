import org.junit.Assert;
import org.junit.Test;

public class BinarySearchBound {
    public int upperBound(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        int n = arr.length;
        while(left < right && left < n) {
            int mid = (left + right + 1) / 2;
            if(x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

       if(arr[left] < x) return -1;
       else if( arr[left] == x) return left + 1;
       else return left;
    }

    public int lowerBound(int x) {
     return 0;
    }

    @Test
    public void testUpperBound1() {
        Assert.assertEquals(3, upperBound(new int[]{1,3,3,5,6}, 3));
        Assert.assertEquals(1, upperBound(new int[]{1,5,6}, 3));
    }

    @Test
    public void testUpperBound() {
        Assert.assertEquals(4, upperBound(new int[]{1,3,3,3,5,6}, 3));
    }

    @Test
    public void testUpperBoundNoGreaterFound() {
        Assert.assertEquals(4, upperBound(new int[]{1,3,3,3}, 3));
    }

    @Test
    public void testUpperBoundNoGreaterFoundAll() {
        Assert.assertEquals(-1, upperBound(new int[]{1,3,3,3}, 4));
    }
}

