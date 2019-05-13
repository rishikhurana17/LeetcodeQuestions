package LeetcodePrograms;
// think of constructing string from a binary tree
public class ConstructBinaryTreeFrmString {
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int firstLeft = s.indexOf('(');
        if (firstLeft == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, firstLeft)));
        int count = 0, i = firstLeft;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                root.left = str2tree(s.substring(firstLeft + 1, i));
                break;
            }
            i++;
        }
        if (i != s.length() - 1) {
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        }
        return root;
    }

    public static void main(String []args){
        System.out.println(str2tree("4(2(3)(1))(6(5))"));
    }

}
