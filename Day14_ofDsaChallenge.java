import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                inStack.push(x);

            } else if (type == 2) {
                if (outStack.isEmpty()) {
                    while (!inStack.isEmpty()) {
                        outStack.push(inStack.pop());
                    }
                }
                outStack.pop();

            } else if (type == 3) {
                if (outStack.isEmpty()) {
                    while (!inStack.isEmpty()) {
                        outStack.push(inStack.pop());
                    }
                }
                System.out.println(outStack.peek());
            }
        }

        sc.close();
    }
}