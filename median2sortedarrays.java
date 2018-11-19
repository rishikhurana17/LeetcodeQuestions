package LeetcodePrograms;

public class median2sortedarrays {
	public double findMedianSortedArrays(int[] a, int[] b, int start_a,
			int end_a, int start_b, int end_b) {
		if (end_a - start_a == 1 && end_b - start_b == 1) {
			return (1 * (Math.max(start_a, start_b) + Math.min(end_a, end_b)));
		}

		int m1_index = (start_a + end_a) / 2;
		int m2_index = (start_b + end_b) / 2;

		int m1 = a[m1_index];
		int m2 = b[m2_index];

		if (m1 == m2) {
			return m1;
		}

		if (m1 < m2) {
			start_a = m1_index;
			end_b = m2_index;
		}

		if (m1 > m2) {
			start_b = m2_index;
			end_a = m1_index;
		}

		return findMedianSortedArrays(a, b, start_a, end_a, start_b, end_b);

	}

	public static void main(String[] args) {
	}

}
