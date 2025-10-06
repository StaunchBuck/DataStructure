package src.leetcode.home.tech.problem;

public class KthLargestElementInStream {

    private int k;
    private Integer[] nums = new Integer[10000]; //is a maxHeap
    private int length = 0;

    public static void main(String[] args) {
        KthLargestElementInStream obj = new KthLargestElementInStream(3,new int[]{4,5,8,2});
        System.out.println(obj.add(3)); // return 4
        System.out.println(obj.add(5)); // return 5
        System.out.println(obj.add(10)); // return 5
        System.out.println(obj.add(9)); // return 8
        System.out.println(obj.add(4)); // return 8
    }
    public KthLargestElementInStream(int k, int[] arr) {
        this.k = k;
        for(int i=0;i<arr.length;i++){
            this.nums[i] = arr[i];
        }
        this.length = arr.length;
        maxHeap(this.length-1);
//        for(int i = 0;i<this.length;i++){
//            System.out.print(this.nums[i]);
//        }
    }

    private void maxHeap(int end){
        for(int i=end/2;i>-1;i--){
            downHeapify(this.nums,i,end);
        }
    }

    private void downHeapify(Integer[] nums,int pos,int end){
        if(2*pos+1 > end){
            //is a leaf node
            return;
        }if(2*pos+2 <= end){
            //contains both nodes
            int greaterPos = nums[2*pos+1] > nums[2*pos+2] ? 2*pos+1 : 2*pos+2;
            if(nums[greaterPos] > nums[pos]){
                swap(nums,greaterPos,pos);
                downHeapify(nums,greaterPos,end);
            }
        }else{
            //contains only left node
            if(nums[2*pos+1] > nums[pos]){
                swap(nums,2*pos+1,pos);
                downHeapify(nums,2*pos+1,end);
            }
        }
    }

    private void swap(Integer[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int add(int val) {
        this.length++;
        this.nums[this.length-1] = val;
        upHeapify(this.nums,this.length-1,0);

        // do maxHeap k times
        Integer[] temp_ = new Integer[this.length];
        for(int i=0;i<this.length;i++){
            temp_[i]=this.nums[i];
        }

        int len = temp_.length-1;
        int res = temp_[0];
        for(int i=1;i<=k;i++){
            res = temp_[0];
            swap(temp_,len,0);
            len--;
            downHeapify(temp_,0,len);
        }
        return res;
    }

    private void upHeapify(Integer[] nums,int pos,int end){
        if(pos/2 >=end){
            if(nums[pos] > nums[pos/2]){
                swap(nums,pos,pos/2);
                upHeapify(nums,pos/2,end);
            }
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */