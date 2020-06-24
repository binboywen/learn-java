package BinZi;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class test {

    public static void main(String [] args){
        ListNode left1 = new ListNode(1);
        ListNode left2 = new ListNode(3);
        left1.next = left2;
        ListNode left3 = new ListNode(6);
        left2.next = left3;

        ListNode right1 = new ListNode(2);
        ListNode right2 = new ListNode(4);
        right1.next = right2;
        ListNode right3 = new ListNode(5);
        right2.next = right3;
        ListNode right4 = new ListNode(8);
        right3.next = right4;
        ListNode result = mergeTwoLists2(left1, right1);


        //ListNode res = mergeTwoLists(left1, left2);
        //res.toString();
    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = result;
        while(p != null || q != null){
            if(p == null){
                curr.next = new ListNode(q.val);
                curr = curr.next;
                if(q != null) q = q.next;
            }
            if(q == null){
                curr.next = new ListNode(p.val);
                curr = curr.next;
                if(p != null) p = p.next;
            }
            if(p != null &&  q!= null){
                if(p.val < q.val){
                    curr.next = new ListNode(p.val);
                    curr = curr.next;
                    if(p!= null) p = p.next;
                }
                else{
                    curr.next = new ListNode(q.val);
                    curr = curr.next;
                    if(q!= null){
                        q = q.next;
                    }
                }
            }
        }
        return result.next;
    }
}
