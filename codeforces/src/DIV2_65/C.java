package DIV2_65;

import java.util.Arrays;
import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    int vertices[] = Arrays.stream(scan.next().split(" ")).mapToInt(Integer::parseInt).toArray();

  }
}
