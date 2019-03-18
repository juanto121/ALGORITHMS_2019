/*
* Given a query with left index and right index, returns the minimum in the range
* using sparse table.
*
* Good when input is not updated, i.e. static
* query: O(1)
*
* */

public class SparseTable {

  public static void main(String[] args) {
    int arr[] = {14,2,5,3,2,4,6,7,23,-2,54,2};
    int[][] rmq = process(arr);

    System.out.println(arr[query(rmq, arr, 0, 11)]);
  }

  // returns the minimum between low and high inclusive using rmq[][] as representation for original array a[].
  static int query(int rmq[][], int a[], int low, int high) {
    int k = log2(high-low); //length of the range
    int x = rmq[k][low];
    int y = rmq[k][high - (1<<k) + 1];
    return a[x] <= a[y] ? x : y;
  }

/*
 Compute a 0 based matrix where each row k represents the min of 2^k elements
 starting from the ith element.

 eg. row 1 column 1 represents the min of the 2^1 elements starting from index 1
 */
  static int[][] process(int a[]) {
    int n = a.length;
    int rmq[][] = new int[log2(n) + 1][n];
    // fill all queries of range length equal to one element
    for(int i = 0; i < n; i++) rmq[0][i] = i;

    for(int k = 1; (1 << k) < n; ++k) {
      for(int i = 0; i + (1 << k) <= n; i++) {
        int x = rmq[k-1][i];
        int y = rmq[k-1][i+(1<<k-1)];
        rmq[k][i] = a[x] <= a[y] ? x:y;
      }
    }

    return rmq;
  }

  static int log2(int n) {
    if(n<=0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
  }
}

