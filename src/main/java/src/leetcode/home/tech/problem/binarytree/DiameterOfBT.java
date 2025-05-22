package src.leetcode.home.tech.problem.binarytree;

public class DiameterOfBT {
	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		calculate(root);
		return diameter;
	}

	public int calculate(TreeNode node) {
		if (node == null)
			return 0;
		int left = calculate(node.left);
		int right = calculate(node.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}

}
