class HitCounter {

    int total;
    Deque<Pair<Integer,Integer>> queue;
    public HitCounter() {
        total = 0;
        queue = new LinkedList<Pair<Integer,Integer>>();
    }

    public void hit(int timestamp) {
        if(queue.isEmpty() || queue.getLast().getKey() !=  timestamp){
            queue.add(new Pair<Integer,Integer>(timestamp,1));
        }
        else{
            int value = queue.getLast().getValue();
            queue.removeLast();
            queue.add(new Pair<Integer,Integer>(timestamp,value+1));
        }
        total++;
    }

    public int getHits(int timestamp) {
        while(!queue.isEmpty()){
            int diff = timestamp - queue.getFirst().getKey();
            if(diff >= 300){
                total -= queue.getFirst().getValue();
                queue.removeFirst();
            }
            else break;
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */