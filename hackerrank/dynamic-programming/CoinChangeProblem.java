import java.util.Arrays;

public class CoinChangeProblem {

  static int dp[];
  static int repeated = 0;

  public static void main(String[] args) {
    int n = 85;
    dp = new int[n+1];
    Arrays.fill(dp,-1);
    int coins[] = {50,10,17,21,8,3,12,41,9,13,43,37,49,19,23,28,45,46,29,16,34,25,2,22,1};
    System.out.println(numWaysToPermute(n, coins) - repeated);
  }

  public static int numWaysToPermute(int n, int[] coins) {
    if(n == 0){
      //System.out.println("REACHED A LEAF");
      return 1;
    }
    if(n < 0) {
      return 0;
    }

    if(dp[n] != -1){
      //System.out.println("Already know the answer for n: " + n + " -> " + dp[n]);
      repeated++;
      return dp[n];
    } else {
      int total = 0;
      for(int i = 0; i < coins.length; i++){
        //System.out.println("Num of ways to permute " + n + " with " + coins[i]);
        int numWays = numWaysToPermute(n-coins[i], coins);
        total += numWays;
      }
      dp[n] = total;
      return total;
    }
  }

}
