/**
 * Learning: Recursion
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public boolean isMirror(TreeNode lst, TreeNode rst) {
        if (lst == null && rst == null) {
            return true;
        } else if (lst == null || rst == null) {
            return false;
        } else if (lst.val != rst.val) {
            return false;
        } else {
            isMirror(lst.left, rst.right) && isMirror(lst.right, rst.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        } else {
            return isMirror(root.left, root.right);
        }
    }

}
