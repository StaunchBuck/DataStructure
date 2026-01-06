package src.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(12));
    }
    public int numSquares(int n) {
        Map<Integer,Integer> minSumMap = new HashMap<>();
        minSumMap.put(0,0);
        determine(n,minSumMap);
        return minSumMap.get(n);
    }

    int determine(int n, Map<Integer,Integer> minSumMap){
        if(minSumMap.containsKey(n))
            return minSumMap.get(n);
        int start = (int) Math.sqrt(n);
        int end = 1;
        for(int i=start;i>=end;i--){
            int count = 0;
            count += (n/(i*i));
            count +=determine(n%(i*i),minSumMap);
            System.out.println("n->"+n+" count->"+count);
            int minVal = minSumMap.getOrDefault(n,Integer.MAX_VALUE);
            minSumMap.put(n,Math.min(minVal,count));
            System.out.println("minSumMap->"+minSumMap.get(n));
            if(count<=2)
                break;
        }
        return minSumMap.get(n);
    }
}