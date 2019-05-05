package com.qhit.test;

import javax.swing.table.AbstractTableModel;

/**
 * Created by lenovo on 2019/4/27.
 * 已知一个二维数组，如下图，求某个数字出现在第几行，第几列？
 */
public class demo5 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5,6,7,8,9},
                    {11,12,13,14,15,16,17,18,19},
                    {21,22,23,24,25,26,27,28,29},
                    {31,32,33,34,35,36,37,38,39},
                    {41,42,43,44,45,46,47,48,49},
                    {51,52,53,54,55,56,57,58,59}};
        int num = 42;
        find2(arr,num);
    }

    private static void find(int[][] arr,int num){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]==num){
                    System.out.println("出现第"+(i+1)+"行,第"+(j+1)+"列");
                }
            }
        }
    }

    private static void find2(int[][] arr,int num){
        for (int i = 0; i < arr.length; i++) {
            if (num>=arr[i][0] && num<=arr[i][arr[i].length-1]){
                int j = Demo3.findByHalf(arr[i],num);
                System.out.println("出现第"+(i+1)+"行,第"+(j+1)+"列");
            }
        }
    }
}