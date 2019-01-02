package com.wewe.setExample;

import java.util.TreeSet;

/**
 * Author: fei2
 * Date:  18-9-5 下午4:28
 * Description: TreeSet采用红黑树的数据结构来存储集合元素。TreeSet支持两种排序方式: 自然排序、定制排序
 * Refer To:http://www.cnblogs.com/LittleHann/p/3690187.html
 *
 *   1) HashSet的性能总是比TreeSet好(特别是最常用的添加、查询元素等操作)，因为TreeSet需要额外的红黑树算法来维护集合元素的次序。只有当需要一个保持排序的Set时，才应该使用TreeSet，否则都应该使用HashSet
     2) 对于普通的插入、删除操作，LinkedHashSet比HashSet要略慢一点，这是由维护链表所带来的开销造成的。不过，因为有了链表的存在，遍历LinkedHashSet会更快
     3) EnumSet是所有Set实现类中性能最好的，但它只能保存同一个枚举类的枚举值作为集合元素
     4) HashSet、TreeSet、EnumSet都是"线程不安全"的，通常可以通过Collections工具类的synchronizedSortedSet方法来"包装"该Set集合。
     SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...));
 *
 */
public class TreeSetTest {

    /**
     * 自然排序：
     * TreeSet 使用集合的compareTo(Object obj)比较元素之间的大小关系。然后将集合按升序。即自然排序；
     * 一个对象放入到TreeSet时，该对象必须实现Comparable接口，否则抛出异常
     *
     * 根据compareTo（Object obj）与容器中的其他对象进行比较，
     * 然后根据红黑树结构找到存储位置。如果连个对象相等。新对象无法添加到TreeSet集合中（牢记Set是不允许重复的概念）
     * TreeSet 的去重是根据compareTo的大小；如果相等则被判断相等；不能添加到TreeSet中去；
     * HashSet去重是根据1.hashCode;2equals 相同；equals相同，hashCode一定相同。反之不成立。
     * https://blog.csdn.net/yxb_yingu/article/details/52194988
     *
     *  当把一个对象放入到TreeSet中，重写该对象对应类的equals()方法。应该保证改该方法与compareTo(Object obj)方法有一直的结果。
     *  equals() 返回true，compareTo(Object obj) 方法比较结果应该为 0(相等)
     *
     *  定制排序
     */
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        //向TreeSet中添加四个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        //输出集合元素，看到集合元素已经处于排序状态
        System.out.println(nums);

        //输出集合里的第一个元素
        System.out.println(nums.first());

        //输出集合里的最后一个元素
        System.out.println(nums.last());

        //返回小于4的子集，不包含4
        System.out.println(nums.headSet(4));

        //返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println(nums.tailSet(5));

        //返回大于等于-3，小于4的子集。
        System.out.println(nums.subSet(-3 , 4));
    }
}
