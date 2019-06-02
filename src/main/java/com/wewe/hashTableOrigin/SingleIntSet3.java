package com.wewe.hashTableOrigin;

/**
 * Author: fei2
 * Date:  19-5-23 下午3:57
 * Description:
 * Refer To:http://www.cnblogs.com/skywang12345/p/3311899.html
 */
public class SingleIntSet3 {
    private Object[] _values = new Object[10];

    private int H(int value)
    {
        if (value >= 0 && value <= 9)
            return value;
        else
            return value - 10;
    }


    public void Add(int item)
    {
        _values[H(item)] = item;
    }
    public void Remove(int item)
    {
        _values[H(item)] = null;
    }
    public boolean Contains(int item)
    {
        if (_values[H(item)] == null)
            return false;
        else
            return (int)_values[H(item)] == item;
    }

    public static void main(String[] args) {
        SingleIntSet3 set = new SingleIntSet3();
        set.Add(3);
        set.Add(17);
        System.out.println(set.Contains(3));  // 输出 true
        System.out.println(set.Contains(17)); // 输出 true
        System.out.println(set.Contains(13)); // 输出 false
        set.Add(13);
        System.out.println(set.Contains(13)); // 输出 true
        System.out.println(set.Contains(3));  // 输出 false. 但是应该输出 true 才对！
    }
}
