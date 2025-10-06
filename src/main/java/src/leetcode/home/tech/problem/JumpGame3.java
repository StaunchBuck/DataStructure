package src.leetcode.home.tech.problem;

import java.util.HashSet;
import java.util.Set;

public class JumpGame3 {
    public static void main(String[] args) {
//        int[] arr = {4,2,3,0,3,1,2};
//        int start = 5;
        int[] arr = {3,0,2,1,2};
        int start = 2;
        Set<Integer> mem = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        System.out.print(new JumpGame3().determine(arr,5,mem,visited));
    }

    private boolean determine(int[] arr, int start,Set<Integer> mem,Set<Integer> visited){
        if(mem.contains(start) || start<0 || start>arr.length-1 || visited.contains(start)){
            return false;
        }
        if(arr[start] == 0)
            return true;
        visited.add(start);
        boolean right = determine(arr,start+arr[start],mem,visited);
        boolean left = determine(arr,start-arr[start],mem,visited);
        if(!right && !left)
            mem.add(start);
        visited.remove(start);
        return left || right;
    }
}
