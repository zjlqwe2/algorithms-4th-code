package QueueStackAndBag;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item value;
        Node next;
        Node(Item value){
            this.value = value;
        }
        Node(Item value, Node next){
            this(value);
            this.next = next;
        }

    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void enqueue(Item item){
        if(isEmpty()){
            first = last = new Node(item);
        }else{
            last.next = new Node(item);
            last = last.next;
        }
        N++;
    }
    public Item dequeue(){
        if(isEmpty()) throw new RuntimeException();
        Item result = first.value;
        first = first.next;
        N--;
        return result;
    }
    public Item first(){
        if(isEmpty()) throw new RuntimeException();
        return first.value;
    }
    private class StackIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            Item result = current.value;
            current = current.next;
            return result;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    public static void main(String[] args){
        LinkedQueue<String> queue = new LinkedQueue<>();

        System.out.println("=====methods====");
        System.out.println("isEmpty:" + queue.isEmpty());
        queue.enqueue("test1!");
        queue.enqueue("test2!");
        System.out.println("dequeue:" + queue.dequeue());
        queue.enqueue("hello world!");
        System.out.println("first:" + queue.first());
        System.out.println("size:" + queue.size());
        System.out.println("isEmpty:" + queue.isEmpty());

        System.out.println("=====forEach====");
        for(String s : queue){
            System.out.println(s);
        }
    }
}
