package LeetcodePrograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkhurana on 12/27/18.
 */
public class MatrixPath {
    public static List<Point> matrixPoint(int[][]matrix,Point startPoint,Point endPoint) {


        backtrack(matrix, new ArrayList<>(), startPoint, endPoint);
        return new ArrayList<>();

    }

    public static void backtrack(int[][] matrix, List<Point> tempList,Point startPoint, Point endPoint){
        if(startPoint.getX() < 0 || startPoint.getX() >= matrix.length ||
                startPoint.getY() < 0 || startPoint.getX()>=matrix.length
                || startPoint.getValue() == 'X')  //its a wall
            tempList.remove(tempList.size()-1);
            return;
//        tempList.add(startPoint);
//        int x=startPoint.getX();
//        int y=startPoint.getY();

//        backtrack(matrix,tempList , p1 , endPoint);
//
//        backtrack(matrix,tempList , p2 , endPoint);
//
//        backtrack(matrix,tempList , p3 , endPoint);
//
//        backtrack(matrix,tempList , p4 , endPoint);
    }

    public static void main(String []args){
        int [][]max3d={{},{},{},{}};
        Point startPoint = null;
        startPoint.setX(2);
        startPoint.setY(3);
        Point endPoint = null;
        endPoint.setX(4);
        endPoint.setY(4);
        System.out.println(matrixPoint(max3d , startPoint , endPoint));
    }
}

