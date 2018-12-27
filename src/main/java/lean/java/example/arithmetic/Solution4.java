package lean.java.example.arithmetic;

/**
 * @Author sunyong
 * @Date 2018-12-27 14:34
 * 题目：链表中倒数第k个结点
 **/
public class Solution4 {

    /**
     * 为了得到第k个节点，很自然的想到先走到链表的尾端，然后再从尾端走k步，如果是单链表的话是行不通的，单链表是单向的
     * 既然不能从尾节点开始遍历这个链表，那只能从头节点开始遍历。假设整个链表有N个节点，那么倒数第k个节点就是从头部开始的第n-k+1个节点，如何得到n，只需从头开始遍历，使用计数器加1即可。
     * 循环遍历1次，开始时，两个指针都是指向头节点，当第一个指针走向k-1步时，第二个指针开始遍历，然后两个指针一直遍历下去，当第一个指针的下一个节点为null时，表示已经是尾节点了，
     * 此时第二个指针刚好走到k的位置，那么此时就可以得到k的节点。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            length++;//这里计算链表的长度
            tempHead = tempHead.next;
        }
        if (k > length || k <= 0)//因为倒数第K个节点，如果超过链表长度可不行呀
            return null;
        /** 上面的循环是为了判断k的规则*/
        //定义两个指针都指向头节点
        ListNode before = head;
        ListNode after = head;
        // 表示第一个几点走到k-1的位置
        for (int i = 0; i < k - 1; i++) {
            before = before.next;
        }
        while (before.next != null) {
            before = before.next;
            after = after.next;//快慢指针一起走。
        }
        return after;
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

        ListNode node = findKthToTail(head, 3);
        System.out.println(node.val);
    }

}

/**
 * 定义链表节点
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
