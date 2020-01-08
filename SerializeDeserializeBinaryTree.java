package LeetcodePrograms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rkhurana on 3/5/19.
 */
public class SerializeDeserializeBinaryTree {
    private static final String splitter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
//        if(node.left ==null && node.right == null)
//            sb.append(AN).append(splitter);
        if (node == null) {
            sb.append(NN).append(splitter);
        } else {
            sb.append(node.val).append(splitter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        //Deque<String> nodes = new LinkedList<>();
        Queue<String> nodes1 = new LinkedList<>();
        //both the below statements will work

        nodes1.addAll(Arrays.asList(data.split(splitter)));
//		Collections.addAll(nodes1, data.split(splitter)); this works too
        return buildTree(nodes1);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();

        if (val.equals(NN))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    public static void main(String []args){
        SerializeDeserializeBinaryTree binaryTree = new SerializeDeserializeBinaryTree();
        TreeNode tree = new TreeNode(1);
//        tree.root = new TreeNode(1);
        tree.left = new TreeNode(2);
//        tree.right = new TreeNode(3);
//        tree.left.left = new TreeNode(4);
//        tree.left.right = new TreeNode(5);
        String x = binaryTree.serialize2(tree);
        System.out.println(x);
//        TreeNode tree2 = binaryTree.deserialize2(x);
//        System.out.println(tree2);
//            System.out.println(x);
    }
}
