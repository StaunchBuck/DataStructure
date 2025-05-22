package src.leetcode.home.tech.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1,1,2,2,3,3,3,3,3,3};
		int[] result = new TopKFrequentElements().topKFrequent(arr,2);
		for(int s:result)
			System.out.println(" "+s);

	}
	
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.get(i) == null)
                map.put(i,1);
            else
                map.put(i,map.get(i)+1);
        }
        int l = 0;
        int r = map.size()-1;
        List<Integer> list = map.keySet().stream().collect(Collectors.toList());
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++)
        	arr[i] = list.get(i);
        int start = calculate(l,r,arr,k,map);
        int[] result = new int[arr.length-start];
        int count = 0;
        for(int i =calculate(l,r,arr,k,map);i<arr.length;i++) {
        	result[count] = arr[i];
        	count++;
        }
        return result;
    }
    
    public static int calculate(int l,int r,int[] nums,int k,Map<Integer,Integer> map){
        int pivot = l;
        for(int i=l;i<r;i++){
            if(map.get(nums[i])<=map.get(nums[r])){
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                pivot++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[r];
        nums[r] = temp;
        
        if(nums.length-pivot > k)
            return calculate(pivot+1,r,nums,k,map);
        else if (nums.length-pivot < k)
            return calculate(l,pivot-1,nums,k,map);
        else
            return pivot;
    }
}
