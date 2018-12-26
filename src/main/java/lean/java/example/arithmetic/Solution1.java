package lean.java.example.arithmetic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * 思路：
 * 使用一个大小为K的最大堆，然后堆里面最大的数是堆顶，然后每次比较堆顶的数和数组中的数，
 * 如果堆顶的数比数组中的数A大，那么就把堆顶的数弹出来，把数组中的数A进堆，这样子到最后堆里面的堆顶始终是比外面的数小，
 * 而堆里的其他数是小于堆顶的数（最大堆的性质），所以堆中的数就是最小的k个数
 */
public class Solution1 {

    public static ArrayList<Integer> getLeastNumbers_solution(int[] input, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return resultList;
        }

        // PriorityQueue: 使用优先级队列建堆，优先级队列默认是最小堆，所以要重写比较器
        // 一个基于优先级堆 queue无界优先级。优先级队列的元素进行排序,一个基于优先级堆 queue无界优先级。优先级队列的元素进行排序。一个优先队列不允许 null元素。依靠自然排序的优先级队列也不允许插入不可比较的对象（这样做可能导致 ClassCastException）。
        // 此队列的头相对于指定的排序是最小的元素。如果多个元素被绑定为最小值，头部是这些元素的一个，关系被任意地打破。队列检索操作poll，remove，peek，和element访问在队列的头元素。
        // 一个优先队列是无界的，但有一个内部容量管理用于存储在队列中的元素的数组的大小。它总是至少和队列大小一样大。当元素被添加到优先级队列中时，它的容量会自动增长。未指定增长策略的细节。
        // 这个类和它的迭代器实现所有的可选方法的Collection和Iterator接口。方法iterator()提供的迭代器不能保证遍历优先级队列的元素在任何特定的顺序。如果你需要有序遍历，考虑使用Arrays.sort(pq.toArray())。
        // 请注意，此实现不同步。多线程不能访问PriorityQueue实例同时如果线程修改队列。相反，使用线程安全类PriorityBlockingQueue。
        // 队列的实现不是同步的。不是线程安全的。如果多个线程中的任意线程从结构上修改了列表， 则这些线程不应同时访问 PriorityQueue实例。保证线程安全可以使用PriorityBlockingQueue 类
        // 不允许使用 null 元素。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) { // 如果没有达到k个数，直接入队列
                maxHeap.add(input[i]);
            } else {
                if (maxHeap.peek() > input[i]) {// 堆顶的数比数组当前的数大，那么堆顶就出堆
                    maxHeap.poll();
                    maxHeap.add(input[i]);// 把当前数加入堆中
                }
            }
        }
        while (!maxHeap.isEmpty()) {
            resultList.add(maxHeap.poll());//把堆中的数出堆添加到结果数组中
        }
        return resultList;
    }

    public static void main(String[] args) {
//        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
//        int k = 3;
//        ArrayList<Integer> arrayList = getLeastNumbers_solution(input, k);
//        for (Integer i : arrayList) {
//            System.out.println(i);
//        }


        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(6);
        // 1、默认是最小堆，可以自定义实现比较器 ,自定义实现比较器后 取出的是最大值6
        // 2、poll() 是将堆顶元素取出，堆大小减1，并可以拿到取出的元素
//        Integer poll = queue.poll();
//        System.out.println(poll + "===,size:" + queue.size());
        // peek()取出堆顶元素，堆大小不变，并可以拿到取出的元素
//        Integer peek = queue.peek();
//        System.out.println(peek + "===,size:" + queue.size());

        // offer(),向堆内添加元素，堆自己会进行排序功能，返回的是boolean值
//        boolean b = queue.offer(9);
//        Integer peek = queue.peek();
//        System.out.println(b + "===,peek:" + peek+"==,size:" + queue.size());

        // remove() 取出堆顶元素，并返回值，堆大小减1
//        Integer i = queue.remove();
//        System.out.println(i + "===size:" + queue.size());

        // remove(E e) 取出指定的元素，有值返回true堆大小减小，无值返回false，堆大小不变
//        boolean b = queue.remove(4);
//        System.out.println(b + "===,size:" + queue.size());//true===,size:3
//
//        boolean b1 = queue.remove(99);
//        System.out.println(b1 + "===,size:" + queue.size());//false===,size:3
    }
}
