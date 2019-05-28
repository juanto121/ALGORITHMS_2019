import org.junit.Assert;
import org.junit.Test;

public class PalindromeInteger {
  @Test
  public void test(){
    Assert.assertEquals(1, isPalindrome(55));
    Assert.assertEquals(1, isPalindrome( 5));
    Assert.assertEquals(1, isPalindrome( 0));
    Assert.assertEquals(1, isPalindrome( 121));
    Assert.assertEquals(1, isPalindrome( 21212));
    Assert.assertEquals(1, isPalindrome( 424424));
    Assert.assertEquals(0, isPalindrome( -424424));
    Assert.assertEquals(0, isPalindrome( 424414));
    Assert.assertEquals(0, isPalindrome( 424414));
  }

  public int isPalindrome(int a) {
    if(a < 0) return 0;

    int digits = log(a);

    while(a!=0 && a%10 == a/digits){
      a -= (a/digits)*digits;
      a /= 10;
      digits/=100;
    }

    if(a == 0) return 1;
    else return 0;
  }

  private int log(int a) {
    int digits = 1;
    while(a/10!=0){
      digits*=10;
      a/=10;
    }
    return digits;
  }
}
