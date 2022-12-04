class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            int src = prerequisites[i][1];
            int dst = prerequisites[i][0];

            List<Integer> neighbours = graph.getOrDefault(src,new ArrayList<Integer>());
            neighbours.add(dst);
            graph.put(src,neighbours);

            inDegrees[dst]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                q.add(i);
            }
        }
        int i = 0;
        while(!q.isEmpty()){

            int node = q.poll();
            if(graph.containsKey(node)){
                for(Integer neigh: graph.get(node)){
                    inDegrees[neigh]--;

                    if(inDegrees[neigh]==0){
                        q.add(neigh);
                    }
                }
            }
            topologicalOrder[i++] = node;
        }
        if(i==numCourses){
            return topologicalOrder;
        }
        return new int[0];
    }
}