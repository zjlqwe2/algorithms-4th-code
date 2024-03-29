package QueueStackAndBag;

import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item>{
    private Node first;
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
    public void push(Item item){
        first = new Node(item, first);
        N++;
    }
    public Item pop(){
        if(isEmpty()) throw new RuntimeException();
        Item result = first.value;
        first = first.next;
        N--;
        return result;
    }
    public Item peek(){
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
        LinkedStack<String> stack = new LinkedStack<>();

        System.out.println("=====methods====");
        System.out.println("isEmpty:" + stack.isEmpty());
        stack.push("test1!");
        stack.push("test2!");
        System.out.println("dequeue:" + stack.pop());
        stack.push("hello world!");
        System.out.println("first:" + stack.peek());
        System.out.println("size:" + stack.size());
        System.out.println("isEmpty:" + stack.isEmpty());

        System.out.println("=====forEach====");
        for(String s : stack){
            System.out.println(s);
        }
    }
}
