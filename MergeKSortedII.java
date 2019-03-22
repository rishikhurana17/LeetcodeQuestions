package LeetcodePrograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkhurana on 3/21/19.
 */
public class MergeKSortedII {
    public ListNode mergeKLists(ListNode[] lists) {
        // corner case
        if(lists == null || lists.length == 0) return null;

        ListNode head = merge(lists, 0, lists.length - 1);
        return head;
    }

    // return new head after merging list[left : right]
    public ListNode merge(ListNode[] lists, int left, int right){
        // base case
        if(left == right) return lists[left];

        int mid = left + (right - left)/2;
        ListNode l1 = merge(lists, left, mid); // merge [left : mid]
        ListNode l2 = merge(lists, mid + 1, right); // merge [mid + 1 : right]

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            if(cur1 == null){
                cur.next = cur2;
                break;
            }else if(cur2 == null){
                cur.next = cur1;
                break;
            }else{
                if(cur1.val <= cur2.val){
                    cur.next = cur1;
                    cur1 = cur1.next;
                }else{
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }

        }

        return dummy.next;
    }
    public static void main(String [] args){
// n = 6 -> 12 -> 14
// m = 2 -> 8 -> 15
// o = 1 -> 8 -> 10
// p = 3 -> 13 -> 19
        MergeKSortedII x = new MergeKSortedII();
        ListNode n =new ListNode();

//        n.newNode(1);
        n = n.newNode(6);
        n.next=n.newNode(12);
        n.next.next = n.newNode(14);

        ListNode m = new ListNode();
        m=m.newNode(2);
        m.next = m.newNode(8);
        m.next.next = m.newNode(15);

        ListNode o = new ListNode();
        o = o.newNode(1);
        o.next=o.newNode(8);
        o.next.next =o.newNode(10);

        ListNode p = new ListNode();
        p= p.newNode(3);
        p.next=p.newNode(13);
        p.next.next =p.newNode(19);

        ListNode [] lists = {n,m,o,p};
//        lists.add(n);
//        lists.add(m);
//        lists.add(o);
        System.out.println(x.mergeKLists(lists));
    }
}
