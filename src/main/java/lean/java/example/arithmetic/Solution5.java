package lean.java.example.arithmetic;

/**
 * @Author sunyong
 * @Date 2018-12-27 15:40
 * 题目：反转链表
 * 1->2->3->4->5->6 => 1<-2<-3<-4<-5<-6
 **/
public class Solution5 {

    /**
     * 通过递归方法
     * 我们来看是怎样的一个递归过程：1->2->3->4
     * <p>
     * 程序到达Node newHead = reverse(head.next);时进入递归
     * 我们假设此时递归到了3结点，此时head=3结点，temp=3结点.next(实际上是4结点)
     * 执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点。
     * 接下来就是弹栈过程了
     * 程序继续执行 temp.next = head就相当于4->3
     * head.next = null 即把3结点指向4结点的指针断掉。
     * 返回新链表的头结点newHead
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        //定义6个节点
        ListNode head = new ListNode(1);
        ListNode sencod = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fouth = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        head.next = sencod;
        sencod.next = third;
        third.next = fouth;
        fouth.next = five;
        five.next = six;

        ListNode node = reverse(head);
        System.out.println(node.val);
        System.out.println(node.next.val);
        System.out.println(node.next.next.val);
        System.out.println(node.next.next.next.val);
        System.out.println(node.next.next.next.next.val);
        System.out.println(node.next.next.next.next.next.val);
    }
}

