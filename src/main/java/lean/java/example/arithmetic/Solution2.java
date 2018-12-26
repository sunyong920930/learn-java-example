package lean.java.example.arithmetic;

/**
 * 题目：连续子数组的最大和
 * <p>
 * 大体思路就是用一个tempmax代表前面的连续数字的最大和，如果这个最大和是正的，
 * 那么加上数组的当前数字，那么这个连续的和是变大的，这个就是有可能的潜在的最大和。
 * 思路：假设第一个是真实最大值，当前最大值是0，用当前最大值与第一个数相加与第一个数进行比较，如果大于，则相加赋值给当前最大值，不是则将第一个数赋值给当前最大值，
 * 然后用真实最大值与当前最大值进行比较，以此类推。。。
 */
public class Solution2 {

    public static int findGreatestSumOfSubArray(int[] array) {

        if (array.length <= 0) {
            return -1;
        }

        int realMax = array[0];
        // 当前最大值
        int currentMax = 0;

        for (int i = 0; i < array.length; i++) {
            //当前最大值加上当前数组的数如果比数组当前这个数大，那么就累加
            if (currentMax + array[i] >= array[i]) {
                //这里得好好体会，因为前面连续和大于0，所以加上当前数连续和肯定变大！所以是可能的最大连续和
                currentMax += array[i];
            } else {//如果当前连续最大和小于0，那么就把currentMax赋值为当前这个数组中的数，重新开始
                currentMax = array[i];
            }
            // 每计算出一个当前最大连续和就和最后的要返回结果进行比较
            if (currentMax > realMax) {
                realMax = currentMax; // 更新
            }
        }
        return realMax;
    }

    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        int sum = findGreatestSumOfSubArray(array);
        System.out.println(sum);
    }
}
