package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rkhurana on 11/13/18.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {

        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[][] diffs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Grid> queue = new LinkedList<Grid>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Grid(i, j));
                }
            }
        }

//        while (!queue.isEmpty()) {
//            Grid cur = queue.poll();
//            for (int[] diff : diffs) {
//                int i = cur.x + diff[0];
//                int j = cur.y + diff[1];
//                if (i >= 0 && i <= rooms.length - 1 && j >= 0 && j <= rooms[0].length - 1 && rooms[i][j] == Integer.MAX_VALUE) {
//                    rooms[i][j] = rooms[cur.x][cur.y] + 1;
//                    queue.offer(new Grid(i, j));
//                }
//            }
//        }

        while (queue.size() != 0){
            Grid cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i = 0 ; i < 4 ; i++)
                addToQueue(x + move[i][0] , y + move[i][1] , rooms ,  queue , rooms[x][y]+1);
            

        }
    }

    private void addToQueue(int x, int y, int[][] rooms, Queue<Grid> queue, int steps) {
               if (x < 0 || x >= rooms.length  || y < 0 && y >= rooms[0].length
                       || rooms[x][y] != Integer.MAX_VALUE  || rooms[x][y] == -1)
               return ;
                    rooms[x][y] = steps;
                    queue.offer(new Grid(x, y));

    }
}

class Grid {
    int x;
    int y;
    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
