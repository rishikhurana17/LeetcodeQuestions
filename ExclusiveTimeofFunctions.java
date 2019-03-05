package LeetcodePrograms;
//#LinkedIn Question
import java.util.*;
/**
 * Created by rkhurana on 2/26/19.
 */
public class ExclusiveTimeofFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty())
                res[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start"))
                stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }

    public static int[] exclusiveTime2(int n, List<String> logs) {
        int[] res = new int[n];
        int ptime = 0, running = 0;
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int time = Integer.parseInt(split[2]);
            if (!start)
                time++;

            res[running] += (time - ptime);
            if (start) {
                stack.push(running);
                running = func;
            } else {
                running = stack.pop();
            }
            ptime = time;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");


        System.out.println(exclusiveTime2(2, logs));
    }
}