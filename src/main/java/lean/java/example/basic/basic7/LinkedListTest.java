package lean.java.example.basic.basic7;

import java.util.LinkedList;

/**
 * Created by sunyong on 2019/1/15.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        for (String str : linkedList) {
            System.out.println(str);
        }
//        String peek = linkedList.peek();
//        System.out.println("========");
//        System.out.println(peek);
//        System.out.println("========");
//        for (String str : linkedList) {
//            System.out.println(str);
//        }
        System.out.println("========");
//        String poll = linkedList.poll();
//        System.out.println(poll);
//        System.out.println("========");
//        for (String str : linkedList) {
//            System.out.println(str);
//        }
        String s = linkedList.pollLast();
        System.out.println(s);
        System.out.println("========");
        for (String str : linkedList) {
            System.out.println(str);
        }

    }
}
