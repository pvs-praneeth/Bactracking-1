// Time Complexity : O(2^n)
// Space Complexity : O(H) where max height of the tree is = target/min(candidates)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Fumbled a little when passing index value of the helper function in for loop.


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // base condition check for inputs
        if(candidates == null || candidates.length == 0 || target == 0) return result;
        
        helper(result, candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    public void helper(List<List<Integer>> result, int[] candidates, 
                       int target, int index, List<Integer> path){
        // base case
        if(target < 0 || index == candidates.length) return;
        
        // If we have reached the desired target then add the current path the result
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic.
        // With index as the pivot, try to find all the combinations possible for the path.
        // The index value in the function is i, since we can re-use the index element for calculating the target sum. 
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(result, candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
    
}
