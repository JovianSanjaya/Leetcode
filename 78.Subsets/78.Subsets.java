import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> potential = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        findSubsets(result,potential,nums,i,n);
        return result;
    }

    public void findSubsets(List<List<Integer>> result,List<Integer> potential, int[] nums,int i,int n){
        if(i==n){
            result.add(new ArrayList<>(potential));
            return;
        }
        //exclude
        findSubsets(result,potential,nums,i+1,n);

        //include
        potential.add(nums[i]);
        findSubsets(result,potential,nums,i+1,n);
        
        potential.remove(new Integer(nums[i]));
    
    }
}

// Overloading of remove() in Java’s ArrayList
// ArrayList has two different remove methods:
// remove(int index) → removes the element at that position
// remove(Object o) → removes the first occurrence of that object

//In this case we wrap around the nums[i] with Integer object so that it can find the first occurrence instead of the position.