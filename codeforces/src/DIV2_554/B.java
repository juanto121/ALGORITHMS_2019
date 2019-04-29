package DIV2_554;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //System.out.println(solve(scan.nextInt()));
    for(int i = 1; i <= 1_000_000 ; i++) {
      System.out.println(i + ":");
      System.out.println(solve(i));
      System.out.println("-----");
    }

  }

  private static String solve(int nextInt) {
    int x = nextInt;
    int n = selectN(x);
    StringBuilder stb = new StringBuilder();
    int it = 0;
    while(Integer.toBinaryString(x).length() != Integer.bitCount(x)){
      it++;
      int N = Integer.bitCount(n);
      stb.append(N).append(" ");
      x = x^n;
      if(Integer.toBinaryString(x).length() == Integer.bitCount(x)) break;
      x++;
      it++;
      n = selectN(x);
    }
    assert (it > 40);
    return it + "\n" + stb.toString();
  }

  private static int selectN(int x) {
    int index = 0;
    int highestZero = 0;
    while(x > 0) {
      if(x%2 == 0) highestZero = index;
      x /= 2;
      index++;
    }
    assert highestZero != 0;
    return (1 << (highestZero+1))-1;
  }
}
