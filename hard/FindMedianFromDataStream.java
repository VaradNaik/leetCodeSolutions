class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap= new PriorityQueue(Collections.reverseOrder());
    }

    public void addNum(int num) {

        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */