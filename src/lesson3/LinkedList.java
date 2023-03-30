package lesson3;

import java.util.Comparator;

public class LinkedList<T> {

    public Node head;


    public Node getHead() {
        return head;
    }

    public class Node{
        public T value;
        public Node next;

    }

    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    /**
     * Удалить первый элемент связанного списка
     */
    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
    }

    /**
     * Поиск элемента в связанном списке
     * @param value
     * @return
     */
    public Node contains(T value){
        Node node = head;
        while (node != null){
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    public void directSort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node){
                T buff = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buff;
            }

            node = node.next;
        }
    }

    /**
     * Добавить элемент в конец связанного списка
     * @param value
     */
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null)
            head = node;
        else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = node;
        }
    }

    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.next != null){
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;

    }


}
