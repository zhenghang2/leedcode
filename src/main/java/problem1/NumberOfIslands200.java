package problem1;

public class NumberOfIslands200 {

  public static void main(String[] args) {
    NumberOfIslands200 solve = new NumberOfIslands200();
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    int res = solve.numIslands(grid);
    System.out.println(res);
  }
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int row = grid.length;
    int column = grid[0].length;

    int count = 0;
    for (int i = 0; i<row; i++) {
      for (int j = 0; j<column; j++) {
        if (grid[i][j] == '1') {
          count++;
          mergeLand(grid,i,j);
        }
      }
    }
    return count;
  }

  private void mergeLand(char[][] grid, int i, int j) {
    int row = grid.length;
    int colume = grid[0].length;

    if (i<0 || i>=row || j<0 || j>=colume || grid[i][j]!='1') {
      return;
    }

    grid[i][j] = 'X';

    mergeLand(grid,i-1,j);
    mergeLand(grid,i+1,j);
    mergeLand(grid,i,j-1);
    mergeLand(grid,i,j+1);
  }
}
