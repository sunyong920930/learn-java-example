package lean.java.example.arithmetic;

/**
 * @author sunyong
 * 2020/3/16 09:54
 * 链表翻转  1->2->3->4   ==> 4->3->2->1
 */
public class ReverseList {

    //递归
    public static Node reverseNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = head.next;
        Node node = reverseNode(newHead);
        newHead.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node = reverseNode(node1);
        System.out.println(node.value);
        System.out.println(node.next.value);
        System.out.println(node.next.next.value);
        System.out.println(node.next.next.next.value);
    }

    /**
     * 单链表节点
     */
    public static class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
}
