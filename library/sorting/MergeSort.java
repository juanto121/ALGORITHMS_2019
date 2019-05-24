import org.junit.Assert;
import org.junit.Test;

public class MergeSort {

  public void sort(int a[], int len) {
    if(len <= 1) return;
    int mid = len / 2;
    int left[] = new int[mid];
    int right[] = new int[len-mid];
    for(int i = 0; i < mid; i++) {
      left[i] = a[i];
    }
    for(int i = mid; i < len; i++) {
      right[i-mid] = a[i];
    }
    sort(left, mid);
    sort(right, len-mid);
    merge(a, left, right, mid, len-mid);
  }

  private void merge(int[] a, int[] left, int[] right, int lenLeft, int lenRight) {
    int leftptr = 0;
    int rightptr = 0;
    int aptr = 0;
    while(leftptr < lenLeft && rightptr < lenRight) {
      if(left[leftptr] < right[rightptr]) {
        a[aptr] = left[leftptr];
        leftptr++;
      } else {
        a[aptr] = right[rightptr];
        rightptr++;
      }
      aptr++;
    }

    while(leftptr < lenLeft) a[aptr++] = left[leftptr++];
    while(rightptr < lenRight) a[aptr++] = right[rightptr++];
  }

  @Test
  public void correctlySorts() {
    int a[] = {3,3,4,6,1,3,1,0,9,11,6565,323,12,3,1};
    int aSorted[] = {0,1,1,1,3,3,3,3,4,6,9,11,12,323,6565};
    MergeSort sorter = new MergeSort();
    sorter.sort(a, a.length);
    Assert.assertArrayEquals(aSorted, a);
  }
}

