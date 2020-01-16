package problem1;

public class ComputeArea {
  public static void main(String[] args) {
    int A = -3;
    int B = 0;
    int C = 3;
    int D = 4;
    int E = 0;
    int F = -1;
    int G = 9;
    int H = 2;
    ComputeArea ca = new ComputeArea();
    System.out.println(ca.computeArea(A,B,C,D,E,F,G,H));
  }

  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int firstArea = (C-A) * (D-B);
    int secondArea = (G-E) * (H-F);
    int[] var1 = processArea(A,C,E,G);
    int[] var2 = processArea(B,D,F,H);

    if (var1.length ==0 || var2.length == 0) {
      return firstArea+secondArea;
    }
    int row = var1[1] - var1[0];
    int colume = var2[1] - var2[0];
    return firstArea+secondArea-row * colume;
  }

  public int[] processArea(int a1, int a2, int b1, int b2) {
    int[] var = new int[2];
    int first = Math.max(a1,b1);
    int second = Math.min(a2,b2);

    if (first>= second) {
      return new int[0];
    }
    var[0] = first;
    var[1] = second;
    return var;
  }
}
