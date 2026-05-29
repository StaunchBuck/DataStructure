package src.algorithm.dp.hard;

import java.util.*;

public class JumpgameIV {
    public static void main(String[] args) {
        JumpgameIV s = new JumpgameIV();
        System.out.println(s.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
    }

    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++) map.computeIfAbsent(arr[i],k -> new ArrayList<>()).add(i);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.offer(0);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                int index = queue.poll();
                visited[index] = true;
                if(index == n-1)
                    return steps;
                if(index-1>=0 && !visited[index-1]){
                    queue.offer(index-1);
                    visited[index-1] = true;
                }
                if(!visited[index+1]){
                    queue.offer(index+1);
                    visited[index+1] = true;
                }
                for(int i:map.getOrDefault(arr[index],new ArrayList<>())){
                    if(!visited[i]){
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
                map.remove(arr[index]);
                size--;
            }
            steps++;
        }
        return steps;
    }
}