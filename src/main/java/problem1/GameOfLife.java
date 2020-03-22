package problem1;

public class GameOfLife {

  public static void main(String[] args) {
    int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    GameOfLife gl = new GameOfLife();
    gl.gameOfLife(board);
  }

  /**
   * 一般遇到这种题型，需要缓存中间值的，用一些特定的值在现有的基础上进行缓存
   * 1、先全部遍历，用特定值去替换当前值，但是判断的时候，需要同时判断中间值和当前值，直到全部值都被我们用特定值替换
   * 2、再次全部遍历，把特定值替换成题目要求的值
   * @param board
   */
  public void gameOfLife(int[][] board) {
    int[] x = {0, 0, 1, 1, 1, -1, -1, -1};
    int[] y = {1, -1, 1, -1, 0, 1, -1, 0};

    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        int curX = 0;
        int curY = 0;
        int live = 0;

        for (int k = 0; k < 8; ++k) {
          curX = i + x[k];
          curY = j + y[k];
          if (curX < 0 || curX >= board.length || curY < 0 || curY >= board[0].length) {
            continue;
          }

          if (board[curX][curY] == 1 || board[curX][curY] == 2) {
            live++ ;
          }
        }

        if (board[i][j] == 0) {
          if (live == 3) {
            board[i][j] = -1;
          }
        } else {
          if (live < 2 || live >3) {
            board[i][j] = 2;
          }
        }
      }
    }

    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        if (board[i][j] == 2) {
          board[i][j] = 0;
        }
        if (board[i][j] == -1) {
          board[i][j] = 1;
        }
      }
    }
  }

}
