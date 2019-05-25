import org.junit.Assert;
import org.junit.Test;

public class UniquePaths {
  public int uniquePaths(int A, int B) {
    int grid[][] = new int[A][B];
    grid[0][0] = 1;

    for(int i = 1; i < A; i++){
      grid[i][0] = 1;
    }
    for(int i = 1; i < B; i++){
      grid[0][i] = 1;
    }

    for(int i = 1; i < A; i++) {
      for(int j = 1; j < B; j++) {
        grid[i][j] = grid[i-1][j] + grid[i][j-1];
      }
    }

    return grid[A-1][B-1];
  }

  @Test
  public void uniqueA() {
    Assert.assertEquals(319770,uniquePaths(15,9));
  }

  @Test
  public void uniqueB() {
    Assert.assertEquals(6,uniquePaths(3,3));
  }
}
