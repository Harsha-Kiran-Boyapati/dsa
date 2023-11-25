package dsa.leetcode150.dp;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/?envType=study-plan-v2&envId=top-interview-150

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//The same number may be chosen from candidates an unlimited number of times.
//Two combinations are unique if thefrequency of at least one of the chosen numbers is different.
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input
//Constraints:
//
//        1 <= candidates.length <= 30
//        2 <= candidates[i] <= 40
//        All elements of candidates are distinct.
//        1 <= target <= 40
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //create lists for all numbers from 1 to target;
        //And that list holds combinations for each number
        //iterate through candidates and keep modifiying the lists with current candidate included
        ArrayList<ArrayList<List<Integer>>> lists = new ArrayList<>(target+1);
        for(int i=0;i<=target;i++) lists.add(new ArrayList<>());
        for(int candidate: candidates){
            for(int i=1; i<=target;i++){
                ArrayList<List<Integer>> currCombinationList = lists.get(i);
                for(int k=1; i - candidate*k >= 0; k++){
                    if(i-candidate*k==0){
                        List<Integer> newCombination = new ArrayList();
                        for(int j=1; j<=k; j++) newCombination.add(candidate);
                        currCombinationList.add(newCombination);
                        continue;
                    }
                   for( List<Integer> combination : lists.get(i-candidate*k)){
                       List<Integer> newCombination = new ArrayList(combination);
                       //add candidate k times
                       for(int j=1; j<=k; j++) newCombination.add(candidate);
                       currCombinationList.add(newCombination);
                   }
                }
            }
        }
        return lists.get(target);
    }
}
