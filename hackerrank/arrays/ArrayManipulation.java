import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String nm[] = scan.nextLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    int q[][] = new int[m][3];

    for(int i = 0; i < m; i++){
      String qr[] = scan.nextLine().split(" ");
      q[i][0] = Integer.parseInt(qr[0]);
      q[i][1] = Integer.parseInt(qr[1]);
      q[i][2] = Integer.parseInt(qr[2]);
    }

    System.out.println(arrayManipulation(n, q));
  }

  private static long arrayManipulation(int n, int[][] q) {
    long max = 0;
    long []a = new long[n+2];
    for(int i = 0; i < q.length; i++){
      a[q[i][0]] += q[i][2];
      a[q[i][1]+1] -= q[i][2];
    }
    for(int i= 1; i <= n; i++){
      a[i] += a[i-1];
      if(a[i] > max) max = a[i];
    }
    return max;
  }

}

