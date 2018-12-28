package lean.java.example.arithmetic;

/**
 * @Author sunyong
 * @Date 2018-12-28 11:10
 * 冒泡排序
 * 冒泡排序只会操作相邻两个数据，每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
 * 如果不满足就让它两互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作
 **/
public class Solution6 {

    // a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 外层循环次数
        for (int i = 0; i < n; i++) {
            // 记录冒泡循环退出标识
            boolean flag = false;
            // 内层循环遍历比较 从小到大排序
            //
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {// 需要交换的数据
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        int n = a.length;
        bubbleSort(a, n);
    }

}
