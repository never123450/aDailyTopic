package array;

import sun.security.util.Length;

public class Array<E> {

   private E[] data;
   private int size;

   //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参数的构造函数，默认数组的初始容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素最后一个新的元素
    public void addLast(E e){
//        if (size==data.length){
//            throw new IllegalArgumentException("add last failed . array is full");
//        }
//        data[size] = e;
//        size++;
        add(size,e);
    }

    //在所有元素前加一个新元素
    public void addFirst(E e){
        add(0,e);
    }


    //在第index个位置插入一个新元素
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add last failed . array is full");
        }
        if (index<0 || index>size){
            throw new IllegalArgumentException("add last failed . array is full");
        }

        if (size == data.length){
            resize(2 * data.length);
        }

        for (int i=size-1;i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }


    //获取idnex索引位置的元素
    E get(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("add last failed . index is full");
        }
        return data[index];
    }

    //修改inde索引位置的元素为e
    void set(int index,E e){
        if (index<0 || index>size){
            throw new IllegalArgumentException("add last failed . index is full");
        }
        data[index] = e;
    }

    //查询数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查询数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for (int i = 0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除元素
    public E remove(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("add last failed . index is full");
        }

        E ret = data[index];
        for (int i=index+1;i<size-1;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length/2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    //删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //删除第一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index!=index){
            remove(index);
        }
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d ,capacity= %d\n",size,data.length));
        res.append('[');
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if (i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}