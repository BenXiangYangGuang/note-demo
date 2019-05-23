package com.wewe.algorithmExam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: fei2
 * Date:  19-5-23 上午10:07
 * Description:字符串匹配 暴力破解
 * Refer To:https://www.cnblogs.com/fuck1/p/6013543.html
 */
public class BruteForce {
    @Test
    public void BruteForceTest(){

        String src = "cddcdccdc";
        String sub = "cdc";

        int indexFirst = bruteForce(src,sub);
        System.out.println(indexFirst);
        String xx = src.substring(indexFirst,indexFirst + sub.length());
        System.out.println(xx);

    }
    /**
     *
     * @param src
     *            主串
     * @param sub
     *            字串（模式串）
     * 算法比较简单，缺点是每一次进行回溯效率不高，回溯往往是没有必要
     */
    public int bruteForce(String src, String sub) {
        int i = 0, j = 0;
        int index = -1;
        while (i < src.length() && j < sub.length()) {
            if (src.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                /**
                 * 这里理解一下下面的公式：该式子的目的是保证i的值在匹配不成功时不断向后+1 j其实表示已经成功匹配的字符数，
                 * i是一个不断累加的过程;
                 * j 表示已经移动的次数, i - j 表示最开始的位置, i - j + 1 代表 下一个 i 的位置
                 */
                i = i - j + 1;
                j = 0;
            }
        }
        // 判断
        //匹配完成之后,跳出while循环之前 i++; j++;
        if (j == sub.length()) {
            // 此处表示在index处开始匹配，并且后面完全匹配成功
            index = i - sub.length();
        }

        return index;
    }

    /**
     *  店旺通字符串匹配
     */
    @Test
    public void bruteForceTestChar(){

        String src = "cddcdccdccdddcccdc";
        String target = "cdc";

        char[] srcArray = src.toCharArray();
        char[] targetArray = target.toCharArray();
        String[] result = bruteForceChar(srcArray,targetArray);
        //cdd cdddcc
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }

    public String[] bruteForceChar(char[] srcArray,char[] targetArray){

        //匹配字符串的开始下标
        int[] resultIndex = new int[srcArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        int index = -1;
        while (i < srcArray.length){

            if (srcArray[i] == targetArray[j] && j < targetArray.length){
                i++;
                j++;
                if (j == targetArray.length){
                    index = i - j;
                    resultIndex[k] = index;
                    k++;
                    i = i - j + 1;
                    j = 0;
                }
            } else{
                i = i - j + 1;
                j = 0;
            }

        }
//        String[] result = new String[k-1];
        List<String> result = new ArrayList<>();
        for (int g = 0; g < k ; g++){

            if (resultIndex[g] == 0){

            } else {
                if (g == 0){
                    String temp = "";
                    for (int n = 0; n < resultIndex[g]; n++){

                        temp = temp + srcArray[n];
                    }
                    result.add(temp);
                } else {
                    if (resultIndex[g-1]+targetArray.length < resultIndex[g]){
                        String temp = "";
                        for(int u = resultIndex[g-1]+targetArray.length; u < resultIndex[g]; u++){
                            temp = temp + srcArray[u];
                        }
                        result.add(temp);
                    }
                }
            }
        }

        String[] array = result.toArray(new String[result.size()]);
        return array;
    }

}
