package com.qhit.test;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/27.
 * 插入排序
 */
public class sort3 {
    public static void main(String[] args) {
        int[] arr = {20,30,2,34,22,6,18};
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j]<=arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
