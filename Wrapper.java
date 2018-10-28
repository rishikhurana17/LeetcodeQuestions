package leetcode;

public class Wrapper {
	int size;
    int lower, upper;
    boolean isBST;
 
    public Wrapper(){
        lower = Integer.MAX_VALUE;
        upper = Integer.MIN_VALUE;
        isBST = false;
        size = 0;
    }
}
