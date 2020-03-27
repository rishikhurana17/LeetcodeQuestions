package LeetcodePrograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkhurana on 2/12/19.
 */
public class TextJustification2 {
    private static List<String> result;

    public static List<String> fullJustify(String[] words, int maxWidth) {
        result = new ArrayList<String>();
        if (words == null || words.length == 0 || maxWidth < 0)
            return result;
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
        helper(words, 0, maxWidth);
        return result;
    }

    public static void helper(String[] words, int start, int width) {
        if (start >= words.length) return;

        int i = start, len = 0, total = 0, next = -1;
        while (total < width && i < words.length) {
            total += words[i].length();
            if (total > width) { // only in this case we need skip i++
                next = i;
                break;
            }
            len += words[i].length();
            total++; // count space
            i++;
        }

        if (next == -1)       //when total is exactly equal to width it will come to this part
            next = i;

        addList(words, start, next, len, width);

        helper(words, next, width);
    }

    public  static void addList(String[] words, int i, int j, int len, int width) {
        StringBuilder sb = new StringBuilder("");
        int count = j-i-1, space = 0, more = 0, s = 0;
        if (count == 0 || j == words.length) { // the last line or only one word in that line
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (k == j-1)
                    break;
                sb.append(" ");
            }
            space = width - sb.length();
            s = 0;
            while (s++ < space)
                sb.append(" ");
        } else {
            space = (width - len) / count; more = (width - len) % count;
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                s = 0;
                if (k == j-1)
                    break;
                while (s++ < space) {
                    //System.out.println(s);
                    sb.append(" ");
                }
                if (more-- > 0) {
                    //System.out.println(more);
                    sb.append(" ");
                }
            }
        }

        result.add(sb.toString());
    }

    public static String textSize(String message , int maxWidth){
        String []messageArray = message.split(" ");
        List<String> strinArray= fullJustify(messageArray , maxWidth);
        String finalString =null;
        int maxlength =0 ;
        for(int i = 0 ; i < strinArray.size() ; i++){
            String str = strinArray.get(i);
            StringBuilder sb = new StringBuilder();
            int space = 0 ;
            for(int j = 0 ; j < str.length() ; j++){
                char ch = str.charAt(j);
                if(ch == ' '){
                    if(space == 0) {
                        sb.append(" ");
                        space++;
                    }
                }
                else{
                    sb.append(str.charAt(j));
                }
            }

            if(sb.toString().length() > maxlength) {
                maxlength = str.length();
                finalString = str;
            }
        }
        return finalString;
    }



}
