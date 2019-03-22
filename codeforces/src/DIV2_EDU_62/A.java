package DIV2_EDU_62;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    HashSet<Integer> s = new HashSet<>();

    int n = Integer.parseInt(scan.nextLine());
    int book[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int days = 0;

    for(int i = 0; i < n; i++) {
      s.add(book[i]-1);
      s.remove(i);
      if(s.isEmpty()) days++;
    }

    System.out.println(days);
  }
}
