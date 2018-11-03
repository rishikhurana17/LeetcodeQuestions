package leetcode;

import java.util.*;

public class scheduleTaskwithDependencies {
	/**
	Given a list of tasks and their dependencies write a program to evaluate a valid order in which the tasks can be executed.
	Example:
	--------
	t1 - t2, t3
	t2 - t6
	t3 - t2, t4
	t4 - t2, t5
	t5 -
	t6 - t5

	order:
	-------
	 t5,t6,t2,t4,t3,t1
	 **/


	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        HashMap<String, ArrayList<String>> initialMap = new HashMap<String, ArrayList<String>> ();
	        HashMap<String, ArrayList<String>> reverseMap = new HashMap<String, ArrayList<String>> ();    
	        
	        initialMap.put("t1", new ArrayList<String>());
	        initialMap.put("t2", new ArrayList<String>());
	        initialMap.put("t3", new ArrayList<String>());
	        initialMap.put("t4", new ArrayList<String>());
	        initialMap.put("t5", new ArrayList<String>());
	        initialMap.put("t6", new ArrayList<String>());
	        
	        initialMap.get("t1").add("t2");
	        initialMap.get("t1").add("t3");
	        initialMap.get("t2").add("t6");
	        initialMap.get("t3").add("t2");
	        initialMap.get("t3").add("t4");
	        initialMap.get("t4").add("t2");
	        initialMap.get("t4").add("t5");
	        initialMap.get("t5").add(null);
	        initialMap.get("t6").add("t5");
	        
	        String independentKey = "";
	        for (Map.Entry<String, ArrayList<String>> entry : initialMap.entrySet()) {
	            String mapKey = entry.getKey();
	            List value = entry.getValue(); // t2 and t3
	            Iterator<String> itr = value.iterator();
	            if (value == null) {
	                independentKey = mapKey; // t5
	            } else {
	                while(itr.hasNext()) {
	                String key = itr.next();
	                if (reverseMap.containsKey(key)) {
	                    reverseMap.get(key).add(mapKey);
	                } else {
	                    reverseMap.put(key, new ArrayList<String>());
	                    reverseMap.get(key).add(mapKey);
	                }
	                System.out.println(key + " " + mapKey);
	            }
	            }
	            
	        }
	        
	        List<String> remaining = new ArrayList<String>();
	        remaining.add("t5");
	        int i = 0;
	        while (i < remaining.size()) {
	            String key = remaining.get(i);
	            i++;
	            System.out.println(independentKey);
	            if (reverseMap.containsKey(key)) {
	                List<String> dependentOn = reverseMap.get(key); // t6
	                reverseMap.remove(key);
	                remaining.addAll(dependentOn);
	            }
	        }
	        
	        System.out.println(remaining);
	        
	    }
}
