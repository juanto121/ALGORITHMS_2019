import java.util.Arrays;

public class CoinChangeProblem {

  static int dp[];

  public static void main(String[] args) {
    int n = 4;
    dp = new int[n];
    Arrays.fill(dp,-1);
    int coins[] = {1, 2 ,3};
    System.out.println("TOTAL: " + numWaysToPermute(n, coins));
  }

  public static int numWaysToPermute(int n, int[] coins) {
    if(n == 0){
      System.out.println("REACHED A LEAF");
      return 1;
    }
    if(n < 0) {
      return 0;
    }

    if(dp[n] != -1){
      System.out.println("Already know the answer for n: " + n + " -> " + dp[n]);
      return dp[n];
    } else {
      int total = 0;
      for(int i = 0; i < coins.length; i++){
        System.out.println("Num of ways to permute " + n + " with " + coins[i]);
        int numWays = numWaysToPermute(n-coins[i], coins);
        total += numWays;
      }
      dp[n] = total;
      return total;
    }
  }

}
