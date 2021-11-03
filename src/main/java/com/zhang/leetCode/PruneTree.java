package main.java.com.zhang.leetCode;

/**
 * @author ZhangZePing
 * @description leetCode 814. 二叉树剪枝
 * @date 2021/11/2 17:50
 *
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * <p>
 * 示例 2：
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * <p>
 * 示例 3：
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 200] 内
 * Node.val 为 0 或 1
 */
public class PruneTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        System.out.println(pruneTree(root));
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (delete(root)) {
            return null;
        }
        return root;
    }

    public static boolean delete(TreeNode root) {
        if (root.left != null) {
            if (delete(root.left)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (delete(root.right)) {
                root.right = null;
            }
        }
        return root.val == 0 && root.left == null && root.right == null;
    }
}
