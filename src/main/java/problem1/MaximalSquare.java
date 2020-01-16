package problem1;

public class MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rows][cols];
    int maxLength = 0;

    for (int i=0; i < rows; ++i) {
      if (matrix[i][0] == '1') {
        dp[i][0] = 1;
      } else {
        dp[i][0] = 0;
      }
    }
    for (int i=0; i < cols; ++i) {
      if (matrix[0][i] == '1') {
        dp[0][i] = 1;
      } else {
        dp[0][i] = 0;
      }
    }

    for (int i=1; i < rows; ++i) {
      for (int j=1; j < cols; ++j) {
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
          maxLength = Math.max(maxLength,dp[i][j]);
        }
      }
    }
    return maxLength*maxLength;
  }
}
