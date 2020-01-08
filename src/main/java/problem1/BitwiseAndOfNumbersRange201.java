package problem1;

public class BitwiseAndOfNumbersRange201 {
  public static void main(String[] args) {
    BitwiseAndOfNumbersRange201 b = new BitwiseAndOfNumbersRange201();
    System.out.println(b.rangeBitwiseAnd(0,1));
  }
  public int rangeBitwiseAnd(int m, int n) {
    if (m>n) {
      return 0;
    }
    int res = m;

    for (int i = m+1; i<=n; i++) {
      res = (res & i);
    }
    return res;
  }

}
