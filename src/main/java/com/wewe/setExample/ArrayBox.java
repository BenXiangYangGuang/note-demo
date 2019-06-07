package com.wewe.setExample;

/**
 * Author: fei2
 * Date:  19-6-7 下午5:04
 * Description:
 * Refer To:
 */
public class ArrayBox implements Box{

    private final static int DEFAULT_SIZE = 10;

    //存储数组
    private int[] elementData;

    //已有元素个数
    private int size;

    public ArrayBox(){
        elementData = new int[DEFAULT_SIZE];
    }

    public ArrayBox(int capacity){
        elementData = new int[capacity];
    }

    private void ensureCapacityInternal(int minCapacity){
        if (minCapacity - elementData.length > 0){
            this.grow(minCapacity);
        }
    }
    private void grow(int minCapacity){

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        newCapacity = newCapacity < minCapacity ? minCapacity : newCapacity;
        elementData = this.copyOf(elementData,newCapacity);
    }
    private int[] copyOf(int[] oldArray,int newCapacity){
        int[] newArray = new int[newCapacity];
        //1 2 3 4 5 6
        //1 2 3 4 5 0
        for (int i = 0; i < size;i++){
            newArray[i]=oldArray[i];
        }
        return newArray;
    }

    //增加一个元素
    public boolean add(int element){
        this.ensureCapacityInternal(size + 1);
        elementData[size++] = element;
        return true;
    }

    //删除一个元素
    public int remove(int index){
        this.rangeCheck(index);
        int oldValue = get(index);
        //1 2 3 4 5 6
        //1 2 3 4 5 0
        for (int i = index; i < size-1;i++){
            elementData[i]=elementData[i+1];
        }
        elementData[--size]=0;
        return oldValue;
    }

    //取到一个元素
    public int get(int index){
        this.rangeCheck(index);
        return elementData[index];

    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            throw new ArrayOutOfBoundsException("index:" + index + ",size:" + size);
        }
    }

    public int size(){
        return this.size;
    }
    public int capacity(){
        return elementData.length;
    }
}
