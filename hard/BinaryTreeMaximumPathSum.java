/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Integer answer = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        compute(root);
        return answer;
    }
    int compute(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = Math.max(compute(node.left), 0);
        int rightMax = Math.max(compute(node.right),0);

        answer = Math.max(answer, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax,rightMax);
    }
}