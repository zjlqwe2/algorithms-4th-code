package QueueStackAndBag;

import java.util.Iterator;

public class LinkedBag<Item> implements Iterable<Item>{
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
    public void add(Item item){
        first = new Node(item, first);
        N++;
    }
    private class LinkedBagIterator implements Iterator<Item>{
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
        return new LinkedBagIterator();
    }
    public static void main(String[] args){
        LinkedBag<String> nodeList = new LinkedBag<>();

        System.out.println("=====methods====");
        System.out.println("isEmpty:" + nodeList.isEmpty());
        nodeList.add("test1!");
        nodeList.add("test2!");
        nodeList.add("hello world!");
        System.out.println("size:" + nodeList.size());
        System.out.println("isEmpty:" + nodeList.isEmpty());

        System.out.println("=====forEach====");
        for(String s : nodeList){
            System.out.println(s);
        }
    }
}
