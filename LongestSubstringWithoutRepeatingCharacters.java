package LeetcodePrograms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by rkhurana on 7/15/18.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstringWithoutRepeatingCharacter(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength=0;
        int currentLength = 0;
        for(int i = 0; i < s.length(); i++ ){
            if(map.containsKey(s.charAt(i))){
                i=map.get(s.charAt(i));
                currentLength = 0;
                map.clear();
            }
            else{
                map.put(s.charAt(i), i);
                currentLength++;
                if(currentLength > maxLength)
                    maxLength = currentLength;
            }
        }
        return maxLength;
    }

    //below method will take O(n) complexity
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    //	can do the above same thing using ascii solution
    public int lengthOfLongestSubstring3(String s) {

        int len = s.length(),max=0;
        int [] chars = new int[128];

        for(int i=0,j=0;i<len;i++){
            j = Math.max(j,chars[s.charAt(i)]);
            max = Math.max(max,i-j+1);
            chars[s.charAt(i)]=i+1;
        }

        return max;

    }
    public int lengthOfLongestSubstring4(String s) {

        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,max = 0;

        while(i<len&&j<len){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max = Math.max(max,i-j);
            }
            else{
                set.remove(s.charAt(j++));
            }
        }
        return max;

    }

    public static void main(String [] args){
        System.out.println(longestSubstringWithoutRepeatingCharacter("abcabcbb"));
    }
}
