import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/rearrange-array/
public class RearrangeArray {
  @Test
  public void test() {
    List<Integer> a = Arrays.asList(1,0);
    arrange(a);
    System.out.println(a.toString());

  }

  @Test
  public void test1() {
    List<Integer> a = Arrays.asList(1,2,1,1);
    arrange(a);
    System.out.println(a.toString());
  }


  @Test
  public void test2() {
    List<Integer> a = Arrays.asList(1,2,3,0);
    arrange(a);
    System.out.println(a.toString());
  }

  @Test
  public void test3() {
    List<Integer> a = Arrays.asList(4,0,2,1,3);
    arrange(a);
    System.out.println(a.toString());
  }

  public void arrange(List<Integer> a) {
    for(int i = 0; i < a.size(); i++) {
      int num = a.get(i);
      int encoded = encode(num, decode(a.get(num))[0]);
      a.set(i, -encoded);
    }
    for(int i = 0; i < a.size(); i++) {
      int encoded = a.get(i);
      int decoded[] = decode(encoded);
      a.set(i, decoded[1]);
    }
  }

  public int encode(int oldNum, int newNum) {
    int encoded = 1;
    while(oldNum-- > 0) {
      encoded *= 2;
    }
    while(newNum-- > 0) {
      encoded *= 3;
    }

    return encoded;
  }

  public int[] decode(int num) {
    if(num > 0) return new int[]{num, 1};
    else num*=-1;

    int pow2 = 0;
    int pow3 = 0;
    while(num != 0 && num%2 == 0){
      pow2++;
      num/=2;
    }
    while(num != 0 && num%3 == 0) {
      pow3++;
      num/=3;
    }

    int decoded[] = {pow2, pow3};
    return decoded;
  }
}
