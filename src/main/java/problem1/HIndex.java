package problem1;

import java.util.Arrays;

public class HIndex {

  public static void main(String[] args) {
    HIndex hIndex = new HIndex();
    int[] citations = {3,0,6,1,5,2,4,4};
    int res = hIndex.hIndex(citations);
    System.out.println(res);
  }

  public int hIndex(int[] citations) {
    if (citations.length == 0) {
      return 0;
    }
    Arrays.sort(citations);
    int len = citations.length;
    int hIndex = Integer.MIN_VALUE;

    for (int i = 0; i < citations.length; ++i) {
      int remainLen = len - i;
      int curHIndex = (citations[i] <= remainLen)? citations[i] : remainLen;
      hIndex = Math.max(hIndex,curHIndex);
    }

    return hIndex;
  }

}
