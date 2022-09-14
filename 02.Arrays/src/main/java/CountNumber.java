package main.java;

import java.util.*;

public class CountNumber {

    public static void main(String[] args) {


        int[] arr = {2,9,7,32,45,9,2,7,8,45,36};
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (nums.contains(arr[i]))
                continue;
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }

            }
            System.out.println("The int " + arr[i] + " is repeated " + count + " times.");
            nums.add(arr[i]);
        }
    }
}
