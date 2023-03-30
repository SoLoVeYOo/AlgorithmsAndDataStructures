package hw_lesson3;

public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void printList(MyLinkedList<People> list) {
        Node<People> node = list.head;
        while (node != null) {
            System.out.printf("%s - %d\n", node.value.getName(), node.value.getAge());
            node = node.next;
        }
    }
}
