package src.leetcode.home.tech.problem.sorting;

import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,8,3,7,0,2,5,3};
        MergeSort obj = new MergeSort();
        List.of(obj.sort(nums,0,nums.length-1)).forEach(System.out::println);

    }

    private Integer[] sort(Integer[] nums,int start,int end){
        if(end==start)
            return new Integer[]{nums[start]};
        int mid = (start+end)/2;
        Integer[] left = sort(nums,start,mid);
        Integer[] right = sort(nums,mid+1,end);
        return merge(left,right);
    }

    private Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] result = new Integer[left.length+right.length];
        int leftC=0;
        int rightC=0;
        int pos = 0;
        while(leftC<left.length && rightC<right.length){
            if(left[leftC]<right[rightC]){
                result[pos++] = left[leftC++];
            }else{
                result[pos++] = right[rightC++];
            }
        }
        if(leftC<left.length){
            while(leftC<left.length){
                result[pos++] = left[leftC++];
            }
        }
        if(rightC<right.length){
            while(rightC<right.length){
                result[pos++] = right[rightC++];
            }
        }
        return result;
    }
}
