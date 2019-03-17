package DIV3_531;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String pDesc[] = scan.nextLine().split( " ");

    int n = Integer.parseInt(pDesc[0]);
    int x = Integer.parseInt(pDesc[1]);
    int y = Integer.parseInt(pDesc[2]);

    String _doors[] = scan.nextLine().split(" ");

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(String d: _doors) {
      pq.add(Integer.parseInt(d));
    }

    boolean nextMovePossible = true;
    int numDoors = 0;

    if(x > y){
      numDoors = n;
    } else {
      while (!pq.isEmpty() && nextMovePossible) {
        int top = pq.poll();
        if(top > x) {
          nextMovePossible = false;
        }else{
          numDoors++;
          if(!pq.isEmpty()){
            pq.add(pq.poll()+y);
          }
        }
      }
    }

    System.out.println(numDoors);
  }

}
