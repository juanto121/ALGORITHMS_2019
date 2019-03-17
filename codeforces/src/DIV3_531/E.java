package DIV3_531;

import java.util.HashMap;
import java.util.Scanner;

public class E {
  public static void main(String[] args) {
    int MOD = 998244353;
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String _arr [] = scan.nextLine().split(" ");
    int arr[] = new int[n];

    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(_arr[i]);
      map.put(arr[i], i);
    }

    int maxForGroup = -1;
    long ans = 1;

    for(int i= 0; i < n-1; i++) {
      int maxIndex = map.get(arr[i]);
      maxForGroup = maxIndex > maxForGroup ? maxIndex : maxForGroup;
      if(maxForGroup == i) {
        ans = (2L*ans)%MOD;
      }
    }

    System.out.println( ans );

  }
}
