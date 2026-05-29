package src.algorithm.dp.hard;


public class JumpgameV {

    public static void main(String[] args) {
        JumpgameV o = new JumpgameV();
        System.out.println(o.maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12},2));
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length; int res = 0;
        int[] mem = new int[n];
        for(int i=0;i<n;i++) res = Math.max(res,dfs(i,arr,d,n,mem)+1);
        return res;
    }

    public int dfs(int i,int[] arr,int d,int n,int[] mem){
        if(mem[i] != 0) return mem[i];

        int localMax = 0;
        int left = Math.max(i-d,0);
        int right = Math.min(i+d,n-1);
        int next = i-1;
        while(next>=left){
            if(arr[i]>arr[next]){
                localMax = Math.max(localMax,dfs(next,arr,d,n,mem)+1);
            }else
                break;
            next--;
        }
        next = i+1;
        while(next<=right){
            if(arr[i]>arr[next]){
                localMax = Math.max(localMax,dfs(next,arr,d,n,mem)+1);
            }else
                break;
            next++;
        }
        mem[i] = localMax;
        return mem[i];
    }
}