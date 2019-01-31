package com.wewe.algorithmExam.sort;


/**
 * Author: fei2
 * Date:  19-1-21 下午1:58
 * Description:直接插入排序
 * Refer To:
 */
public class Sort {



    public static void main(String[] args) {
        directInsert();
//        binaryInsert();
//        shellSort();
//        BubbleSort();
//        mainDemo();
//        selectSort();
    }

    /**
     * 算法复杂度分析 
     * 时间复杂度（平均）   O(n^2) 外循环n次，内循环m次 m*n * 
     * 时间复杂度（最坏）   O(n^2) 外循环n次，内循环m次 m*n * 
     * 时间复杂度（最好）   O(n) ，数组已经排好序的情况，即当所有a[i] > a[i-1] 时不需要再执行内循环
     * 空间复杂度          O(1)
        https://juejin.im/post/5b4ef681f265da0f4b7a8d44
     */
    /**
     *
        每次将排序中的元素，插入到前面已经排好序的有序序列中去，直到排序完成.
        key 和 key前一个元素(bKey)对比，如果bKey大于key，bKey后移一个到key的位置，
        然后j--；bkey的前一个元素bbKey和key比较；
        直到 j == 0，结束；将key赋值为最后一个不大于key的arr[j+1]

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
        int arr[] = { 5 , 2 , 6 , 0 , 9 ,1};
        //打印排序前的数据
        System.out.println("排序前的数据：");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        //折半插入排序 找到插入位置的high，然后统一移动元素，再将这个元素插入到正确位置
        int low,high,m,temp,i,j;
        for (i = 1; i < arr.length; i++){
            //折半查找应该插入的位置
            low = 0;
            high = i -1;
            //找到插入位置的high
            while (low <= high){
                m = (low + high)/2;
                if (arr[m] > arr[i])
                    high = m -1;
                else
                    low = m + 1;
            }
            //统一移动元素，然后将这个元素插入到正确的位置
            temp = arr[i];
            for (j = i; j > high +1; j--){ //high 为第一个小于tmep的下标
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

    //希尔排序
    /** 
     *  ShellSort 分组排序  
     * 又名缩小增量排序 
     * 将待排主序列根据人为规定的一个增量值分割成若干个子序列 
     * 对这些子序列进行插入排序，形成新的主序列， 
     * 接着缩小增量，继续对新生成的子序列进行插入排序 
     * 直到增量值为1 
     * 在这个过程中，序列变得越来越有序，而插入序列在有序的情况下效率很快 
     * 对于一个n大小的序列，如果增量为k，那么子序列为 
     * 以下为代表角标 * 0,...k,...2k,...3k...mk   mk<=n-1 
     * 1,...1+k,...1+2k,...1+3k,...1+mk 1+mk<=n-1 * . * . * . * k-1 
     * 例 a[]=[4,2,1,5,8,7,3,6,9] k=3 
     * 子序列为 
     * a[0]a[3]a[6] ==> [4,5,3] 
     * 1,4,7 ==> [2,8,6] 
     * 2,5,8 ==> [1,7,9] 
     * 时间复杂度分析 
     * 平均：O(nlogn)~O(n^2) 
     * 最好：O(n^1.3) 
     * 最坏：O(n^2) 
     * 空间复杂度：O(1) 
     * 不稳定 
     * https://juejin.im/post/5b4f06e2f265da0fab4012fd
     * https://blog.csdn.net/shuzfan/article/details/54967344
     *
     * 最后gap=1的希尔排序，就是直接插入排序
     * * */

    public static void shellSort(){
        int arr[] = { 5 , 2 , 6 , 0 , 9 ,1,3,8,4,7};
        //打印排序前的数据
        System.out.println("排序前的数据：");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        //希尔排序开始        
        // 设gap为增量    间隔 间隙    
        //设置初始化gap增量
        int addValue = 2;
        //设置gap为数组长度的一半
        int gap = arr.length /addValue;
        //外层 gap的赋值，直到最后为1
        for (; gap > 0; gap /= addValue){
            //最开始的比较的位置为 gap的位置；然后比较比gap小的数据；i一直增加到数组的长度
            //比如下标为： 2 4 6 8 10 12
            // gap 为 2；
            // 1. i=2，下标2 比较 下标0的数据
            // 2. i=3，下标3 比较 下标1的数据
            // 3. i=4，下标4 比较 下标2 然后下标0 的数据
            // 4. i=5，下标5 比较 下标3 然后下标1 的数据
            // 5. i=6  下标6 比较 下标6 然后下标4 然后下标2 然后下标0 的数据
            // ....
            // gap 为 1
            // 此时希尔排序为直接插入排序
            for (int i = gap; i < arr.length;i++){
                if(arr[i] < arr[i-gap]){
                    int temp = arr[i];
                    int k = i - gap;
                    //10 8 6 4 2 0 式的比较交换，最后插入temp值
                    while (k >=0 && arr[k] > temp){
                        arr[k+gap] = arr[k];
                        k -=gap;
                    }
                    arr[k+gap] = temp;
                }
            }
        }



        //打印排序后的数据
        System.out.println();
        System.out.println("排序后的数据：");
        for (int kk = 0; kk < arr.length; kk++) {
            System.out.print(arr[kk] + " ");
        }

    }
    //冒泡排序

    /**
     * 每次冒泡交换相邻两个元素，直到最后选出最大的元素
     * 外层次数为 n-1; n从1开始
     * 里层次数 为 n - i;
     */
    public static void BubbleSort(){
        int arr[] = { 5 , 2 , 6 , 0 , 9};
        System.out.println("排序前的数据：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //外层比较的次数
        for (int i = 1; i < arr.length; i++){
            //设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成
            boolean flag = true;
            for(int j = 0; j < arr.length - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }

        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //快速排序

    /**
     * 指定一个基准，分为左右两部分，判断比较交换
     * 左半部分，右半部分 递归重复上一步骤
     */
    public static void mainDemo(){
        int arr[] = { 5 , 2 , 6 , 0 , 9};
        System.out.println("排序前的数据：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        quickSort(arr,0,arr.length-1);

        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        //指定中轴线
        int pivot;
        if(low < high){
            pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }

    }

    public static int partition(int[] arr,int low,int high){
        int pivotKey = arr[low];
        while (low < high){
            while (high > low && arr[high] >= pivotKey){
                high--;
            }
            arr[low] = arr[high];
            while (high > low && arr[low] <= pivotKey){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low] = pivotKey;
        return low;
    }

    /**
     * 选择排序
         遍历数组，把最小（大）的元素放在数组首部，
         把剩下的元素看做一个数组，再次遍历，
         获得最小（大）的元素放在数组首部
         意在每次遍历新数组选择出最小（大）元素
     */
    public static void selectSort(){
        int arr[] = { 5 , 2 , 6 , 0 , 9};
        System.out.println("排序前的数据：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int temp = 0;
        //外层比较循环次数 n-1
        for (int i=0; i < arr.length -1; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                //找出最小元素下标
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }




}
