import org.junit.Assert;
import org.junit.Test;

public class BinarySearchClosest {

    /*
        Returns the index of closest to searched item.
        if closest to left is equidistant to closest to right returns the lowest index possible.
     */

    public int search(int a[], int n) {
        if(n < a[0]) return 0;
        if(n > a[a.length-1]) return a.length-1;
        int left = 0;
        int right = a.length - 1;
        while(left <= right) {
            int mid =  (left + right) / 2;
            if(a[mid] == n) return mid;
            if(n < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return Math.abs(a[left] - n) < Math.abs(a[right] - n) ? left : right;
    }

    @Test
    public void test() {
    }

    @Test
    public void testFound() {
        Assert.assertEquals(1, search(new int[]{1,2,3}, 2));
        Assert.assertEquals(0, search(new int[]{1,2,3}, 1));
        Assert.assertEquals(2, search(new int[]{1,2,3}, 3));
    }

    @Test
    public void testNotFound() {
        Assert.assertEquals(2, search(new int[]{1,2,3}, 4));
        Assert.assertEquals(0, search(new int[]{1,2,3}, 0));
        Assert.assertEquals(3, search(new int[]{1,2,3,6}, 5));
        Assert.assertEquals(2, search(new int[]{1,2,3,6}, 4));
    }

    @Test
    public void testNotFoundEquidistant() {
        Assert.assertEquals(2, search(new int[]{1,2,3,5,6}, 4));
    }
}
