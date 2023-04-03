package hw_lesson4;

public class Main {
    public static void main(String[] args) {

        MyBinaryColorTree<Integer> bt = new MyBinaryColorTree<>();

        for (int i = 1; i <= 512; i++) {
            bt.addNode(i);
        }

        bt.printThreeUpperMost();

    }
}
