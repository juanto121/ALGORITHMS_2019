import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
  public int nchoc(int k, ArrayList<Integer> B) {
    Comparator<Integer> reverseComp = new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return b-a;
      }
    };
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(reverseComp);
    long count = 0;
    int mod = (int)1000000000+7;
    for(int ai : B) q.add(ai);

    while(k-- > 0) {
      int eaten = q.poll();
      //System.out.println("-"+eaten);
      count += eaten ;
      q.add(eaten/2);
    }

    return (int)(count%mod);
  }
  @Test
  public void simple() {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(2147483647);
    A.add(2000000014);
    A.add(2147483647);
    Assert.assertEquals(284628164,nchoc(10, A));
  }

  @Test
  public void simple2() {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(5);
    A.add(6);
    Assert.assertEquals(14,nchoc(3, A));
  }
}
