import org.junit.Test;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int dp [][] = new int[len][len];

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if(i == j) dp[i][j] = 0;
                else {
                    dp[i][j] = nums[i] < nums[j] ? dp[i+1][j] + 1 : dp[i+1][j];
                    //System.out.print(dp[i][j] + " ");
                }
            }
            //System.out.println("");
        }

        int max = 0;
        for(int i = 0; i < len; i++) {
            max = dp[0][i] > max ? dp[0][i] : max;
        }

        return max + 1;
    }

    @Test
    public void test() {
        int a[] = {10,9,2,5,3,7,101,18};
        lengthOfLIS(a);
    }

}
