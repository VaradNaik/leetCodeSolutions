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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> currentPath = new ArrayList();
        compute(result,root,targetSum,0,currentPath);
        return result;
    }
    void compute(List<List<Integer>> result, TreeNode root, int targetSum, int currentSum,List<Integer> currentPath){
        if(root==null){
            return;
        }
        currentPath.add(root.val);
        currentSum += root.val;
        if(currentSum==targetSum && root.left == null && root.right == null){
            result.add(new ArrayList(currentPath));
        }
        else{
            compute(result,root.left,targetSum,currentSum,currentPath);
            compute(result,root.right,targetSum,currentSum,currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
        currentSum -= root.val;

    }
}