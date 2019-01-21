package com.wewe.algorithmExam.sort;


/**
 * Author: fei2
 * Date:  19-1-21 下午1:58
 * Description:直接插入排序
 * Refer To:
 */
public class InsertSort {



    public static void main(String[] args) {
//        directInsert();
        binaryInsert();

    }

    /**
     * 算法复杂度分析 
     * 时间复杂度（平均）   O(n^2) 外循环n次，内循环m次 m*n * 
     * 时间复杂度（最坏）   O(n^2) 外循环n次，内循环m次 m*n * 
     * 时间复杂度（最好）   O(n) ，数组已经排好序的情况，即当所有a[i] > a[i-1] 时不需要再执行内循环
     * 空间复杂度          O(1)
        https://juejin.im/post/5b4ef681f265da0f4b7a8d44
     */
    public static void directInsert(){
        int arr[] = { 5 , 2 , 6 , 0 , 9};
        System.out.println("排序前的数据：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //直接插入排序
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 折半插入排序（在已经拍好续的序列中，采用二分查找，确定插入到比较位置）
     * 每次将排序中的元素，插入到前面已经排好序的有序序列中去，直到排序完成.
     *
     * https://juejin.im/post/5b4efbc1f265da0fa42cd2b3
     * https://www.jianshu.com/p/68de9fea390e
     */
    /** * 二分插入排序，改进插入直接插入排序 
     * 在新元素插入到已序数组时，用二分法查找插入的位置 
     * 最好情况：每次插入的位置k都是已序数组的最后的位置，则无需再执行移位赋值操作 O(n*log2n) 
     * 最坏情况：每次插入的位置k都是已序数组的最前的位置，则整个已序数组需要移位赋值 O(n^2) 
     * 空间复杂度 O(1) * 稳定性 稳定 
     * 二分查找时间复杂度 O(log2n)
     */
    public static void binaryInsert(){
        int arr[] = { 5 , 2 , 6 , 0 , 9 };
        //打印排序前的数据
        System.out.println("排序前的数据：");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        //折半插入排序
        int low,high,m,temp,i,j;
        for (i = 1; i < arr.length; i++){
            //折半查找应该插入的位置
            low = 0;
            high = i -1;
            while (low <= high){
                m = (low + high)/2;
                if (arr[m] > arr[i])
                    high = m -1;
                else
                    low = m + 1;
            }
            //统一移动元素，然后将这个元素插入到正确的位置
            temp = arr[i];
            for (j = i; j > high +1; j--){
                arr[j] = arr[j-1];
            }
            arr[high + 1] = temp;
        }
        //打印排序后的数据
        System.out.println();
        System.out.println("排序后的数据：");
        for (int kk = 0; kk < arr.length; kk++) {
            System.out.print(arr[kk] + " ");
        }

    }


}
