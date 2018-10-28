package leetcode;

/**
 * Created by rkhurana on 10/25/18.
 */
public class MultiplyString {
    public static String multiply(String a, String b) {

        StringBuilder sb = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
        int sum = carry;
//			if (j >= 0)
//				sum += b.charAt(j--) - '0';
        // '0' is for converting the char to its actual int value, otherwise the returned int is its ascii value
//			if (i >= 0)
        sum += (a.charAt(i--) - '0') * (b.charAt(j--) - '0');
        sb.append(sum % 10);
        carry = sum / 10;
    }
		if (carry != 0)
            sb.append(carry);
		return sb.reverse().toString();

    }
    public static void main(String []args){
        System.out.println(multiply("9","99"));
    }
}
