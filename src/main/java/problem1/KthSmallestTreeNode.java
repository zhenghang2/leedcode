package problem1;

import java.util.ArrayList;
import java.util.List;

//二叉搜索树,采用中序便利
public class KthSmallestTreeNode {
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<Integer>();
    searchHelper(root,list);
    return list.get(k-1);

  }
  public void searchHelper(TreeNode node, List<Integer> list) {
    if(node !=null){
      searchHelper(node.left,list);
      list.add(node.val);
      searchHelper(node.right,list);
    }
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
