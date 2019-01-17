package lean.java.example.basic.basic7;

import java.util.*;

/**
 * Created by sunyong on 2019/1/15.
 */
public class S2 {

    public static void main(String[] args) {
        Integer[] arr = {2, 4, -1, 5, 9, 0};
        Integer[] arr1 = sort(arr);
        System.out.println(arr1);
    }

    private static Integer[] sort(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return arr;
    }

}
