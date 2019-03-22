import java.util.ArrayList;
import java.util.Arrays;

public class SieveErathosthenes {
  public static void main(String[] args) {
    Sieve s = new Sieve(50);
    System.out.println(s.isPrime[2]);
  }
}

class Sieve {

  boolean isPrime[];
  ArrayList<Integer> primes;

  public Sieve(int largestN) {
    int n = largestN;
    primes = new ArrayList<>();
    isPrime = new boolean[n];

    Arrays.fill(isPrime, true);
    for(int i = 2; i < n; i++){
      if(isPrime[i]) primes.add(i);
      for(int j = 2; i * j < n; ++j) {
        isPrime[i*j] = false;
      }
    }
  }

}
