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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        DFS(result,root,0);
        return result;
    }
    void DFS(List<List<Integer>> result, TreeNode node,int level){
        if(node==null){
            return;
        }
        if(level >= result.size()){
            result.add(new ArrayList());
            result.get(level).add(node.val);
        }
        else{
            if(level%2==0){
                result.get(level).add(node.val);
            }
            else{
                result.get(level).add(0,node.val);
            }
        }
        DFS(result,node.left,level+1);
        DFS(result,node.right,level+1);
    }
}