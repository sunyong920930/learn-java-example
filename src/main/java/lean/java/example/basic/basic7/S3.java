package lean.java.example.basic.basic7;

/**
 * Created by sunyong on 2019/1/15.
 */
public class S3 {

    public static boolean ss(int[] arr, int k, int target) {
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index = arr[i];
            for (int j = i + 1; j < arr.length && j - i <= k; j++) {
                if (index + arr[j] == target) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 11};
        int k = 3;
        int target = 12;
        boolean ss = ss(arr, k, target);
        System.out.println(ss);
    }
}
