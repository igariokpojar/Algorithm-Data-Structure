import java.util.Arrays;
import java.util.LinkedList;


public class Tests {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 0, 7};

        System.out.println(Arrays.toString(arr));


        moveZeros(arr);
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;

        if (n == 0 || n == 1) {
            return;
        }
        int right = 0, left = 0;
        int temp;
        while (right < n) {
            if (nums[right] == 0) {
                ++right;
            } else {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++right;
                ++left;
            }
        }
    }


    public static void moveZeros(int[] num) {
        int n = num.length;
        if (n < 2) return;
        // define pointers
        int p1 = 0, p2 = 1;
        // move zeros to the back
        while (p2 < n) {
            if (num[p1] != 0) {
                p1++; p2++;
            } else if (num[p2] == 0) {
                p2++;
            } else {
                int temp = num[p2];
                num[p2] = num[p1];
                num[p1] = temp;

            }
        }
    }
}