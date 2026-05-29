package src.algorithm.stack;

import java.util.Stack;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        NextGreaterElement2 obj = new NextGreaterElement2();
        int[] nums = {1,2,3,4,3};
        int[] res = obj.nextGreaterElements(nums);
        for(int val : res){
            System.out.print(val+" ");
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=len-1;i>=0;i--){
            int currPos = i;
            ans[currPos] = -1;
            int nextPos = (currPos+1)%len;
            while(nextPos != currPos ){
                if(nums[nextPos] > nums[currPos]) {
                    ans[currPos] = nums[nextPos];
                    break;
                }
                nextPos = (nextPos+1)%len;
            }
        }
        return ans;
    }
}