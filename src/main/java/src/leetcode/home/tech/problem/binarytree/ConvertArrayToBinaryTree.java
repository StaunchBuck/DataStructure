package src.leetcode.home.tech.problem.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayToBinaryTree {


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9};
        System.out.println(ConvertArrayToBinaryTree.convert(arr));
    }

    public static TreeNode convert(Integer[] array){
        if(array == null || array.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(array[0]);
        int arr_size = array.length;
        //will store the original position
        List<Integer> list = new ArrayList<>();
        int counter = 0;
        int posVal = -1;
        while(counter<arr_size){
            if(array[counter] != null){
                list.add(++posVal);
            }else{
                list.add(posVal);
            }
            counter++;
        }
        Integer[] position_arr = list.toArray(new Integer[0]);
        ConvertArrayToBinaryTree.keepOnAdding(head,array,0,arr_size,position_arr);
        return head;
    }

    private static void keepOnAdding(TreeNode node,Integer[] array,int i,int size,Integer[] position_arr){
        int left = 2*position_arr[i]+1;
        int right = 2*position_arr[i]+2;
        if(left<size && array[left] != null){
            node.left = new TreeNode(array[left]);
            ConvertArrayToBinaryTree.keepOnAdding(node.left,array,left,size,position_arr);
        }
        if(right<size && array[right] != null){
            node.right = new TreeNode(array[right]);
            ConvertArrayToBinaryTree.keepOnAdding(node.right,array,right,size,position_arr);
        }
    }
}
