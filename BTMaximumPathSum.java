package LeetcodePrograms;

/**
 * Created by rkhurana on 10/27/18.
 */
public class BTMaximumPathSum {
    TreeNode root;
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);

        return Math.max(left, right) + node.val;
    }



    public static void main(String [] args){
        BTMaximumPathSum tree = new BTMaximumPathSum();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                tree.maxPathSum(tree.root));
    }
}
