package com.wewe.vmware;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: fei2
 * Date:  19-3-13 下午8:51
 * Description:
 * Refer To:
 */
public class HeapOOM {
    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 可以将虚拟机内存溢出信息dump当前的内存堆转储快照以便事后处理 最小值-Xms 最大值 _Xmx
     *  堆内存溢出
     */
    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
