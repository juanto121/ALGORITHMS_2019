import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public int threeSumClosest(List<Integer> A, int B) {
        return sumthreev3(A, B);
    }

    //O(N^2 * log(N) + N*Log(N))
    public int sumthreev3(List<Integer> A, int B) {
        Collections.sort(A);
        int len = A.size();
        int minSumSoFar = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int partialSum = A.get(i) + A.get(j);
                int sum = partialSum + findClosest(A, B, partialSum, i, j);
                if(minDiff > Math.abs(sum-B)) {
                    minSumSoFar = sum;
                    minDiff = Math.abs(sum-B);
                }
            }
        }
        return minSumSoFar;
    }

    public int findClosest(List<Integer> A, int target, int partialSum, int first, int second) {
        int diff = target - partialSum;
        //System.out.print("sum: " + partialSum + " ");
        int closestIndexToDiff = binarySearch(A, diff, first, second);
        //System.out.print("diff: " + diff + " found: " + A.get(closestIndexToDiff) + "\n");
        return A.get(closestIndexToDiff);
    }

    public int binarySearch(List<Integer> A, int n, int first, int second) {

        int left = first+1;
        int right = second-1;

        while(left <= right) {
            int mid =  (left + right) / 2;
            int midVal = A.get(mid);
            if(midVal == n) return mid;
            if(n < A.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right == first && left == second) {
            if(right + 1 < n) right++;
            if(left - 1 >= 0) left--;
        }
        else if(right == first) {
            right = first + 1;
        }
        else if(left == second) {
            left = second - 1;
        }

        return Math.abs(A.get(left) - n) < Math.abs(A.get(right) - n) ? left : right;
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
        Assert.assertEquals(2, threeSumClosest(Arrays.asList(0,1,1,2,3), 2));
        Assert.assertEquals(-1, threeSumClosest(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3), -1));
    }
}
