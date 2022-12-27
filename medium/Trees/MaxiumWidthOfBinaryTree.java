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

    int answer =0;
    Map<Integer,Integer> widthMap;
    public int widthOfBinaryTree(TreeNode root) {
        widthMap = new HashMap();
        DFS(root,0,0);
        return answer;
    }
    void DFS(TreeNode node, int level, int leftWidth){
        if(node==null){
            return;
        }

        if(!widthMap.containsKey(level)){
            widthMap.put(level,leftWidth);
        }
        int left = widthMap.get(level);
        answer = Math.max(answer,leftWidth - left + 1);
        DFS(node.left,level+1,2*leftWidth);
        DFS(node.right,level+1,2*leftWidth+1);
    }
}