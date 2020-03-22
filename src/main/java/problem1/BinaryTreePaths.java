package problem1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<String>();
        List<TreeNode> curPath = new ArrayList<TreeNode>();
        searchHelper(root,path,curPath);
        return path;
    }

    public void searchHelper(TreeNode node, List<String> path, List<TreeNode> curPath) {
        if (node == null) {
            return;
        }
        curPath.add(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curPath.size(); ++i) {
                sb.append(curPath.get(i).val);
                if (i != curPath.size()-1) {
                    sb.append("->");
                }
            }
            path.add(sb.toString());
        }
        searchHelper(node.left, path, curPath);
        searchHelper(node.right, path, curPath);
        curPath.remove(curPath.size()-1);
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
