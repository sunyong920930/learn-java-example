package lean.java.example.arithmetic;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author sunyong
 * 2020/3/17 15:17
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大值k
 * // 输入: nums = [1,0,1,1], k = 1
 * //输出: true
 * // 输入: nums = [1,2,3,1,2,3], k = 2
 * //输出: false
 */
public class ArrayTest {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0;i < nums.length;i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
