package problem1;

//二叉搜索树
public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      TreeNode tem = p;
      p = q;
      q = tem;
    }
    return searchHelper(root,p,q);
  }
  public TreeNode searchHelper(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return null;
    }
    if (node.val == p.val || node.val == q.val) {
      return node;
    }
    if (node.val > p.val && node.val < q.val) {
      return node;
    }
    if (node.val < p.val) {
      return searchHelper(node.right,p,q);
    }
    if (node.val >q.val) {
      return searchHelper(node.left,p,q);
    }
    return null;
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
