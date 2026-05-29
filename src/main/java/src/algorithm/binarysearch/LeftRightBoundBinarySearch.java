package src.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRightBoundBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,3,5};
        Integer[] arr1 = new Integer[]{2,2,3,3};
        LeftRightBoundBinarySearch o = new LeftRightBoundBinarySearch();
//        System.out.println(o.classicBinarySearch(arr,8));
//        System.out.println(o.leftBoundBinarySearch(arr,4));
//        System.out.println(o.leftBoundBinarySearch(arr,3));
//        System.out.println(o.leftBoundBinarySearch(arr,1));
//
//        System.out.println(o.bs_upperBound(Arrays.asList(arr1),4));
//        System.out.println(o.bs_upperBound(Arrays.asList(arr1),3));
//        System.out.println(o.bs_upperBound(Arrays.asList(arr1),1));

        List<Integer> list = new ArrayList(Arrays.asList(2,6,8,10,13));
        System.out.println(o.searchUpper(list, 10));
    }

    private int searchUpper(List<Integer> list,int k){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(list.get(mid)<=k){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return right;
    }

    public int classicBinarySearch(int[] arr,int k){

        int start = 0;int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid]<k){
                start = mid+1;
            }else
                end = mid-1;
        }
        return -1;
    }

    public int leftBoundBinarySearch(int[] arr,int k){

        int start = 0;int end = arr.length;
        while(start<end){
            int mid = (start+end)/2;
            if(k<=arr[mid]){
                end = mid;
            }else
                start = mid+1;
        }
        return start;
    }

    public int rightBoundBinarySearch(int[] arr,int k){
        int start = 0;int end = arr.length;
        while(start<end){
            int mid = (start+end)/2;
            if(k<arr[mid]){
                end = mid;
            }else
                start = mid+1;
        }
        return start-1;
    }

    // do check out this
    private int bs_upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int result = list.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
