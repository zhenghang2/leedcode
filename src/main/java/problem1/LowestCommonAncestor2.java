package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 针对普通二叉树，查找最近公共祖先
 * 思路：1、深度搜索，分别记录下到节点的路径
 * 2、遍历两条路径，最后相同的节点，比如一条路径为1--->2---->3，另外一条：1---->2----->4,那么最近的3,4最近的公共祖先是2
 */
public class LowestCommonAncestor2 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    List<TreeNode> res1 = new ArrayList<TreeNode>();
    List<TreeNode> res2 = new ArrayList<TreeNode>();

    searchHelper(root,p,res1);
    searchHelper(root,q,res2);

    int len = Math.min(res1.size(),res2.size());
    TreeNode cur = null;
    for (int i = 0; i < len; i++) {
      if (res1.get(i).val == res2.get(i).val) {
        cur = res1.get(i);
      } else {
        break;
      }
    }
    return cur;
  }
  protected boolean searchHelper(TreeNode cur, TreeNode target, List<TreeNode> list) {
    if (cur == null) {
      return false;
    }
    list.add(cur);
    boolean found = false;

    if (cur.val == target.val) {
      return true;
    }
    if (cur.left != null) {
      found = searchHelper(cur.left, target, list);
    }
    if (!found && cur.right != null) {
      found = searchHelper(cur.right, target, list);
    }
    if (!found) {
      list.remove(list.size()-1);
    }
    return found;
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
