package LeetcodePrograms;
import java.util.*;
/**
 * @author Rishi Khurana
 * 489. Robot Room Cleaner
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 */
public class RobotRoomCleaner {
    public static void main(String args[]) {
        int[][] room = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1},
        };
        int[] pos = {1, 1};
        Robot robot = new RobotImpl(room, pos);
        new RobotRoomCleaner().cleanRoom(robot);
    }

    interface Robot {
        boolean move();

        void turnLeft();

        void turnRight();

        void clean();
    }

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }

    private void dfs(Robot robot, int i, int j, int dir, Set<String> visited) {
        // cell identifier
        String pos = i + "_" + j;
        if (visited.contains(pos)) return;
        robot.clean();
        visited.add(pos);
        for (int n = 0; n < 4; n++) { // move in all directions
            if (robot.move()) {
                int row = i, col = j;
                switch (dir) {
                    case 0: row = i - 1; break;
                    case 90: col = j + 1; break;
                    case 180: row = i + 1; break;
                    case 270: col = j - 1; break;
                }
                // visit next branch
                dfs(robot, row, col, dir, visited);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            // rotate 90 degrees to visit that branch
            robot.turnRight();
            dir += 90;
            dir = dir % 360;
        }
    }

    static class RobotImpl implements Robot {

        int[] pos;
        int[][] room;
        int dir = 0; // up: 0, right: 1, down: 2, left: 3

        public RobotImpl(int[][] room, int[] pos) {
            this.room = room;
            this.pos = pos;
        }

        @Override
        public boolean move() {
            int x = 0, y = 0;
            switch (dir) {
                case 0:
                    y = -1;
                    break;
                case 1:
                    x = 1;
                    break;
                case 2:
                    y = 1;
                    break;
                case 3:
                    x = -1;
                    break;
            }
            int newX = pos[0] + x;
            int newY = pos[1] + y;
            boolean outOfbounds = (newX < 0 || newY < 0 || newX > room.length - 1 || newY > room[0].length - 1);
            if (outOfbounds || room[newX][newY] == 0) {
                return false;
            }
            pos = new int[]{newX, newY};
            System.out.println("Robot at: " + pos[0] + " , " + pos[1]);

            return true;
        }

        @Override
        public void turnLeft() {
            dir -= 1;
            if (dir < 0) dir = 3;
        }

        @Override
        public void turnRight() {
            dir += 1;
            if (dir > 3) dir = 0;
        }

        @Override
        public void clean() {
            System.out.println("Cleaning  " + pos[0] + " , " + pos[1]);
        }
    }
}
