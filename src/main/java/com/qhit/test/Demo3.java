package com.qhit.test;

public class Demo3 {

    /*
    最快：1 最慢：n
    二分：1 最慢：log2n次



     */

    public static void main(String[] args) {
        int[] arr = {4,6,9,18,23,36,70,88};
        int num = 100;
        int index = findByHalf(arr,num);
        System.out.println(index);
    }

    public static int findByHalf(int[] arr, int num) {
        int start = 0;
        int end = arr.length-1;
        int middle = -1;
        if(num==arr[0]){
            return 0;
        }else if(num==arr[arr.length-1]){
            return arr.length-1;
        }
        while(start<end-1){
            middle = (start+end)/2;
            if(arr[middle]==num){
                return middle;
            }else if(arr[middle]<num){
                start=middle;
            }else{
                end=middle;
            }
        }
        return -1;
    }

}
