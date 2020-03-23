package cn.sxt.array2;

import java.util.Arrays;

/**
 * 测试二分法查找（折半检索）
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {30,20,50,10,80,9,7,12,100,40,8};
        System.out.println(binarySearch(arr,100));
    }

    public static int binarySearch(int[] a, int value) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int mid = (height + low) / 2;
            if (value == a[mid]) {
                return mid;
            }
            if (value>a[mid]){
                low = mid+1;
            }
            if (value < a[mid]) {
                height = mid - 1;
            }
        }
        return -1;
    }
}
