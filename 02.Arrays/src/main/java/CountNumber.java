package main.java;

import java.util.*;

public class CountNumber {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,45,48,45,6,8,9};

        findThePairNumbers(arr,8);
        System.out.println(Arrays.toString(findThePairNumbers(arr,8)));


//        int[] arr = {2, 9, 7, 32, 45, 9, 2, 7, 8, 45, 36};
//        Set<Integer> nums = new HashSet<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            if (nums.contains(arr[i]))
//                continue;
//            int count = 1;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//
//            }
//            System.out.println("The int " + arr[i] + " is repeated " + count + " times.");
//            nums.add(arr[i]);
     //   }
    }
        public static int[] findThePairNumbers(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            Arrays.sort(arr);  // nlog(n)

            while (left < right) {  //n
                if (arr[left] + arr[right] == target)
                    return new int[]{arr[left], arr[right]};
                else if (arr[left] + arr[right] < target) {
                    left++;
                } else
                    right--;
            }
            return new int[0];
    }
}
