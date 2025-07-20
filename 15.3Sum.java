import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sort
        //Two sum pointer
        //remove duplicate (1. overall, 2. each)

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i=0;i<nums.length-2;i++){
            int fp=i+1;
            int lp=nums.length-1;

            //overall
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(fp<lp){
                int sum=nums[i]+nums[fp]+nums[lp];
                List <Integer> triplet = new ArrayList<Integer>();

                if(sum==0){
                    triplet.add(nums[i]);
                    triplet.add(nums[fp]);
                    triplet.add(nums[lp]);
                    result.add(triplet);
                    
                    //each
                    while(fp<lp && nums[fp]==nums[fp+1]){
                        fp++;
                    }

                    while(fp<lp && nums[lp]==nums[lp-1]){
                        lp--;
                    }

                    fp++;
                    lp--;

                }
                else if(sum<0){
                    fp++;
                }
                else if(sum>0){
                    lp--;
                }
            }
        }

        return result;
    }
}