package cn.sxt.array2;

import java.util.Arrays;

/**
 * 测试冒泡排序
 * @author weiwei
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {3, 1, 6, 2, 9, 0, 7, 4, 5, 8};
        System.out.println(values.length);
        for (int i = values.length; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(values));
    }
}
