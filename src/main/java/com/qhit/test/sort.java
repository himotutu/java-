package com.qhit.test;

import java.util.Arrays;

public class sort {

    /*
    冒泡排序
    外层循环：需要进行比较的元素
    n-1
    内层循环：对m个元素进行比较
     */
    public static void main(String[] args) {
        int[] arr = {78,3,45,12,36,19,90,34};
        sort2(arr);

    }

    private static void sort2(int[] arr) {
        for(int i =0;i<arr.length;i++){
            boolean flag = true;
            for (int j = 0; j <arr.length-1-i; j++) {
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }

            if(flag){
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void sort1(int[] arr) {
        for (int i = arr.length-2; i >=1 ; i--) {
            for(int j=0;j<=i;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
