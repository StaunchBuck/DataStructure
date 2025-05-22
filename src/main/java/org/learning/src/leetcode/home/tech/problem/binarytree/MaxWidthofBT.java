package org.learning.src.leetcode.home.tech.problem.binarytree;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthofBT {
	
	int maxWidth = 0;
    Map<Integer,Integer> levelMap = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        calculate(root,0,0);
        return maxWidth;  
    }
    
    public void calculate(TreeNode node,int level,int position){
        if(node == null) return;
        if(levelMap.get(level) == null) levelMap.put(level,position);
        maxWidth=Math.max(maxWidth,position-levelMap.get(level)+1);
        calculate(node.left,level+1,position*2);
        calculate(node.right,level+1,position*2+1);
    }

}
