package LeetcodePrograms;

/**
 * Created by rkhurana on 1/29/19.
 */
public class JumpGame {
    public static int jump (int A[]){
        if(A.length <=1 )
            return 0;
        int ladder = A[0]; //keep track of the ladder at each step
        int stairs = A[0]; //keep track of stairs at each step
        int jump = 1;
        for(int level = 1; level < A.length ; level++){
            if(level == A.length - 1)
                return jump;
            if(level + A[level] > ladder)
                ladder = level + A[level]; //build up the ladder
            stairs--; //use up the stairs
            if(stairs ==0){
                jump++;
                stairs = ladder - level;
            }
        }
        return jump;
    }

    public static void main(String []args){
        int a[]={2,3,1,1,4};
        System.out.print(jump(a));
    }
}
