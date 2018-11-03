package QueueStackAndBag;

import java.util.Iterator;

public class SimpleNodeList<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item value;
        Node next;
        Node(Item value){
            this.value = value;
        }
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        if(isEmpty()){
            first = new Node(item);
        }else{
            Node current = first;
            while (current.next != null) current = current.next;
            current.next = new Node(item);
        }
        N++;
    }
    public void removeTail(){
        if(isEmpty()) throw new RuntimeException();
        if(size() == 1){
            first = null;
        }else{
            Node current = first;
            while (current.next != null && current.next.next != null) current = current.next;
            current.next = null;
        }
        N--;
    }
    private class NodeListIterator implements Iterator<Item>{
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
        return new NodeListIterator();
    }
    public static void main(String[] args){
        SimpleNodeList<String> nodeList = new SimpleNodeList<>();

        System.out.println("=====methods====");
        System.out.println("isEmpty:" + nodeList.isEmpty());
        nodeList.add("test1!");
        nodeList.add("test2!");
        nodeList.removeTail();
        nodeList.add("hello world!");
        System.out.println("size:" + nodeList.size());
        System.out.println("isEmpty:" + nodeList.isEmpty());

        System.out.println("=====forEach====");
        for(String s : nodeList){
            System.out.println(s);
        }
    }
}
