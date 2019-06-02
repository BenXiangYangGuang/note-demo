package com.wewe.arrow;

import org.junit.Test;

/**
 * Author: fei2
 * Date:  19-5-26 下午10:23
 * Description:
 * Refer To:
 */
public class First {
    @Test
    public void TwoArrayFind(){
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,array));
    }

    /**
     * 缩短相应的查找范围
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {

        int rowLength = array.length;
        int colLength = array[0].length;
        for(int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (target == array[i][j]) {
                    return true;
                } else if (target < array[i][j]) {
                    colLength = j;
                    break;
                }
            }
        }
        return false;
    }
    /**
     从左下角开始,左下角右边的比它大,左下角上边的比它小
     */
    public boolean FindTwo(int target, int [][] array) {
        int rowLength = array.length - 1;
        int i = 0;
        while (rowLength >= 0 && i < array[0].length){
            if(array[rowLength][i] > target){
                rowLength--;
            } else if(array[rowLength][i] < target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}


