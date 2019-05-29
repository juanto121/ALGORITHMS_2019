import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public int threeSumClosest(List<Integer> A, int B) {
        return sumthreev2(A, B);
    }

    //O(N^2 * log(N) + N*Log(N))
    public int sumthreev3(List<Integer> A, int B) {
        Collections.sort(A);
        int len = A.size();
        int minSumSoFar = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i != j){
                    int partialSum = A.get(i) + A.get(j);
                    int sum = partialSum + findClosest(A, B, partialSum, i, j);
                    if(minDiff > Math.abs(sum-B)) {
                        minSumSoFar = sum;
                        minDiff = Math.abs(sum-B);
                    }
                }
            }
        }
        return minSumSoFar;
    }

    public int findClosest(List<Integer> A, int target, int partialSum, int first, int second) {
        int diff = target - partialSum;
        System.out.println("sum: " + partialSum+" ");
        A.remove(first);
        A.remove(second-1);
        int closestIndexToDiff = binarySearch(A, 0, A.size()-1, diff, Integer.MAX_VALUE, -1);
        return A.get(closestIndexToDiff);
    }

    public int binarySearch(List<Integer> A, int low, int high, int search, int minDiff, int index) {
        if(low < high) {
            int mid = (low + high) / 2;
            int foundDiff = Math.abs(A.get(mid)-search);
            System.out.println("mid: " + A.get(mid) + " diff: " + foundDiff);
            if( foundDiff < minDiff ) {
                minDiff = foundDiff;
                index = mid;
            }
            int midVal = A.get(mid);
            if(midVal == search) return mid;
            else {
                if(search < midVal) {
                    return binarySearch(A, low, mid, search, minDiff, index);
                } else {
                    return binarySearch(A, mid+1, high, search, minDiff, index);
                }
            }
        } else {
            return index;
        }
    }

    //O(N^3)
    public int sumthreev2(List<Integer> A, int B) {
        int len = A.size();
        int minSumSoFar = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(i != j)
                    for(int k = 0; k < len; k++) {
                        if(k != j && k != i) {
                            int sum = A.get(i) + A.get(j) + A.get(k);
                            if(minDiff > Math.abs(sum-B)) {
                                minSumSoFar = sum;
                                minDiff = Math.abs(sum-B);
                            }
                        }
                    }
            }
        }
        return minSumSoFar;
    }

    //O(2^N)
    int min = Integer.MAX_VALUE;
    int minSum = Integer.MAX_VALUE;

    public void sumthree(List<Integer> nums, int current, int selected, int sum, int target) {
        if(selected == 3){
            if(Math.abs(sum-target) < min){
                min = Math.abs(sum-target);
                minSum = sum;
            }
        } else if(current < nums.size()){
            sum += nums.get(current);
            sumthree(nums, current + 1, selected + 1, sum, target);
            sum -= nums.get(current);
            sumthree(nums, current + 1, selected, sum, target);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(2, threeSumClosest(Arrays.asList(1, 2, 3, 1, 0 ), 2));
    }
}
