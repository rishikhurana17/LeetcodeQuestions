package LeetcodePrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author Rishi Khurana
 */
public class TimeBasedKeyValueStore2 {
    private Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore2() {
        map = new HashMap<>();
    }

    // Spec: if timestamp is duplicated, original value will be covered.
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return null;
        Map.Entry<Integer,String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    public String get(String key) {
        if (!map.containsKey(key))
            return null;
        TreeMap treeMap = map.get(key);
        Object[] keys = treeMap.keySet().toArray();
        String value = (String)treeMap.get(keys[0]);
        return value;
    }


    public static void main(String []args){

        TimeBasedKeyValueStore2 map = new TimeBasedKeyValueStore2();
        map.set("foo","bar2" , 2);
        map.set("foo","bar3" , 3);
        map.set("foo","bar1" , 1);
        System.out.println(map.get("foo"));
        map.get("foo" , 1);
        map.get("foo" , 3);
        map.set("foo","bar2" , 4);
        map.get("foo" , 4);
        map.get("foo" , 5);

    }
}
