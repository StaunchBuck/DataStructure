package src.algorithm.dp.hard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumCostToCutAStick {

    public static void main(String[] args) {
        MinimumCostToCutAStick m = new MinimumCostToCutAStick();
        System.out.println(m.minCost(7,new int[]{1,3,4,5}));
    }
    public int minCost(int n, int[] cuts) {
        Set<Integer> cutset = Arrays.stream(cuts).boxed().collect(Collectors.toSet());
        return solve(1,n-1,cutset);
    }

    int solve(int start, int end, Set<Integer> cutset){
        System.out.println(start+" and "+end+" and "+cutset.toString());
        if(start == end || cutset.isEmpty())
            return 0;

        int min_cost = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            if(cutset.contains(i)){
                cutset.remove(i);
                min_cost = Math.min(min_cost,solve(start,i,cutset)+solve(i+1,end,cutset)+(end-start+2));
                cutset.add(i);
            }
        }
        return min_cost;
    }
}