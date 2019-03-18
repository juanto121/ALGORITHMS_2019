import java.util.Scanner;

public class MinimumSwapsCyclic {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String _arr[] = scan.nextLine().split(" ");

    int a[] = new int[n];
    for(int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(_arr[i]);
    }

    int swaps = 0;
    for(int j = 0; j < n; j++) {
      int i = j;
      while(a[i] != i+1) {
        int temp = a[a[i] - 1];
        a[a[i] - 1] = a[i];
        a[i] = temp;
        swaps++;
      }
    }

    System.out.println(swaps);
  }
}
