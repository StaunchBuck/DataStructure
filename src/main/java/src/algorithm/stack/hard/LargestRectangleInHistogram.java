package src.algorithm.stack.hard;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram{

    public static void main(String[] args) {
        LargestRectangleInHistogram o = new LargestRectangleInHistogram();
        System.out.println(o.largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));
    }
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        int[] leftMargin = new int[heights.length];
        int[] rightMargin = new int[heights.length];
        stack.push(0);
        leftMargin[0]=0;
        for(int i=1;i<len;i++){
            int pos = i;
            while(pos>=0 && !stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
                pos--;
            }
            leftMargin[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            stack.push(i);
        }
        stack.clear();
        stack.push(len-1);
        rightMargin[len-1] = len-1;
        for(int i=len-2;i>=0;i--){
            int pos = i;
            while(pos<len && !stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
                pos++;
            }
            rightMargin[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
            stack.push(i);
        }
        System.out.println(Arrays.toString(leftMargin));
        System.out.println(Arrays.toString(rightMargin));
        for(int i=0;i<len;i++){
            max = Math.max(max,(rightMargin[i]-leftMargin[i]+1)*heights[i]);
        }
        return max;
    }
}