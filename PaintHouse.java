package LeetcodePrograms;

/**
 * Created by rkhurana on 2/25/19.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int[] pre = new int[3];
        int[] cur = new int[3];
        for(int j=0; j<3; j++)
        {
            pre[j] = costs[0][j];
        }

        for(int i=1; i<costs.length; i++)
        {
            cur[0] = costs[i][0] + Math.min(pre[1], pre[2]);
            cur[1] = costs[i][1] + Math.min(pre[0], pre[2]);
            cur[2] = costs[i][2] + Math.min(pre[0], pre[1]);

            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return Math.min(pre[0], Math.min(pre[1], pre[2]));
    }

    public static void main(String []args){
        PaintHouse ph = new PaintHouse();
        int [][]costs ={{17,2,17},{16,16,5},{14,3,19}};
        System.out.print(ph.minCost(costs));
    }
}
