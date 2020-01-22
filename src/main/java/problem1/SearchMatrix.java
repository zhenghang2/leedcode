package problem1;

public class SearchMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
    SearchMatrix sm = new SearchMatrix();
    System.out.println(sm.searchMatrix(matrix,99));
  }
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if (row == 0) {
      return false;
    }
    int colume = matrix[0].length;

    int i = 0;
    int j = colume-1;

    while(i < row && j >=0 ) {
      if (matrix[i][j] <target) {
        i++;
      } else if (matrix[i][j] >target) {
        j--;
      } else {
        return true;
      }
    }
    return false;
  }
}
