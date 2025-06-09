package src.leetcode.home.tech.problem.sorting;

import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,8,3,7,0,2,5,3};
        Integer pos = 1;
        while(pos<nums.length){
            int counter = pos;
            while(counter > 0 && nums[counter]<nums[counter-1]){
                int temp = nums[counter-1];
                nums[counter-1] = nums[counter];
                nums[counter] = temp;
                counter--;
            }
            pos++;
        }
        List.of(nums).forEach(System.out::println);
    }
}
