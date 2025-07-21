import java.util.PriorityQueue;

class KthLargest { 

    PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k=k;
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            //if more than the heap size then just remove the lowest element
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        //if more than the heap size then just remove the lowest element
        if(minHeap.size()>this.k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
