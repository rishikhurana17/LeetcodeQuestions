package LeetcodePrograms;
import java.util.*;
/**
 * @author Rishi Khurana
 * 951. Flip Equivalent Binary Trees
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child
 * subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of
 * flip operations.
 *
 * Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes
 * root1 and root2.
 *
 *
 *
 * Example 1:
 *
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 * Flipped Trees Diagram

 */
public class FlipEquivalentBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();

            if (curr1 == null && curr2 == null) {
                continue;
            }
            if (!isEquals(curr1, curr2)) {
                return false;
            }
            if (isEquals(curr1.left, curr2.left) && isEquals(curr1.right, curr2.right)) {
                queue.offer(curr1.left);
                queue.offer(curr2.left);
                queue.offer(curr1.right);
                queue.offer(curr2.right);
            } else if (isEquals(curr1.left, curr2.right) && isEquals(curr1.right, curr2.left)) {
                queue.offer(curr1.left);
                queue.offer(curr2.right);
                queue.offer(curr1.right);
                queue.offer(curr2.left);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null && root1.val == root2.val) {
            return true;
        } else {
            return false;
        }
    }

}
