package LeetcodePrograms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rkhurana on 1/29/19.
 * 958. Check Completeness of a Binary Tree  facebook

 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in
 * the last level ({4, 5, 6}) are as far left as possible.
 */
public class ValidateCompleteBinaryTreeIterative {
    static boolean isCompleteBT(Node root)
    {
// Base Case: An empty tree is complete Binary Tree
        if(root == null)
            return true;

// Create an empty queue
        Queue<Node> queue =new LinkedList<>();

// Create a flag variable which will be set true when a non full node is seen
        boolean flag = false;

// Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp_node = queue.remove();

            /* Check if left child is present*/
            if(temp_node.left != null) {
// If we have seen a non full node, and we see a node with non-empty left child, then the given tree is not a complete Binary Tree
                if(flag == true)
                    return false;
                // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;

            /* Check if right child is present*/
            if(temp_node.right != null) {
// If we have seen a non full node, and we see a node with non-empty right child, then the given tree is not a complete Binary Tree
                if(flag == true)
                    return false;

                // Enqueue Right Child
                queue.add(temp_node.right);

            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
        }
        // If we reach here, then the tree is complete Bianry Tree
        return true;
    }

    /* Driver program to test above functions*/
    public static void main(String[] args)
    {

        /* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        if(isCompleteBT(root) == true)
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
    }
}
