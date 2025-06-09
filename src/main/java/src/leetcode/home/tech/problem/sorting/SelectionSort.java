package src.leetcode.home.tech.problem.sorting;

import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{4,8,3,7,0,2,5,3};
        Integer pos = 0;
        while(pos<nums.length){
            Integer min = pos;
            for(int j = pos;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            Integer temp = nums[pos];
            nums[pos] = nums[min];
            nums[min] = temp;
            pos++;
        }
        List.of(nums).forEach(System.out::println);
    }
}
