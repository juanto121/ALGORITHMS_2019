package DIV2_556;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int r = scan.nextInt();
    int minBuy = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++){
      int price = scan.nextInt();
      minBuy =  price < minBuy ? price : minBuy;
    }
    int maxSell = Integer.MIN_VALUE;
    for(int i = 0; i < m; i++) {
      int price = scan.nextInt();
      maxSell = price > maxSell ? price:maxSell;
    }

    if( (r/minBuy)*maxSell+ r%minBuy > r ) {
      System.out.println( ((r/minBuy)*maxSell) + r%minBuy);
    }else{
      System.out.println(r);
    }
  }
}
