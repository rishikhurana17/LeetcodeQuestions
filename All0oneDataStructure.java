//#LinkedIn Question
package LeetcodePrograms;
import java.util.*;
/**
 * Created by rkhurana on 2/24/19.
 */
public class All0oneDataStructure {
    HashMap<String, Integer> map;
    HashMap<Integer, HashSet<String>> vals;
    String maxKey;
    String minKey;
    int max;
    int min;

    public All0oneDataStructure() {
        map = new HashMap<>();
        vals = new HashMap<>();
        maxKey = "";
        minKey = "";
        max = 0;
        min = 0;
    }

    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        int val = map.get(key);
        if(vals.get(val) == null)
            vals.put(val, new HashSet<>());
        vals.get(val).add(key);
        if(vals.containsKey(val - 1)){  //checking if the element is just been incremented was already there in the map or not. If it was then it is supposed to be deleted for the old value
            vals.get(val - 1).remove(key);
            if(vals.get(val - 1).size() == 0)
                vals.remove(val - 1); // remove the value and if the size of that entry becomes 0 then remove the entry as well
        }
        if(map.get(key) > max){
            max = map.get(key);
            maxKey = key;
        }
        if(map.get(key) - 1 == min){
            if(vals.get(min) == null || vals.get(min).size() == 0){   // this is the situation (only A exist in the table) when A=1 but now A is 2 so minimum is been also changed and the old entry A=1 does not exist, so increment the min
                min++;
                minKey = key;
            }
            else minKey = vals.get(min).iterator().next();
        }
        if(map.get(key) == 1){ // after insertion of 2 A, when B is inserted now B value is 1 so now the minimum value needs to be changed as well
            min = 1;
            minKey = key;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            if(map.get(key) == 1){
                map.remove(key);
                vals.get(1).remove(key);
                if(vals.get(1).size() > 0){
                    min = 1;
                    minKey = vals.get(1).iterator().next();
                    if(max == 1) maxKey = minKey;
                }else{
                    vals.remove(1);
                    if(map.size() > 0){
                        int tempMin = Integer.MAX_VALUE;
                        for(Map.Entry<Integer, HashSet<String>> e : vals.entrySet()){
                            if(e.getValue().size() > 0)
                                tempMin = Math.min(tempMin, e.getKey());
                        }
                        min = tempMin;
                        minKey = vals.get(min).iterator().next();
                    }else{
                        min = 0;
                        max = 0;
                    }
                }
            }else{
                map.put(key, map.get(key) - 1);
                int val = map.get(key);
                vals.get(val + 1).remove(key);
                if(vals.get(val + 1).size() == 0)
                    vals.remove(val + 1);
                if(vals.get(val) == null)
                    vals.put(val, new HashSet<>());
                vals.get(val).add(key);
                if(val + 1 == max){
                    if(vals.get(max) == null || vals.get(max).size() == 0)
                        max--;
                    else
                        maxKey = vals.get(max).iterator().next();
                }
                if(val + 1 == min){
                    min--;
                    minKey = key;
                }
            }
        }
    }

    public String getMaxKey() {
        if(map.size() == 0) return "";
        return maxKey;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.size() == 0) return "";
        return minKey;
    }

    public static void main(String []args){
        All0oneDataStructure ds = new All0oneDataStructure();
        ds.inc("A");
        ds.inc("A");
        ds.inc("B");
        ds.inc("D");
        ds.inc("C");
        ds.inc("A");
        ds.inc("B");
        ds.inc("B");
        ds.inc("B");
        ds.inc("C");
        ds.inc("D");
        ds.inc("E");



        ds.dec("A");
        ds.dec("C");
        ds.dec("D");
        ds.dec("C");
        ds.dec("E");


    }
}
