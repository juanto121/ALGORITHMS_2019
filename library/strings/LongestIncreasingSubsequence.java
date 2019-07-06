import java.util.Arrays;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    int a[] = {2,1,3}; // LIS : -1, 2, 3, 7, 9, 10

    LIS2 lis2 = new LIS2(a);
    System.out.println(lis2.lengthOfSubsequence);

    LIS lislog = new LIS(a);
    System.out.println(lislog.lengthOfSubsequence);
  }
}


// O(n^2)
class LIS2 {

  public int lengthOfSubsequence;

  public LIS2(int a[]) {
    int n = a.length;
    int seq[] = new int[n];
    Arrays.fill(seq,1);
    int longestSequence = 0;
    for(int i = 1; i < n; i++) {
      for(int j = 0; j < i; j++) {
        if(a[i] > a[j] && seq[i] < seq[j] + 1){
          seq[i] = seq[j] + 1;
          longestSequence = seq[i] > longestSequence ? seq[i] : longestSequence;
        }
      }
    }
    lengthOfSubsequence = longestSequence;
  }
}

// O(log n)
class LIS {

  public int lengthOfSubsequence;
  private int t[], r[];

  public LIS(int a[]) {
    r = new int[a.length];
    Arrays.fill(r, -1);
  }

}