public class AllNodesDistanceKinBinaryTree {


}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap();
        DFS(root, null);
        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);

        /*
          maintaining seen hashset is important otherwise parent and child will keep adding each other to queue
        */
        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                List<Integer> answer = new ArrayList();
                for (TreeNode n : queue) {
                    answer.add(n.val);
                }
                return answer;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                seen.add(node);
                if (node.left != null && !seen.contains(node.left)) {
                    queue.offer(node.left);
                    seen.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    queue.offer(node.right);
                    seen.add(node.right);
                }
                TreeNode parentNode = parentMap.get(node);
                if (parentNode != null && !seen.contains(parentNode)) {
                    queue.offer(parentNode);
                    seen.add(parentNode);
                }
            }
            distance++;
        }
        return new ArrayList();
    }


    void DFS(TreeNode node, TreeNode parent) {
        if (node != null) {
            parentMap.put(node, parent);
            DFS(node.left, node);
            DFS(node.right, node);
        }
    }
}
