package com.wewe.algorithmExam.sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Author: fei2
 * Date:  18-10-8 下午2:07
 * Description:正式的通排序
 * Refer To:http://www.cnblogs.com/dailc/archive/2016/12/03/6128823.html
 */
public class OfficialBucketSort {

    public static void main(String[] args) {

        int bucketCount = 10;
        double[] arr = {1,3,4,4,2,5,99,3,5,7,34,23,56};
        //开始排序,其中arr为需要排序的数组：bucketCount 每一个桶的大小
        double[] result = bucketSort(arr,bucketCount);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }


    public static double[] bucketSort(double arr[], int bucketCount) {

        int len = arr.length;
        double[] result = new double[len];
        double min = arr[0];
        double max = arr[0];
        //找到最大值和最小值
        for (int i = 1; i < len; i++) {
            min = min <= arr[i] ? min: arr[i];
            max = max >= arr[i] ? max: arr[i];
        }
        //求出每一个桶的数值范围
        double space = (max - min + 1) / bucketCount;
        //先创建好每一个桶的空间,这里使用了泛型数组
        ArrayList< Double >[] arrList = new ArrayList[bucketCount];
        //把arr中的数均匀的的分布到[0,1)上，每个桶是一个list，存放落在此桶上的元素
        for (int i = 0; i < len; i++) {
            int index = (int) Math.floor((arr[i] - min) / space);
            if (arrList[index] == null) {
                //如果链表里没有东西
                arrList[index] = new ArrayList < Double > ();
                arrList[index].add(arr[i]);
            } else {
                //排序 快速排序
                int k = arrList[index].size() - 1;
                while (k >= 0 && (Double) arrList[index].get(k) > arr[i]) {
                    if (k + 1 > arrList[index].size() - 1) {
                        arrList[index].add(arrList[index].get(k));
                    } else {
                        arrList[index].set(k + 1, arrList[index].get(k));
                    }
                    k--;
                }
                if (k + 1 > arrList[index].size() - 1) {
                    arrList[index].add(arr[i]);
                } else {
                    arrList[index].set(k + 1, arr[i]);
                }
            }

        }

        //把各个桶的排序结果合并  ,count是当前的数组下标
        int count = 0;

        for (int i = 0; i < bucketCount; i++) {
            if (null != arrList[i] && arrList[i].size() > 0) {
                Iterator< Double > iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    result[count] = d;
                    count++;
                }
            }
        }
        return result;
    }

}
