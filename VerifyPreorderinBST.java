package LeetcodePrograms;

import java.util.Stack;
// 255. Verify Preorder Sequence in Binary Search Tree
//        Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
//        You may assume each number in the sequence is unique.
//Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree.
// If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes,
// so just push the new one onto the stack. But before that, pop all smaller ancestor values, as we must now be in their
// right subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values as a lower bound,
// since being in their right subtree means we must never come across a smaller number anymore.
// TIme complexity of this problem in O(n) time.
public class VerifyPreorderinBST {


    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }

    public static void main(String []args){
        VerifyPreorderinBST verifyPreorderinBST = new VerifyPreorderinBST();
        int []preorder = {5,2,1,3 , 6};
        System.out.println(verifyPreorderinBST.verifyPreorder(preorder));
    }
}
