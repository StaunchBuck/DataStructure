package src.algorithm.dp;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum o = new CombinationSum();
        System.out.println(o.combinationSum(new int[]{2,3,6,7},7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer,List<List<Integer>>> dp = new HashMap<>();
        dp.put(0,new ArrayList<>());
        for(int cand:candidates){
            for(int sum=1;sum<=target;sum++){
                if(cand==sum){
                    List<List<Integer>> combinations = dp.getOrDefault(sum,new ArrayList<>());
                    combinations.add(new ArrayList<>(Arrays.asList(cand)));
                    dp.putIfAbsent(cand,combinations);
                }else if(cand<sum){
                    List<List<Integer>> prev_combinations = dp.getOrDefault(sum-cand,new ArrayList<>());
                    List<List<Integer>> prev_combinations_copy = new ArrayList<>();
                    for(List<Integer> comb:prev_combinations){
                        prev_combinations_copy.add(new ArrayList<>(comb));
                    }
                    prev_combinations_copy.forEach(combination -> combination.add(cand));

                    List<List<Integer>> combinations = dp.getOrDefault(sum,new ArrayList<>());
                    combinations.addAll(prev_combinations_copy);
                    dp.putIfAbsent(sum,combinations);
                }
            }
        }
        return dp.get(target);
    }
}