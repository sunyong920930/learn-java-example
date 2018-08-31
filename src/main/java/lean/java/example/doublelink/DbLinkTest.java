package lean.java.example.doublelink;

/**
 * Created by sunyong on 2018-08-31.
 */
public class DbLinkTest {

    private static void int_test() {

        System.out.println("\n----int_test----");

        // 创建双向链表
        DbLink<Integer> dbLink = new DbLink<>();
        dbLink.insert(0, 20);    // 将 20 插入到第一个位置
        dbLink.appendLast(10);    // 将 10 追加到链表末尾
        dbLink.insertFirst(30);    // 将 30 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dbLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", dbLink.size());

        // 打印出全部的节点
        for (int i = 0; i < dbLink.size(); i++)
            System.out.println("dlink(" + i + ")=" + dbLink.get(i));
    }

    public static void main(String[] args) {
        int_test();
    }

    private static void string_test() {
        String[] sarr = {"ten", "twenty", "thirty", "forty"};

        System.out.println("\n----string_test----");
        // 创建双向链表
        DbLink<String> dlink = new DbLink<String>();

        dlink.insert(0, sarr[1]);    // 将 sarr中第2个元素 插入到第一个位置
        dlink.appendLast(sarr[0]);    // 将 sarr中第1个元素 追加到链表末尾
        dlink.insertFirst(sarr[2]);    // 将 sarr中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());

        // 打印出全部的节点
        for (int i = 0; i < dlink.size(); i++)
            System.out.println("dlink(" + i + ")=" + dlink.get(i));
    }

    private static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static DbLinkTest.Student[] students = new DbLinkTest.Student[]{
            new DbLinkTest.Student(10, "sky"),
            new DbLinkTest.Student(20, "jody"),
            new DbLinkTest.Student(30, "vic"),
            new DbLinkTest.Student(40, "dan"),
    };

    private static void object_test() {
        System.out.println("\n----object_test----");
        // 创建双向链表
        DbLink<DbLinkTest.Student> dlink = new DbLink<>();

        dlink.insert(0, students[1]);    // 将 students中第2个元素 插入到第一个位置
        dlink.appendLast(students[0]);    // 将 students中第1个元素 追加到链表末尾
        dlink.insertFirst(students[2]);    // 将 students中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());

        // 打印出全部的节点
        for (int i = 0; i < dlink.size(); i++) {
            System.out.println("dlink(" + i + ")=" + dlink.get(i));
        }
    }
}
