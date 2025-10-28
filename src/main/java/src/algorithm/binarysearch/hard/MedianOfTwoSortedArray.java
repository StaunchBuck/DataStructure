package src.algorithm.binarysearch.hard;

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return calculate(nums1,nums1.length,nums2,nums2.length);
    }

    private double calculate(int[] nums1,int len1,int[] nums2,int len2){
        if(len1>len2)
            return calculate(nums2,len2,nums1,len1);
        int left=0;
        int right=len1;
        while(left<=right){

            int par1=(left+right)/2;
            int par2=(len1+len2+1)/2 - par1;

            int maxLeft1= par1==0 ? Integer.MIN_VALUE : nums1[par1-1];
            int minRight1= par1==len1 ? Integer.MAX_VALUE : nums1[par1];
            int maxLeft2= par2==0 ? Integer.MIN_VALUE : nums2[par2-1];
            int minRight2= par2==len2 ? Integer.MAX_VALUE : nums2[par2];

            if(maxLeft1<=minRight2 && maxLeft2<=minRight1){
                if((len1+len2)%2==0){
                    return (Double.valueOf(Math.max(maxLeft1,maxLeft2))+ Double.valueOf(Math.min(minRight1,minRight2)))/2;
                }else{
                    return Double.valueOf(Math.max(maxLeft1,maxLeft2));
                }
            }else if(maxLeft1>minRight2){
                right = par1-1;
            }else{
                left = par1+1;
            }
        }
        return Double.valueOf(0);
    }
}
