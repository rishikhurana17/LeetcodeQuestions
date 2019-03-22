package LeetcodePrograms;

/**
 * Created by rkhurana on 3/13/19.
 */
public class isMonotonic {
    public boolean isMonotonic(int[] A) {
        int inc=1;
        int dec=1;
        for(int i=1; i<A.length; i++){
            if(A[i] - A[i-1] > 0)
                inc++;
            else if(A[i] - A[i-1] < 0)
                dec++;
            else {
                inc++; dec++;
            }

        }
        return inc == A.length || dec == A.length;
    }

    public boolean isMonotonic2(int[] A) {
    boolean asciende = false;
    boolean desciende = false;
        for (int i = 1; i < A.length; i++)
    {
        if (A[i] > A[i - 1]) asciende = true;
        if (A[i] < A[i - 1]) desciende = true;

        if (asciende && desciende) return false;
    }

        return true;

    }
}
