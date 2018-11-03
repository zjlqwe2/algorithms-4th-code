package QueueStackAndBag;

import java.util.NoSuchElementException;

public class NodeList<Item>{
    private Node first;
    private Node tail;
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
//        return first == null;
//        return N == 0;
        return size() == 0;
    }
    public int size(){
        return N;
    }
    public Item first(){
        if(isEmpty()) throw new NoSuchElementException("list is empty");
        return first.value;
    }
    public Item tail(){
        if(isEmpty()) throw new NoSuchElementException("list is empty");
        return tail.value;
    }
    public void insert(int index, Item value){
        if(index == 0){
            insertBeforeFirst(value);
            return;
        }
        Node next = get(index);

    }
    public void insertBeforeFirst(Item value){

    }
    private Node get(int index){
        if(index >= N) throw new RuntimeException();
        Node current = first;
        for(int i = 0; i < index; i++){
            current = first.next;
        }
        return current;
    }
}
