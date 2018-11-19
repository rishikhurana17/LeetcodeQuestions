package LeetcodePrograms;

//get the compliment of a number
//50 stands for 110010 and complement of that is 001101 which is 13
public class integerComplement {
	public static int getIntegerComplement(int n) {
		int i = 0, temp[] = new int[25];
		int j;
		StringBuffer toBinary = new StringBuffer();
		while (n > 0) {
			temp[i++] = n % 2;
			n = n / 2;
		}
		for (j = i - 1, i = 0; j >= 0; j--, i++) {
			toBinary.append(String.valueOf(temp[j]));
			// bin[i++] = String.valueOf(temp[j]);
		}
		System.out.println("to Binary is  " + toBinary);
		String compl = "";
		int tempNo = 0;
		for (int x = 0; x < toBinary.length(); x++) {
			tempNo = Integer.parseInt(Character.toString(toBinary.charAt(x)));
			if (tempNo == 0) {
				tempNo = 1;
			} else {
				tempNo = 0;
			}
			compl = compl.concat(String.valueOf(tempNo));

		}
		System.out.println("complement is " + compl);
		return Integer.parseInt(compl, 2);
	}

	public static int findComplement(int num) {
		int i = 0;
		int j = 0;
		while (i < num) {
			i += Math.pow(2, j);
			j++;
		}
		return i - num;
	}

	public static void main(String[] args) {
		System.out.println(findComplement(10));
	}
}
