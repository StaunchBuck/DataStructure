package src.leetcode.home.tech.problem.sorting;

import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,8,3,7,0,2,5,3};
        QuickSort obj = new QuickSort();
        List.of(obj.sort(nums,0,nums.length-1)).forEach(System.out::println);
    }

    private Integer[] sort(Integer[] nums, int start, int end) {
        if(start > end)
            return nums;
        int pivot = end;
        int pos = start;
        for(int i=start;i<end;i++){
            if(nums[i] <= nums[pivot]){
                swap(nums,pos,i);
                pos++;
            }
        }
        swap(nums,pos,pivot);
        sort(nums,start,pos-1);
        sort(nums,pos+1,end);
        return nums;
    }

    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
