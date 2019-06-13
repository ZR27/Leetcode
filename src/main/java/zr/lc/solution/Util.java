package zr.lc.solution;

import com.fishercoder.common.classes.ListNode;

public class Util
{
    static public ListNode reverse(ListNode n)
    {
        ListNode re = null;
        ListNode head = n;
        while(head != null)
        {
            ListNode newHead = head.next;
            head.next = re;
            re = head;
            head = newHead;
        }
        return re;
    }

    static public ListNode reverse(ListNode cur, ListNode pre)
    {
        ListNode head = cur.next == null ? cur : reverse(cur.next, cur);

        cur.next = pre;

        return head;
    }

    static public void main(String[] a)
    {
        ListNode head = new ListNode(0);
        ListNode n = head;
        for(int i = 1; i<10; i++, n = n.next)
            n.next = new ListNode(i);

        print(head);
        //print(reverse(head));
        print(reverse(head, null));
    }

    static public void print(ListNode n)
    {
        while(n != null)
        {
            System.out.print(n.val + ",");
            n = n.next;
        }
        System.out.print("\n");


    }

}
