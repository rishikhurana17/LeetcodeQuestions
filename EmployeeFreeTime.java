package LeetcodePrograms;
import java.util.*;
    //Employee Free Time
    //LeetCode 759
/**
 * Created by rkhurana on 3/17/19.
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        avails.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));

        Interval temp = timeLine.get(0);
        for(Interval each : timeLine) {
            if(temp.end < each.start) {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            }else{
                temp = temp.end < each.end ? each : temp;
            }
        }
        return result;
    }
    public static void main(String []args){

        EmployeeFreeTime eft = new EmployeeFreeTime();
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(5,6);
        Interval i3 = new Interval(1,3);
        Interval i4 = new Interval(4,10);
        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = new ArrayList<>();
        List<Interval> list3 = new ArrayList<>();
        list1.add(i1);
        list1.add(i2);
        list2.add(i3);
        list3.add(i4);
        List<List<Interval>> finalList = new ArrayList<>();
        finalList.add(list1);
        finalList.add(list2);
        finalList.add(list3);
        System.out.print(eft.employeeFreeTime(finalList));
    }
}
