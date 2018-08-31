package lean.java.example.doublelink;

/**
 * Created by sunyong on 2018-08-31.
 */
public class DbLink<T> {

    /**
     * 定义表头结点
     */
    private DNode<T> mHead;

    /**
     * 节点个数
     */
    private int mCount;

    // 双向链表“节点”对应的结构体
    private class DNode<T> {

        private DNode prev;
        private DNode next;
        private T value;

        public DNode(T value, DNode prev, DNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 双向链表构造函数
     */
    public DbLink() {
        // 创建“表头”。注意：表头没有存储数据！
        mHead = new DNode<>(null, null, null);
        mHead.prev = mHead.next = mHead;
        // 初始化“节点个数”为0
        mCount = 0;
    }

    /**
     * 返回节点个数
     *
     * @return
     */
    public int size() {
        return mCount;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return mCount == 0;
    }


    /**
     * 返回第index节点的位置
     *
     * @param index
     * @return
     */
    public DNode<T> getNode(int index) {

        if (index < 0 || index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        // 正向查找
        if (index < mCount / 2) {
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        // 反向查找
        DNode node = mHead.prev;
        int rindex = mCount - index - 1;
        for (int j = 0; j < rindex; j++) {
            node = mHead.prev;
        }
        return node;
    }

    /**
     * 获取第index位置节点的值
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * 获取第一个节点的值
     *
     * @return
     */
    public T getFirst() {
        return getNode(0).value;
    }

    /**
     * 获取最后一个节点的值
     *
     * @return
     */
    public T getLast() {
        return getNode(mCount - 1).value;
    }

    /**
     * 将节点插入第index位置之前
     *
     * @param index
     * @param t
     */
    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> dNode = new DNode<>(t, mHead, mHead.next);
            mHead.next.prev = dNode;
            mHead.next = dNode;
            mCount++;
            return;
        }
        // 获取指定位置的节点
        DNode<T> iNode = getNode(index);
        DNode<T> tdNode = new DNode<>(t, iNode.prev, iNode);
        iNode.next.prev = tdNode;
        iNode.next = tdNode;
        mCount++;
        return;
    }

    /**
     * 将节点插入第一个节点处
     *
     * @param t
     */
    public void insertFirst(T t) {
        insert(0, t);
    }


    /**
     * 将节点加入链表末尾
     *
     * @param t
     */
    public void appendLast(T t) {
        DNode<T> tdNode = new DNode<>(t, mHead.prev, mHead);
        mHead.prev.next = tdNode;
        mHead.next = tdNode;
        mCount++;
        return;
    }

    /**
     * 删除指定位置的节点
     *
     * @param index
     */
    public void del(int index) {
        DNode<T> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        mCount--;
    }

    /**
     * 删除第一个节点
     */
    public void deleteFirst() {
        del(0);
    }

    /**
     * 删除最后一个节点
     */
    public void deleteLast() {
        del(mCount - 1);
    }
}
