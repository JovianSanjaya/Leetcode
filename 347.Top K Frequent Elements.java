
import java.util.HashMap;
import java.util.PriorityQueue;

//using lambda comparator (a,b)->map.get(a)-map.get(b)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //counting
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //heap insertion
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->map.get(a)-map.get(b));
        for(Integer key:map.keySet()){
            pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
        }

        //extract result to array
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll();
        }
        
        return ans;
    }


}



// implmenting comparator class 
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.PriorityQueue;
// import java.util.Arrays;

// public class solution {
//     public static void main(String[] args) {
//         // Example usage
//         int[] nums = {1, 1, 1, 2, 2, 3};
//         int k = 2;
//         topk solver = new topk();
//         int[] result = solver.topKFrequent(nums, k);
//         System.out.println(Arrays.toString(result));
//     }
// }

// class topk {
//     public int[] topKFrequent(int[] nums, int k) {
//         // 1) Counting frequencies
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         // 2) Use a Comparator class instead of a lambda
//         PriorityQueue<Integer> pq = new PriorityQueue<>(new FrequencyComparator(map));
//         for (Integer key : map.keySet()) {
//             pq.offer(key);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         // 3) Extract top K into result array
//         int[] ans = new int[k];
//         for (int i = k - 1; i >= 0; i--) {
//             ans[i] = pq.poll();
//         }
//         return ans;
//     }

//     /**
//      * Comparator class that orders integers by their frequency in the provided map.
//      */
//     private static class FrequencyComparator implements Comparator<Integer> {
//         private final HashMap<Integer, Integer> freqMap;

//         public FrequencyComparator(HashMap<Integer, Integer> freqMap) {
//             this.freqMap = freqMap;
//         }

//         @Override
//         public int compare(Integer a, Integer b) {
//             // Compare frequencies: smallest first (min-heap behavior)
//             return Integer.compare(freqMap.get(a), freqMap.get(b));
//         }
//     }
// }
