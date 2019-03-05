package LeetcodePrograms;
import java.util.*;

/**
 * Created by rkhurana on 3/3/19.
 */
public class ConvertBSTtoDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        Node head = new Node(0,null,null);
        Node prev = head;

        Stack<Node> st = new Stack<>();
        while(root!=null||!st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            Node node = st.pop();
            root = node.right;

            node.left = prev;
            prev.right = node;
            prev = node;
        }

        prev.right = head.right;
        head.right.left = prev;

        return head.right;
    }
}
