package com.wewe.arrowOffer;

import org.junit.Test;

import java.util.*;

/**
 * Author: fei2
 * Date:  19-6-8 下午2:56
 * Description:递归
 * Refer To:https://juejin.im/post/5b3b56045188251abe49f738
 */
public class CharCompose {



    /**
     * 回溯算法：是一种类似于枚举的搜索尝试过程，在搜索过程中寻找问题的解，当发现已不满足求解条件时，就返回 “回溯”，尝试别的路径；
     *
     * 回溯算法是递归算法中非常经典的思想，算法思想通常都应用在一类问题上，树型问题，问题本身没有定义在一棵二叉树上，具体分析这个问题，
     * 就会发现解决这个问题的思路本质是一棵树的形状。
     *
     */

    List<ArrayList<Integer>> result = new ArrayList<>();


    @Test
    public void testCompose(){
        String initString = "abcd";
        System.out.println(Permutation(initString).size()); //24
    }

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> arrayList = new ArrayList<>();

        if(str==null || str.length()==0) { return arrayList ; }
        char[] strArray = str.toCharArray();


        TreeSet<String> tmp = new TreeSet<>();
        recursion(strArray,0,tmp);
        arrayList.addAll(tmp);
        return arrayList;
    }
    //recursion 递归
    public void recursion(char[] strArray,int begin,TreeSet<String> result){
        if(strArray==null || strArray.length==0 || begin<0 || begin>strArray.length-1) { return ; }
        //begin 代表排列的个数已经满了
        if(begin==strArray.length-1){
            result.add(String.valueOf(strArray));
        } else {
            for(int i = begin; i < strArray.length; i++){
                swap(strArray,begin,i);
                recursion(strArray,begin + 1,result);
                swap(strArray,begin,i);
            }
        }

    }
    public void swap(char[] strArray,int a,int b){
        char t = strArray[a];
        strArray[a] = strArray[b];
        strArray[b] = t;
    }
    //https://blog.csdn.net/Iloveyougirls/article/details/55044401
    // https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51534048
    /*
    全排列是将一组数按一定顺序进行排列，如果这组数有n个，那么全排列数为n!个。现以{1, 2, 3, 4, 5}为例说明如何编写全排列的递归算法。

    1、首先看最后两个数4, 5。 它们的全排列为4 5和5 4, 即以4开头的5的全排列和以5开头的4的全排列。由于一个数的全排列就是其本身，从而得到以上结果。

    2、再看后三个数3, 4, 5。它们的全排列为3 4 5、3 5 4、 4 3 5、 4 5 3、 5 3 4、 5 4 3 六组数。即以3开头的和4,5的全排列的组合、以4开头的和3,5的全排列的组合和以5开头的和3,4的全排列的组合。

    从而可以推断，设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，pn = p - {rn}。
    因此perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。
    当n = 1时perm(p} = r1。为了更容易理解，将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
    */
    //全排列

    /**
     * {1,2,3}
     *
     * 输出
     *
        [1, 2, 3]
        [1, 3, 2]
        [2, 1, 3]
        [2, 3, 1]
        [3, 2, 1]
        [3, 1, 2]
        6
     *
     */
    @Test
    public void quanPaiLieTest(){
        int[] intArray = {1,2,3};

        quanPaiLie(intArray,0);

        for (int i = 0; i < result.size(); i++){
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }

    }
    public void quanPaiLie(int[] intArray,int begin){

        if (begin == intArray.length -1){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < intArray.length; i++){
                arrayList.add(intArray[i]);
            }
            result.add(arrayList);
            return;
        }

        for (int i = begin; i < intArray.length; i++){
            swapInt(intArray,begin,i);
            quanPaiLie(intArray,begin+1);
            swapInt(intArray,begin,i);
        }
    }

    public void swapInt(int[] intArray,int a,int b){
        int t = intArray[a];
        intArray[a] = intArray[b];
        intArray[b] = t;
    }
}


