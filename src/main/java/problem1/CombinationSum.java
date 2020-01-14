package problem1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  public static void main(String[] args) {
    int k =3;
    int n = 15;
    CombinationSum cs = new CombinationSum();
    List<List<Integer>> res = cs.combinationSum3(k,n);
    System.out.println(res);
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<Integer> cur = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int sum = 0;
    searchHelper(1,sum,cur,k,n,res);
    return res;
  }
  public void searchHelper(int i, int sum, List<Integer> cur,int k, int n, List<List<Integer>> res) {
    if (sum>n) {
      return;
    }
    if (sum ==n && cur.size()==k) {
      res.add(new ArrayList<Integer>(cur));
      return;
    }
    for (int var=i;var<10;var++) {
      sum+=var;
      cur.add(var);
      searchHelper(var+1,sum,cur,k,n,res);
      sum-=var;
      cur.remove(cur.size()-1);
    }
  }
}
