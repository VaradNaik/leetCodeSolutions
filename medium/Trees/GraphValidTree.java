class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Map<Integer,Integer> parentMap = new HashMap();
        parentMap.put(0,-1);
        Stack<Integer> nodeStack = new Stack();
        nodeStack.push(0);
        while(!nodeStack.isEmpty()){

            int node = nodeStack.pop();
            for(int neighbour : graph.get(node)){
                if(parentMap.get(node) == neighbour){
                    continue;
                }

                if(parentMap.containsKey(neighbour)){
                    return false;
                }

                nodeStack.push(neighbour);
                parentMap.put(neighbour,node);
            }
        }
        return parentMap.size() == n;
    }
}