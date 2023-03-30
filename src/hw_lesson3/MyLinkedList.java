package hw_lesson3;


public class MyLinkedList<T> {
    public Node head;
    public Node tail;

    public int count;


    public void addFirst(T value){
        Node<T> node = new Node<T>();
        node.value = value;
        if (head == null){
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
        }
        head = node;
        count++;
    }

    public void addLast(T value){
        Node<T> node = new Node<T>();
        node.value = value;
        if (head == null){
            head = node;
        } else {
            node.previous = tail;
            tail.next = node;
        }
        tail = node;
        count++;
    }

    public void removeFirst(){
        if (head != null && head.next != null){
            Node<T> node = head;
            node.next.previous = null;
            head = head.next;
            count--;
        }
        else{
            head = null;
            tail = null;
            count = 0;
        }
    }

    public void removeLast(){
        if (head != null && head.next != null){
            Node<T> node = tail;
            node.previous.next = null;
            tail = tail.previous;
            count--;
        } else {
            head = null;
            tail = null;
            count = 0;
        }
    }

    public Node<T> findNode(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void reversMyLinkedList(){

        Node<T> temp = head;
        head = tail;
        tail = temp;

        Node<T> node = head;

        while (node != null){
            temp = node.next;
            node.next = node.previous;
            node.previous = temp;
            node = node.next;
        }
    }

}
