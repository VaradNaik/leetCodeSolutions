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
    private int answer=0;
    private Map<Long,Integer> countMap;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        countMap = new HashMap();
        target = targetSum;
        preOrder(root,0);
        return answer;
    }

    void preOrder(TreeNode node, long currentSum){
        if(node==null){
            return;
        }
        currentSum += node.val;
        if(currentSum == target){
            answer++;
        }


        answer += countMap.getOrDefault(currentSum - target,0);

        //the line just below this comment accounts for negative values too
        countMap.put(currentSum,countMap.getOrDefault(currentSum,0) + 1);

        preOrder(node.left,currentSum);
        preOrder(node.right,currentSum);
        countMap.put(currentSum,countMap.get(currentSum) - 1);

    }
}