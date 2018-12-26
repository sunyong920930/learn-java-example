package lean.java.example.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sunyong
 * @Date 2018-12-26 14:18
 * <p>
 * 题目：调整数组顺序使奇数位于偶数前面
 * 题目详述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 题目详解：题目明确说了，不能修改相对位置，所以只能是用以下的新建两个数组，一个奇数数组，一个偶数数组，然后把奇数和偶数分别保存到对应的数组，然后在赋值到原数组中
 **/
public class Solution3 {

    public static int[] reOrderArray(int[] array) {
        // 奇数数组
        List<Integer> oddArray = new ArrayList<>();
        // 偶数数组
        List<Integer> evenArray = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) { // 偶数
                evenArray.add(array[i]);
            } else { // 奇数
                oddArray.add(array[i]);
            }
        }

        for (int i = 0; i < oddArray.size(); i++) {
            array[i] = oddArray.get(i);
        }

        //奇数在前，那么偶数的起始位置是在奇数的后面
        for (int i = 0; i < evenArray.size(); i++) {
            array[oddArray.size() + i] = evenArray.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 7, 6, 9, 8};
        int[] reOrderArray = reOrderArray(array);
        for (int i : reOrderArray) {
            System.out.print(i + " ");
        }
    }
}
