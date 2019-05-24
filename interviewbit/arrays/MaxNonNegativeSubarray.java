import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MaxNonNegativeSubarray {
  public ArrayList<Integer> maxset(ArrayList<Integer> A) {
    long totalMax = 0;
    long maxSoFar = 0;
    int lastIndexOfTotalMax = 0;
    int len = A.size();
    int lenOfMaxTotal = 0;
    int lenOfMaxSoFar = 0;

    for(int i  = 0; i < len; i++) {
      int current = A.get(i);
      if(maxSoFar + current > maxSoFar) {
        maxSoFar += current;
        lenOfMaxSoFar++;
      } else {
        if(maxSoFar + current < maxSoFar) {
          maxSoFar = 0;
          lenOfMaxSoFar = 0;
        } else {
          maxSoFar += current;
          lenOfMaxSoFar++;
        }
      }
      if(totalMax < maxSoFar || totalMax == maxSoFar && lenOfMaxTotal < lenOfMaxSoFar) {
        lenOfMaxTotal = lenOfMaxSoFar;
        lastIndexOfTotalMax = i;
        totalMax = maxSoFar;
      }
    }

    ArrayList<Integer> maxSublist = new ArrayList<>();
    for(int i = lastIndexOfTotalMax - lenOfMaxTotal + 1; i <= lastIndexOfTotalMax; i++){
      maxSublist.add(A.get(i));
    }

    return maxSublist;
  }

  @Test
  public void testMax() {
    int a[] = {1,2,5,-7,2,5};
    ArrayList<Integer> ar = atol(a);
    System.out.println(maxset(ar).toString());
  }

  @Test
  public void testWithAllArr() {
    int a[] = {1,2,5,-4,2,3};
    System.out.println(maxset(atol(a)));
  }

  @Test
  public void testWithAllArrSplit() {
    int a[] = {1,2,5,-9,2,3};
    System.out.println(maxset(atol(a)));
  }

  @Test
  public void testWithAllArrSecondHalf() {
    int a[] = {2,3,-9,1,2,5};
    System.out.println(maxset(atol(a)));
  }

  @Test
  public void testWithAllArrThird() {
    int a[] = {2,3,-9,1,2,5,-10,50};
    System.out.println(maxset(atol(a)));
  }

  @Test
  public void testLenSecond() {
    int a[] = {2,3,-9,1,2,5,-10,1,1,1,1,1,1,1,1};
    System.out.println(maxset(atol(a)));
  }

  private ArrayList<Integer> atol(int[] a) {
    return (ArrayList<Integer>) Arrays.stream(a).boxed().collect(Collectors.toList());
  }
}
