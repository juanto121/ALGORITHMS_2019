import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiffKII {
  public int diffPossible(final List<Integer> A, int B) {

    int len = A.size();

    Map<Integer, Long> set  = A.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for(int i: A){
      if(B == 0){
        if(set.get(i) > 1) {
          return 1;
        }
      }else if(set.containsKey(i-B)) return 1;
    }

    return 0;
  }

  @Test
  public void test() {
    List<Integer> a = Arrays.asList(5,3,2,20);
    System.out.println(diffPossible(a,1));
  }

  @Test
  public void test2() {
    List<Integer> a = Arrays.asList(5,3,2,20);
    System.out.println(diffPossible(a,15));
    System.out.println(diffPossible(a,17));
    System.out.println(diffPossible(a,8));
  }

  @Test
  public void test3() {
    List<Integer> a = Arrays.asList(5,3,2,20,3);
    System.out.println(diffPossible(a,0));
  }
}
