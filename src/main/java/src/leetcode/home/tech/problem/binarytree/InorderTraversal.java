package src.leetcode.home.tech.problem.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9};
        InorderTraversal obj = new InorderTraversal();
        System.out.println(obj.inorderTraversal(ConvertArrayToBinaryTree.convert(arr)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        res.clear();
        calculate(root);
        return res;
    }

    public void calculate(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            res.add(node.val);
            return;
        }
        calculate(node.left);
        res.add(node.val);
        calculate(node.right);
    }
}