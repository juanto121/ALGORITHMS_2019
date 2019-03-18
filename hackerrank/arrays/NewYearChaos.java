import java.util.Scanner;

public class NewYearChaos {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = Integer.parseInt(scan.nextLine());
    for(int cases = 0; cases < t; cases++){
      int n = Integer.parseInt(scan.nextLine());
      String []q = scan.nextLine().split(" ");
      int line[] = new int[n];

      boolean possible = true;
      for(int i = 0; i < n; i++){
        line[i] = Integer.parseInt(q[i]);
        if(line[i] - (i+1) > 2) possible = false;
      }

      if(true) {
        System.out.println(countInversions(line));
      } else {
        System.out.println("Too chaotic");
      }
    }
  }

  static int countInversions(int a[]) {
    BIT bt = new BIT(a.length);
    int inversions = 0;
    for(int i = 0; i < a.length; i++) {
      int untilVal = bt.rangeSum(a[i]-1);
      int allSum = bt.rangeSum(a.length);
      inversions += allSum - untilVal;
      bt.update(a[i], +1);
    }
    return inversions;
  }
}

class BIT {

  int prefixSum[];
  int size;

  public BIT(int n) {
    prefixSum = new int[n+1];
    size = n+1;
  }

  public void update(int i, int delta) {
    while(i < size) {
      prefixSum[i] += delta;
      i += Integer.lowestOneBit(i);
    }
  }

  // calculates prefix sum up until i
  @SuppressWarnings("Duplicates")
  public int rangeSum(int i) {
    int sum = 0;
    while(i > 0) {
      sum += prefixSum[i];
      i -= Integer.lowestOneBit(i);
    }
    return sum;
  }
}