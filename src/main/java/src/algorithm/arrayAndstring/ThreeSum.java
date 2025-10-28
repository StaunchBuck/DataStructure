package src.algorithm.arrayAndstring;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        System.out.println(sum.threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> block = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            if(!block.contains(nums[i])){
                List<List<Integer>> list =  is2Sum(i+1,nums.length-1,nums,-1*nums[i]);
                for(int j=0;j<list.size();j++){
                    list.get(j).add(nums[i]);
                    result.add(list.get(j));
                }
                block.add(nums[i]);
            }
        }
        return result;
    }

    public List<List<Integer>> is2Sum(int start,int end,int[] nums,int target){
        List<List<Integer>> list = new ArrayList<>();
        while(start<end){
            if(nums[start]+nums[end]==target){
                list.add(new ArrayList<>(List.of(nums[start],nums[end])));
                while(start<end && nums[start]==nums[start+1]){
                    start++;
                }
                while(start<end && nums[end] == nums[end-1]){
                    end--;
                }
                start++;
                end--;
            }else if(nums[start]+nums[end]>target){
                end--;
            }else{
                start++;
            }
        }
        // for(List<Integer> i:list){
        //     System.out.print(target+"["+i.get(0)+","+i.get(1)+"] ");
        // }
        // System.out.println("");
        return list;
    }
}

