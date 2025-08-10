import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>(Arrays.asList(1)));

        for(int i=0;i<numRows-1;i++){
            List<Integer> temp = new ArrayList<>();

            temp.add(0);
            List<Integer> mid = result.get(result.size()-1);
            for(Integer num:mid){
                temp.add(num);
            }
            temp.add(0);

            List<Integer> row = new ArrayList<>();
            for(int j=0;j<temp.size()-1;j++){
                row.add(temp.get(j)+temp.get(j+1));
            }
            result.add(row);
        }

        return result;
    }
}