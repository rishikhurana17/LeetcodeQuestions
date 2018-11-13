package leetcode;

public class ListNode {

	public ListNode next;
	int val;

	ListNode(int x) {
		val = x;
	}
	ListNode(){}

	public ListNode newNode(int i) {
		ListNode x = new ListNode();
		x.val = i;
		return x;

	}
}
