package QueueStackAndBag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeArrayBag<Item> implements Iterable<Item>{
    private int N;
    private Item[] elements;
    private static int DEFAULT_CAPACITY = 2;

    /**
     * 没有指定stack初始容量，则调用默认的容量
     */
    ResizeArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 初始化
     * @param capacity 初始容量
     */
    ResizeArrayBag(int capacity){
        elements = (Item[]) new Object[capacity];

    }

    /**
     *
     * @return 堆是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回栈的长度
     * @return N
     */
    public int size(){
        return N;
    }
    /**
     * 往堆里增加元素
     * @param item 元素
     */
    public void add(Item item){
        if(N == elements.length){
            resize(N * 2);
        }
        elements[N++] = item;
    }
    /**
     * 重置elements数组的长度，使用系统函数速度更快
     * @param l 新的elements长度
     */
    private void resize(int l){
        elements = Arrays.copyOf(elements, l);
    }
    class BagIterator implements Iterator<Item>{
        int k = N - 1;
        @Override
        public boolean hasNext() {
            return k >= 0;
        }
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return elements[k--];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
    public static void main(String[] args){
        ResizeArrayBag<String> stack = new ResizeArrayBag<>();
        System.out.println("isEmpty:" + stack.isEmpty());
        stack.add("hello world!");
        stack.add("test!");

        // 测试遍历
        System.out.println("==forEach==");
        for(String s : stack){
            System.out.println(s);
        }

        System.out.println("==methods==");
        System.out.println("isEmpty:" + stack.isEmpty());
    }
}
