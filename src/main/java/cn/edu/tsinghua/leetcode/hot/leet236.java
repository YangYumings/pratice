package cn.edu.tsinghua.leetcode.hot;

public class leet236 {
    /**
     * 二叉树的最近公共祖先
     * <p>
     * 思路1： DFS
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * DFS 的思想
     *
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 返回空 说明目标节点不在当前递归的路径上
        // 返回非空 代表返回的即为 目标节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 都为空，没找到 p q
        if (left == null && right == null) {
            return null;
        }
        // 左为空，右为目标
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 左后都不空，说明找到了  p q，那root就是最近公共祖先
        return root;
    }

    /**
     * 栈的思想
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){

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
