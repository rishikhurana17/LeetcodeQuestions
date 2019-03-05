package LeetcodePrograms;

public class Excel {
	public int titletoNum(String s) {
		int value = 0;
		int power = 0;
		if (s == null || s.length() == 0)// if empty or null
			return -1;

		for (int i = s.length() - 1; i >= 0; i--) {
			value = value + ((int) Math.pow(26, power))* ((int) s.charAt(i) - 64);
			power++;
		}
		return value;
	}

	public int titletoNum2(String s) {
		int result = 0;
		for(int i = 0 ; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}


	public static void main(String[] args) {
		Excel ex = new Excel();

		System.out.println(ex.titletoNum("AA"));
	}
}
