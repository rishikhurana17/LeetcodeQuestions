package LeetcodePrograms;



import java.util.HashMap;

/**
 * Created by rkhurana on 6/16/18.
 */
// Q149 Max Points on a line  ( maximum points on a plane )   #TopInterviewQuestion
// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

public class MaximumPoints {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
    //or
    public int maxPoints2(LeetcodePrograms.Point[] points) {
        if(points == null || points.length == 0) return 0;

        HashMap<Double, Integer> result = new HashMap<Double, Integer>();
        int max=0;

        for(int i=0; i<points.length; i++){
            int duplicate = 1;//
            int vertical = 0;
            for(int j=i+1; j<points.length; j++){

                //handle duplicates and vertical
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = points[j].y == points[i].y ? 0.0
                            : (1.0 * (points[j].y - points[i].y))
                            / (points[j].x - points[i].x);
                    if(result.get(slope) != null){
                        result.put(slope, result.get(slope) + 1);
                    }else{
                        result.put(slope, 1);
                    }
                }
            }
            for(Integer count: result.values()){
                if(count+duplicate > max){
                    max = count+duplicate;
                }
            }
            max = Math.max(vertical + duplicate, max);
            result.clear();
        }
        return max;
    }
    public static void main(String [] args ){
        Point P = new Point();

    }
}
