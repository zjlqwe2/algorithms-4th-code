package QueueStackAndBag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeArrayStack<Item> implements Iterable<Item>{
    private int N;
    private Item[] elements;
    private static int DEFAULT_CAPACITY = 2;

    /**
     * 没有指定stack初始容量，则调用默认的容量
     */
    ResizeArrayStack(){
        this(DEFAULT_CAPACITY);
    }
    /**
     * 初始化
     * @param capacity 初始容量
     */
    ResizeArrayStack(int capacity){
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
    public void push(Item item){
        if(N == elements.length){
            resize(N * 2);
        }
        elements[N++] = item;
    }

    /**
     * 弹出堆最上层的元素
     * @return 堆最上层的元素
     */
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        Item result = elements[--N];
        if(N > 0 && N == elements.length / 4){
            resize(elements.length / 2);
        }
        return result;
    }
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        return elements[N - 1];
    }
    /**
     * 重置elements数组的长度，使用系统函数速度更快
     * @param l 新的elements长度
     */
    private void resize(int l){
        elements = Arrays.copyOf(elements, l);
    }
    class StackReverseIterator implements Iterator<Item>{
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
        return new StackReverseIterator();
    }
    public static void main(String[] args){
        ResizeArrayStack<String> stack = new ResizeArrayStack<>();
        System.out.println("isEmpty:" + stack.isEmpty());
        stack.push("hello world!");
        stack.push("test!");

        // 测试遍历
        System.out.println("==forEach==");
        for(String s : stack){
            System.out.println(s);
        }

        System.out.println("==methods==");
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("peek:" + stack.peek());
        System.out.println("dequeue:" + stack.pop());
        System.out.println("size:" + stack.size());
        System.out.println("dequeue:" + stack.pop());

        // 测试异常
        System.out.println("dequeue:" + stack.pop());
    }
}
