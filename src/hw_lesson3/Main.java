package hw_lesson3;

import lesson3.LinkedList;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<People> people = new MyLinkedList<People>();
        people.addFirst(new People("Max", 10));
        people.addFirst(new People("Sergey", 4));
        people.addFirst(new People("Dima", 13));
        people.addLast(new People("Misha", 11));


        People.printList(people);
        System.out.println();
        people.reversMyLinkedList();
        People.printList(people);
    }

}
