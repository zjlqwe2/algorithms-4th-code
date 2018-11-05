package QueueStackAndBag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeArrayQueue<Item> implements Iterable<Item>{
    private int N;
    private Item[] elements;
    private static int DEFAULT_CAPACITY = 2;
    private int first;
    private int last;
    /**
     * 没有指定stack初始容量，则调用默认的容量
     */
    ResizeArrayQueue(){
        this(DEFAULT_CAPACITY);
    }
    /**
     * 初始化
     * @param capacity 初始容量
     */
    ResizeArrayQueue(int capacity){
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
    public void enqueue(Item item){
        if(N == elements.length){
            resize(N * 2);
        }
        N++;
        elements[last++] = item;
        if(last == elements.length) last = 0;
    }

    /**
     * 弹出堆最上层的元素
     * @return 堆最上层的元素
     */
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("queue underflow");
        Item result = elements[first];
        elements[first] = null;
        first++;
        N--;
        if(first == elements.length) first = 0;
        if(N > 0 && N == elements.length / 4){
            resize(elements.length / 2);
        }
        return result;
    }
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("stack underflow");
        return elements[first];
    }
    /**
     * 重置elements数组的长度，使用系统函数速度更快
     * @param l 新的elements长度
     */
    private void resize(int l){
        Item[] newElements = (Item[])new Object[l];
//        if(last < first){
//            System.arraycopy(elements, first, newElements, 0, elements.length - first);
//            System.arraycopy(elements, 0, newElements, elements.length - first, last + 1);
//        }else{
//            System.arraycopy(elements, first, newElements, 0, elements.length - first);
//            System.arraycopy(elements, 0, newElements, elements.length - first, first);
//        }
        for(int i = 0; i < N; i++){
            newElements[i] = elements[(first + i) % elements.length];
        }
        first = 0;
        last = N;
        elements = newElements;
//        elements = System.
    }
    class StackReverseIterator implements Iterator<Item>{
        int k = first;
        int count = 0;
        @Override
        public boolean hasNext() {
            return count < N;
        }
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item result =  elements[k++];
            if(k == N) k = 0;
            count++;
            return result;
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
        ResizeArrayQueue<String> queue = new ResizeArrayQueue<>();
        System.out.println("isEmpty:" + queue.isEmpty());
        queue.enqueue("hello world!");
        System.out.println("dequeue:" + queue.dequeue());
        for(int i = 0; i < 10; i++){
            queue.enqueue("test" + (i + 1));
        }
        for(int i = 0; i < 5; i++){
            queue.dequeue();
        }

        // 测试遍历
        System.out.println("==forEach==");
        for(String s : queue){
            System.out.println(s);
        }

        System.out.println("==methods==");
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("first:" + queue.peek());
        System.out.println("dequeue:" + queue.dequeue());
        System.out.println("size:" + queue.size());
        System.out.println("dequeue:" + queue.dequeue());

        // 测试异常
        System.out.println("dequeue:" + queue.dequeue());
    }
}
