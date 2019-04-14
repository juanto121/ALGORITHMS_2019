public class FenwickTree {

  public static void main(String[] args) {
    int a[] = {7,6,2,3,1,4,5};

    System.out.println(Math.sqrt(99400891));
    BinaryIndexedTree bit = new BinaryIndexedTree(a.length);
    for(int i = 1; i <= a.length; i++) {
      bit.update(i, a[i-1]);
    }

    int sumAllArr = bit.query(a.length);
    System.out.println("Sum from 1 to "+ (a.length + 1) +": " + sumAllArr);
    System.out.println("Sum from 1 to 3: " + bit.query(3));
    System.out.println("Sum from 1 to 4: " + bit.query(4));
  }

}

/**
 *
 * Useful for doing sum queries from 0 to i
 * update: O(log n)
 * query: O(log n)
 *
 * NOT good if range is updated using a range.
 * Good if single point updates
 *
 * NOT good if function to evaluate over range is not "invertible" (max and min are not, sum and subtraction are)
 *
 * Remember this:
 * Each position has a responsibility equals to the lowest bit set to 1.
 * position  table responsibility  updates       queries
 * 1          001   1 |  | |       1, 2 and 4    1
 * 2          010   2    | |       2 and 4       2
 * 3          011   1 |    |       3 and 4       3 and 2
 * 4          100   4      |       4             4
 * 5          101   1 |  |         5 and 6       5 and 4
 * 6          110   2    |         6             6 and 4
 * 7          111   1 |            7             7, 6 and 4
 *
 ****/

class BinaryIndexedTree {
  int prefix[];
  int size;

  public BinaryIndexedTree(int n) {
    size = n;
    // Store extra position so maximum query can be (1,n) instead of (0,n-1)
    prefix = new int[n+1];
  }

  public void update(int i, int delta) {
    while(i <= size) {
      prefix[i] += delta;
      i += Integer.lowestOneBit(i);
    }
  }

  public int query(int i) {
    int acum = 0;
    while(i > 0) {
      acum += prefix[i];
      i -= Integer.lowestOneBit(i);  // equivalent to i+=i&-i
    }
    return acum;
  }
}
