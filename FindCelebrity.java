package LeetcodePrograms;
import java.util.*;
public class FindCelebrity {
    int [][]matrix ={{1,1,0},
                     {0,1,0},
                     {1,1,1}};
    public int findCelebrity(int n) {
        // base case
        if (n <= 0) return -1;
        if (n == 1) return 0;

        Stack<Integer> stack = new Stack<>();

        // put all people to the stack
        for (int i = 0; i < n; i++)
            stack.push(i);

        int a = 0, b = 0;

        while (stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();

            if (knows(a, b))
                // a knows b, so a is not the celebrity, but b may be
                stack.push(b);
            else
                // a doesn't know b, so b is not the celebrity, but a may be
                stack.push(a);
        }

        // double check the potential celebrity
        int c = stack.pop();

        for (int i = 0; i < n; i++)
            // c should not know anyone else
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;

        return c;
    }

    private boolean knows(int c, int i) {
        if(matrix[c][i] == 1)
            return true;
        else
            return false;
    }


}
