package com.qhit.test;

import java.util.Arrays;

public class sort2 {

    /*
    选择排序：每次循环找出一个最值，放在左边
        第1次循环 确定第0位是最值
        第2次循环 确定1位是最值
        第n-1次循环 确定n-2位是最值
    外层循环：0~length-2  最值下标
    内层循环：从最值下标的下一位开始，一直到最后一个元素，与最值下标进行比较
    比较：最值下标与后面的每一个元素进行比较

    选择排序：每次循环找出一个最值，放在右边
        第1次循环 确定第length-1位是最值
        第2次循环 确定length-2位是最值
        .....
        第?次循环 确定2位是最值
    外层循环：length-1~1  最值下标
    内层循环：从最值下标的上一位开始，一直到第一个元素，与最值下标进行比较
    比较：最值下标与后面的每一个元素进行比较
     */
    public static void main(String[] args) {
        Integer[] arr = {78,3,45,null,12,36,19,90,34,46};
        sort3(arr);
    }

    private static void sort4(int[] arr) {
        for (int i = arr.length-1; i >=1 ; i--) {
            for (int j = 0; j <i ; j++) {
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void sort3(Integer[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]!=null && arr[j]!=null && arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
