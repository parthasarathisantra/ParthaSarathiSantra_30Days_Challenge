import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static void reversePrint(Node head) {
        if (head == null) return;

        reversePrint(head.next);
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  
        while (t-- > 0) {
            int n = sc.nextInt();  

            Node head = null, tail = null;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                Node newNode = new Node(x);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            reversePrint(head);
        }
        sc.close();
    }
}