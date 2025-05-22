package src.leetcode.home.tech.problem;

public class KthLargestElement {

	public static void main(String[] args) {
		int[] a= new int[] {3,2,3,1,2,4,5,5,6};
		System.out.println(new KthLargestElement().findKthLargest(a, 4));

	}

	public int findKthLargest(int[] nums, int k) { //quick select
        int l = 0;
        int r = nums.length-1;
        return calculate(l,r,nums,k);
    }
    
	public int calculate(int l,int r,int[] nums,int k){
        int pivot = l;
        for(int i=l;i<r;i++){
            if(nums[i]<=nums[r]){
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
            return calculate(pivot+1,r,nums,k);
        else if (nums.length-pivot < k)
            return calculate(l,pivot-1,nums,k);
        else
            return nums[pivot];
    }
}
