package src.leetcode.home.tech.problem.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		List<TreeNode> queue = new ArrayList<>();
		queue.add(root);
		int start = 0;
		int end = queue.size();
		while (start < end) {
			List<Integer> local = new ArrayList<>();
			for (int i = start; i < end; i++) {
				TreeNode node = queue.get(i);
				local.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			result.add(local);
			start = end;
		}

		return result;
	}

}
