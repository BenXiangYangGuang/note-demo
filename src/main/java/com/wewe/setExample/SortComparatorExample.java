package com.wewe.setExample;

import java.util.Comparator;

/**
 * Author: fei2
 * Date:  18-9-6 下午4:08
 * Description:
 * Refer To:
 */
public class SortComparatorExample implements Comparator<String[]> {
    @Override
    public int compare(String[] o1, String[] o2) {

        long timeStampOne = Long.parseLong(o1[0]);
        String colNameOne = o1[1];
        double valueOne = Double.parseDouble(o1[2]);
        long timeStampTwo = Long.parseLong(o2[0]);
        String colNameTwo = o2[1];
        double valueTwo = Double.parseDouble(o2[2]);

        int timeStampResult = Long.compare(timeStampOne,timeStampTwo);
        int colNameResult = colNameOne.compareTo(colNameTwo);
        int valueResult = Double.compare(valueOne,valueTwo);
//        return timeStampResult == 0 ? colNameResult :timeStampResult;
//        return timeStampResult;
        return timeStampResult == 0 ? ((colNameResult == 0 ? -1 : colNameResult)) : timeStampResult;
    }
}
