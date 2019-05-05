package com.qhit.test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lenovo on 2019/4/27.
 * 已知一个长度为n的数组，其中只有一个数字出现了奇数次，其他均出现了偶数次，如何查找出来
 */
public class demo4 {
    //方法一：字符串拆分 split length-1
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,4,6,1,12,1,5,12};
        int num = find(arr);
        System.out.println(num);

    }

    private static int find3(int[] arr){
        Arrays.sort(arr);
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==arr[i+1]){
                flag=!flag;
            }else {
                if (!flag){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    private static int find2(int[] arr){
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i : arr){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        //便利map
        for (Integer key:map.keySet()){
            if (map.get(key)%2==1){

            }
        }
        return -1;
    }

    private static int find(int[] arr){
        String str = ",";
        for (int i : arr) {
            str += i+",";
        }
        str+=",";
        for (int i : arr){
            int count = str.split(i+",").length-1;
            if (count%2==1){
                System.out.println(i);
                break;
            }
        }
        return -1;
    }
}
