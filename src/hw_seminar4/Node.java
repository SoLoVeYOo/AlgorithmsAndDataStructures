package hw_seminar4;

public class Node<T extends Comparable<T>>{

    public T value;
    public Node left;
    public Node right;
    public Color color;

    Node(T value) {
        this.value = value;
        this.color = Color.RED;
    }
}
