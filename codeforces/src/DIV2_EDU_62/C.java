package DIV2_EDU_62;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
  @SuppressWarnings("Duplicates")
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String nks[] = scan.nextLine().split(" ");

    int n = Integer.parseInt(nks[0]);
    int k = Integer.parseInt(nks[1]);
    int lens[] = new int[n];
    int bea[] = new int[n];

    for(int i = 0; i < n; i++) {
      String rec[] = scan.nextLine().split(" ");
      lens[i] = Integer.parseInt(rec[0]);
      bea[i] = Integer.parseInt(rec[1]);
    }

    long maxp = 0;
    int minLength = lens[0];

    int minBeauty = bea[0];
    int sum = lens[0];
    int selected = 1;

    PriorityQueue<Integer> qb = new PriorityQueue<>();
    PriorityQueue<Integer> ql = new PriorityQueue<>();
    ql.add(lens[0]);
    qb.add(bea[0]);

    for(int i = 1; i < n; i++) {

      int currentSum = sum - (selected >= k ? minLength : 0);
      long maxWithCurrent = Math.max(maxp, bea[i] * (currentSum + lens[i]));

      if(maxWithCurrent > maxp){
        sum += lens[i];
        if(selected >= k) {
          sum -= ql.poll();
          selected--;

        }
        selected++;
        qb.add(bea[i]);
      }

    }

    System.out.println(sum);
  }
}
