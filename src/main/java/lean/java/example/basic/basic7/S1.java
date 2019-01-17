package lean.java.example.basic.basic7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunyong on 2019/1/15.
 */
public class S1 {

    public static boolean twoSum(int[] arr, int target) {
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (index + arr[j] == target) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean twoSum1(int[] arr, int target) {
        boolean flag = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], arr[i]);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int i = target - entry.getValue();
            if (map.containsKey(i)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
//        System.out.println(arr.length);
//        boolean b = twoSum(arr, 16);
//        System.out.println(b);
        boolean b1 = twoSum1(arr, 16);
        System.out.println(b1);
    }
}
