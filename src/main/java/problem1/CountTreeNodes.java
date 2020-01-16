package problem1;

import java.util.ArrayList;
import java.util.List;

public class CountTreeNodes {

  public int countNodes(TreeNode root) {
    List<TreeNode> nodeList = new ArrayList<TreeNode>();
    processHelper(nodeList,root);
    return nodeList.size();
  }

  public void processHelper(List<TreeNode> list, TreeNode cur) {
    if (cur == null) {
      return;
    }
    list.add(cur);
    processHelper(list,cur.left);
    processHelper(list,cur.right);
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
