package leetcode;

import java.util.Stack;

/**
 * Created by rkhurana on 10/21/18.
 */
public class LongestValidParenthesis {
    public static  int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (!stack.empty() && s.charAt(stack.peek()) == '(') stack.pop();
            else stack.push(i);
        }
        if (stack.empty()) return s.length();
        int res = 0, high = s.length();

        while (!stack.empty()) {
            int low = stack.pop();
            res = Math.max(res, high - low - 1);
            high = low;
        }
        return Math.max(res, high);
    }


    public static int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String []args){
        System.out.println(longestValidParentheses2("(()())())"));
    }
}
